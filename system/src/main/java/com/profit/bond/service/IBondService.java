package com.profit.bond.service;

import com.profit.bond.domain.BondBuyLog;
import com.profit.bond.domain.BondInfo;
import com.profit.bond.domain.BondSellLog;
import com.profit.bond.domain.BondStatistics;
import com.profit.bond.dto.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 股票信息Service接口
 * 
 * @author liulongling
 * @date 2023-12-10
 */
public interface IBondService
{

    StatisticsDTO loadStatisticsDTO(String gpId, Date startDate, Date endDate);

    Map<Object, Object> getProfitByDate(Date startDate, Date endDate);

    BondInfoDTO loadBondInfoDTO(BondInfo bondInfo);

    void loadSellAvgPrice(BondBuyLog bondBuyLog, BondBuyLogDTO buyLogDTO);

    void loadCurBondIncome(BondInfo bondInfo, BondBuyLog bondBuyLog, BondBuyLogDTO buyLogDTO);

    void buyBond(BondBuyLog bondBuyLog);

    ResultDO backBond(BondBuyLogDTO bondBuyLogDTO);

    BondStatistics refeshBondStatistics(double v, Double cost, double v1);

    void sellBond(BondSellLog bondSellLog);

    List<BondProfit> getBondProfits(Date monthStart, Date monthEnd);

    EChartsData countProfitByRequest(BondSellRequestDTO bondSellRequestDTO);

    EChartsData totalProfit();

    EChartsData countProfitByDay();

    EChartsData statisticsLog();

    List<BondBuyLogDTO> getBondBuyLogs(BondBuyLog bondBuyLog);

    TodayTaxationDTO loadToadyTaxationDTO(String gpId);

    Long getBondNumber(BondInfo bondInfo, Byte longLine);
}
