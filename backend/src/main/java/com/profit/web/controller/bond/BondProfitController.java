package com.profit.web.controller.bond;

import com.profit.bond.domain.BondInfo;
import com.profit.bond.dto.BondInfoDTO;
import com.profit.bond.dto.BondSellRequestDTO;
import com.profit.bond.dto.EChartsData;
import com.profit.bond.dto.ResultDO;
import com.profit.bond.service.IBondBuyLogService;
import com.profit.bond.service.IBondInfoService;
import com.profit.bond.service.IBondService;
import com.profit.common.constant.ResultCode;
import com.profit.common.core.controller.BaseController;
import com.profit.common.core.page.TableDataInfo;
import com.profit.common.utils.DateUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 股票信息Controller
 *
 * @author liulongling
 * @date 2023-12-10
 */
@Controller
@RequestMapping("/bond/profit")
public class BondProfitController extends BaseController {
    private String prefix = "/bond/profit";

    @Autowired
    private IBondInfoService bondInfoService;
    @Autowired
    private IBondBuyLogService bondBuyLogService;
    @Autowired
    private IBondService bondService;

    @RequiresPermissions("bond:profit:view")
    @GetMapping()
    public String info() {
        return prefix + "/selectBond";
    }

    /**
     * 查询股票信息列表
     */
    @RequiresPermissions("bond:profit:list")
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(@RequestParam Map<String, Object> params) throws Exception {
        startPage();
        BondInfo object = new BondInfo();
        if (params.get("isEtf") != null) {
            object.setIsEtf(Integer.valueOf(params.get("isEtf").toString()));
        }
        object.setStatus(0);
        List<BondInfo> bondInfos = bondInfoService.selectBondInfoList(object);
        List<BondInfoDTO> list = new ArrayList<>(bondInfos.size());
        //上月出售总收益
        Map<Date, Date> lastMonthMap = DateUtils.getLastMonthTime();
        Map<Object, Object> lastMonthProfitMap = bondService.getProfitByDate(lastMonthMap.get("startDate"), lastMonthMap.get("endDate"));

        //本月出售总收益
        Map<Object, Object> curMonthProfitMap = bondService.getProfitByDate(DateUtils.getMonthStart(), DateUtils.getMonthEnd());

        //今日出售总收益
        for (BondInfo bondInfo : bondInfos) {
            BondInfoDTO bondInfoDTO = bondService.loadBondInfoDTO(bondInfo);
            bondInfoDTO.setLastMonthProfit(lastMonthProfitMap.get(bondInfo.getId()) == null ? 0 : Double.parseDouble(String.format("%.2f", lastMonthProfitMap.get(bondInfo.getId()))));
            bondInfoDTO.setCurMonthProfit(curMonthProfitMap.get(bondInfo.getId()) == null ? 0 : Double.parseDouble(String.format("%.2f", curMonthProfitMap.get(bondInfo.getId()))));
            list.add(bondInfoDTO);
        }

        return getDataTable(list);
    }

    @PostMapping("/analyse")
    @ResponseBody
    public ResultDO<EChartsData> analyse(@RequestBody BondSellRequestDTO bondSellRequestDTO) {
        EChartsData eChartsData = null;
        if (bondSellRequestDTO.getType() == 1 && bondSellRequestDTO.getGpId() != null) {
            eChartsData = bondService.countProfitByRequest(bondSellRequestDTO);
        } else if (bondSellRequestDTO.getType() == 2) {
            eChartsData = bondService.totalProfit();
        } else if (bondSellRequestDTO.getType() == 3) {
            eChartsData = bondService.countProfitByDay();
        } else if (bondSellRequestDTO.getType() == 4) {
            eChartsData = bondService.statisticsLog();
        }
        return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, eChartsData);
    }
}
