package com.profit.web.controller.bond;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.profit.bond.comparator.ComparatorBondSell;
import com.profit.bond.domain.*;
import com.profit.bond.dto.BondBuyLogDTO;
import com.profit.bond.dto.BondBuyRequest;
import com.profit.bond.dto.ResultDO;
import com.profit.bond.service.IBondBuyLogService;
import com.profit.bond.service.IBondInfoService;
import com.profit.bond.service.IBondSellLogService;
import com.profit.bond.service.IBondService;
import com.profit.common.constant.BondConstants;
import com.profit.common.constant.ResultCode;
import com.profit.common.core.controller.BaseController;
import com.profit.common.core.page.TableDataInfo;
import com.profit.common.utils.BondUtils;
import com.profit.common.utils.DateUtils;
import com.profit.common.utils.bean.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 股票信息Controller
 *
 * @author liulongling
 * @date 2023-12-10
 */
@Controller
@RequestMapping("/bond/operating")
public class BondOperController extends BaseController {
    private String prefix = "/bond/operating";

    @Autowired
    private IBondInfoService bondInfoService;
    @Autowired
    private IBondBuyLogService bondBuyLogService;
    @Autowired
    private IBondSellLogService bondSellLogService;
    @Autowired
    private IBondService bondService;

    @RequiresPermissions("bond:oper:view")
    @GetMapping()
    public String info() {
        return prefix + "/transactionLogs";
    }

    @GetMapping("list")
    @ResponseBody
    public TableDataInfo getBonds(@RequestParam Map<String, Object> params) {
        String id = params.get("id").toString();
        BondInfo bondInfo = bondInfoService.selectBondInfoById(id);
        BondBuyLogExample bondBuyLogExample = new BondBuyLogExample();
        BondBuyLogExample.Criteria criteria = bondBuyLogExample.createCriteria();
        criteria.andGpIdEqualTo(id);
        bondBuyLogExample.setOrderByClause("oper_time desc");
        if (params.get("type") != null) {
            criteria.andTypeEqualTo(Byte.valueOf(params.get("type").toString()));
            if (params.get("type").equals("0")) {
                bondBuyLogExample.setOrderByClause("price desc");
            }
        }

        byte status = 0;
        if (params.get("status") != null) {
            status = Byte.valueOf(params.get("status").toString());
            criteria.andStatusEqualTo(status);
            if (status == 1) {
//                bondBuyLogExample.setOrderByClause("buy_date desc");
            } else {
                bondBuyLogExample.setOrderByClause("price desc");
            }
        }

        Page<Object> page = PageHelper.offsetPage(Integer.valueOf(params.get("offset").toString()), Integer.valueOf(params.get("limit").toString()));
        List<BondBuyLog> result = bondBuyLogService.selectByExample(bondBuyLogExample);
        List<BondBuyLogDTO> list = new ArrayList<>(result.size());
        for (int i = 0; i < result.size(); i++) {
            BondBuyLog bondBuyLog = result.get(i);
            //查看是否股票是否全部售出
            if (bondBuyLog.getCount().intValue() == bondBuyLog.getSellCount().intValue()) {
                if (bondBuyLog.getStatus() == 0) {
                    bondBuyLog.setStatus((byte) 1);
                    bondBuyLogService.updateBondBuyLog(bondBuyLog);
                }
            }
            BondBuyLogDTO buyLogDTO = BeanUtils.copyBean(new BondBuyLogDTO(), bondBuyLog);
            buyLogDTO.setName(bondInfo.getName());
            //卖出均价
            bondService.loadSellAvgPrice(bondBuyLog, buyLogDTO);
            //当前持股盈亏
            bondService.loadCurBondIncome(bondInfo, bondBuyLog, buyLogDTO);
            //与上一个买点的格差
            String girdSpacing = "0";
            if (i > 0) {
                girdSpacing = String.format("%.2f", ((bondBuyLog.getPrice() - result.get(i - 1).getPrice()) / bondBuyLog.getPrice()) * 100) + "%";
            }
            buyLogDTO.setGirdSpacing(girdSpacing);
            if (bondBuyLog.getFinancing() == 1) {
                buyLogDTO.setName(buyLogDTO.getName() + "(融)");
                Double lendMoney = ((bondBuyLog.getCount() - bondBuyLog.getSellCount()) * bondBuyLog.getPrice() - bondBuyLog.getBackMoney()) + bondBuyLog.getBuyCost();
                Date lendDate;
                if (bondBuyLog.getBackTime() != null) {
                    lendDate = bondBuyLog.getBackTime();
                } else {
                    lendDate = DateUtils.string2Date(bondBuyLog.getBuyDate(), DateUtils.YYYY_MM_DD);
                }
                buyLogDTO.setInterest(BondUtils.countInterest(lendMoney, lendDate));
            } else {
                buyLogDTO.setInterest(0.0);
            }

            list.add(buyLogDTO);
            if (status == 1) {
                Collections.sort(list, new ComparatorBondSell());
            }
        }

        return getDataTable(list);
    }

    @PostMapping("buy")
    public ResultDO<Void> buy(@RequestBody BondBuyRequest bondBuyRequest) {
        BondBuyLog bondBuyLog = BeanUtils.copyBean(new BondBuyLog(), bondBuyRequest);
        bondService.buyBond(bondBuyLog);
        if (bondBuyRequest.getSellPrice() != null && bondBuyRequest.getSellPrice() > 0 && bondBuyLog.getId() > 0) {
            Date date = DateUtils.string2Date(bondBuyRequest.getSellDate(), DateUtils.YYYY_MM_DD);
            date.setHours(8);
            BondSellLog bondSellLog = new BondSellLog();
            bondSellLog.setBuyId(bondBuyLog.getId());
            bondSellLog.setGpId(bondBuyLog.getGpId());
            bondSellLog.setPrice(bondBuyRequest.getSellPrice());
            bondSellLog.setCount(bondBuyRequest.getCount());
            bondSellLog.setCreateTime(date);

            bondService.sellBond(bondSellLog);
        }
        return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, null);
    }

    @PostMapping("sell")
    public ResultDO<Void> sell(@RequestBody BondSellLog bondSellLog) {
        bondService.sellBond(bondSellLog);
        return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, null);
    }

    @PostMapping("back")
    public ResultDO<Void> back(@RequestBody BondBuyLogDTO bondBuyLogDTO) {
        return bondService.backBond(bondBuyLogDTO);
    }


    @PostMapping("update")
    public ResultDO<Void> update(@RequestBody BondBuyLog bondBuyLogRequest) {
        BondBuyLog bondBuyLog = bondBuyLogService.selectBondBuyLogById(bondBuyLogRequest.getId());
        BondInfo bondInfo = bondInfoService.selectBondInfoById(bondBuyLog.getGpId());
        bondBuyLog.setOperTime(new Date());
        bondBuyLog.setPrice(bondBuyLogRequest.getPrice());
        bondBuyLog.setCount(bondBuyLogRequest.getCount());
        bondBuyLog.setBuyDate(bondBuyLogRequest.getBuyDate());
        bondBuyLog.setFinancing(bondBuyLogRequest.getFinancing());
        bondBuyLog.setRemarks(bondBuyLogRequest.getRemarks());

        boolean isBuy = false;
        if (bondBuyLog != null && bondBuyLog.getStatus() == BondConstants.WAIT_BUY && bondBuyLogRequest.getStatus() == BondConstants.NOT_SELL) {
            isBuy = true;
        }

        if (bondBuyLogRequest.getType() != null) {
            bondBuyLog.setType(bondBuyLogRequest.getType());
        }

        if (bondBuyLogRequest.getStatus() != null) {
            bondBuyLog.setStatus(bondBuyLogRequest.getStatus());
        }

        //未出售的状态下才能修改税费
        if (bondBuyLog.getStatus() == BondConstants.NOT_SELL) {
            Double buyCost = BondUtils.getTaxation(bondInfo.getPlate(),bondInfo.getIsEtf(), bondBuyLog.getPrice() * bondBuyLog.getCount(), false);
            bondBuyLog.setCost(Double.parseDouble(String.format("%.2f", buyCost)));
            bondBuyLog.setBuyCost(Double.parseDouble(String.format("%.2f", buyCost)));
            bondBuyLog.setTotalPrice(Double.parseDouble(String.format("%.2f", bondBuyLogRequest.getPrice() * bondBuyLogRequest.getCount())));
        }


        bondBuyLogService.updateBondBuyLog(bondBuyLog);

        if (isBuy) {
            bondService.refeshBondStatistics(bondBuyLog.getCount() * bondBuyLog.getPrice(), bondBuyLog.getCost(), 0.5);
        }
        return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, null);
    }

    @PostMapping("delete")
    public ResultDO<Void> delete(@RequestBody BondBuyLog bondBuyLog) {
        bondBuyLogService.deleteBondBuyLogById(bondBuyLog.getId());
        //查询是否有出售
        BondSellLogExample bondSellLogExample = new BondSellLogExample();
        bondSellLogExample.createCriteria().andBuyIdEqualTo(bondBuyLog.getId());
        List<BondSellLog> bondSellLogs = bondSellLogService.selectByExample(bondSellLogExample);
        if (bondSellLogs != null) {
            for (BondSellLog bondSellLog : bondSellLogs) {
                bondSellLogService.deleteBondSellLogById(bondSellLog.getId());
            }
        }

        return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, null);
    }
}
