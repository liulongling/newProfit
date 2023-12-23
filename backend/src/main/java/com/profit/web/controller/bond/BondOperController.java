package com.profit.web.controller.bond;

import com.profit.bond.domain.*;
import com.profit.bond.dto.BondBuyLogDTO;
import com.profit.bond.dto.BondBuyRequest;
import com.profit.bond.dto.ResultDO;
import com.profit.bond.service.IBondBuyLogService;
import com.profit.bond.service.IBondInfoService;
import com.profit.bond.service.IBondSellLogService;
import com.profit.bond.service.IBondService;
import com.profit.common.annotation.Log;
import com.profit.common.constant.BondConstants;
import com.profit.common.constant.ResultCode;
import com.profit.common.core.controller.BaseController;
import com.profit.common.core.domain.AjaxResult;
import com.profit.common.core.page.TableDataInfo;
import com.profit.common.enums.BusinessType;
import com.profit.common.utils.BondUtils;
import com.profit.common.utils.DateUtils;
import com.profit.common.utils.bean.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 股票信息Controller
 *
 * @author liulongling
 * @date 2023-12-10
 */
@Controller
@RequestMapping("/bond/oper")
public class BondOperController extends BaseController {
    private String prefix = "/bond/oper";

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

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BondBuyLog bondBuyLog)
    {
        startPage();
        List<BondBuyLogDTO> list = bondService.getBondBuyLogs(bondBuyLog);
        return getDataTable(list);
    }

    /**
     * 修改股票购买日志
     */
    @RequiresPermissions("bond:oper:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        BondBuyLog bondBuyLog = bondBuyLogService.selectBondBuyLogById(id);
        mmap.put("bondBuyLog", bondBuyLog);
        return prefix + "/edit";
    }

    /**
     * 修改保存股票购买日志
     */
    @RequiresPermissions("bond:oper:edit")
    @Log(title = "股票购买日志", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BondBuyLog bondBuyLog)
    {
        return toAjax(bondBuyLogService.updateBondBuyLog(bondBuyLog));
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
