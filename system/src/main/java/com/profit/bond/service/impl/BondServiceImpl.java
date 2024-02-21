package com.profit.bond.service.impl;

import com.profit.bond.comparator.ComparatorBondSell;
import com.profit.bond.comparator.ComparatorProfit;
import com.profit.bond.domain.*;
import com.profit.bond.domain.BondBuyLogExample;
import com.profit.bond.dto.*;
import com.profit.bond.domain.BondSellLogExample;
import com.profit.bond.mapper.BondBuyLogMapper;
import com.profit.bond.mapper.BondSellLogMapper;
import com.profit.bond.mapper.BondStatisticsLogMapper;
import com.profit.bond.mapper.BondStatisticsMapper;
import com.profit.bond.service.IBondBuyLogService;
import com.profit.bond.service.IBondInfoService;
import com.profit.bond.service.IBondService;
import com.profit.common.constant.BondConstants;
import com.profit.common.constant.ResultCode;
import com.profit.common.utils.BondUtils;
import com.profit.common.utils.DateUtils;
import com.profit.common.utils.StringUtils;
import com.profit.common.utils.bean.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 股票购买日志Service业务层处理
 *
 * @author liulongling
 * @date 2023-12-11
 */
@Service
public class BondServiceImpl implements IBondService {
    @Autowired
    private BondBuyLogMapper bondBuyLogMapper;
    @Autowired
    private IBondBuyLogService bondBuyLogService;
    @Autowired
    private IBondInfoService bondInfoService;
    @Autowired
    private BondSellLogMapper bondSellLogMapper;
    @Autowired
    private BondStatisticsMapper bondStatisticsMapper;
    @Resource
    private BondStatisticsLogMapper bondStatisticsLogMapper;

    @Override
    public List<BondBuyLogDTO> getBondBuyLogs(BondBuyLog bondBuyLogRequest){
        byte status = 0;
        String id = bondBuyLogRequest.getGpId();
        Byte type = bondBuyLogRequest.getType();
        BondInfo bondInfo = bondInfoService.selectBondInfoById(id);
        BondBuyLogExample bondBuyLogExample = new BondBuyLogExample();
        BondBuyLogExample.Criteria criteria = bondBuyLogExample.createCriteria();
        criteria.andGpIdEqualTo(id);
        criteria.andStatusEqualTo(status);
        if(type != null){
            criteria.andTypeEqualTo(type);
        }
        bondBuyLogExample.setOrderByClause("price desc");

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
            buyLogDTO.setCurPrice(bondInfo.getPrice());
            //卖出均价
            loadSellAvgPrice(bondBuyLog, buyLogDTO);
            //当前持股盈亏
            loadCurBondIncome(bondInfo, bondBuyLog, buyLogDTO);
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
        return list;
    }

    /**
     * 股票数据
     *
     * @param gpId null 查所有股票
     * @return
     */
    @Override
    public StatisticsDTO loadStatisticsDTO(String gpId, Date startDate, Date endDate) {
        StatisticsDTO statisticsDTO = new StatisticsDTO();
        //查询收益情况
        Map<Object, Object> todayProfitMap = getProfitByDate(startDate, endDate);
        Double profit = 0.00;
        if (todayProfitMap != null) {
            if (gpId != null) {
                profit = Double.parseDouble(String.format("%.2f", todayProfitMap.get(gpId)));
            } else {
                for (Object key : todayProfitMap.keySet()) {
                    profit += Double.parseDouble(String.format("%.2f", todayProfitMap.get(key)));
                }
            }
        }
        statisticsDTO.setProfit(Double.parseDouble(String.format("%.2f", profit)));

        //止损金额
        BondSellRequestDTO bondSellRequestDTO = new BondSellRequestDTO();
        bondSellRequestDTO.setStartTime(DateUtils.getTimeString(startDate));
        bondSellRequestDTO.setEndTime(DateUtils.getTimeString(endDate));
        statisticsDTO.setLossProfit(Double.parseDouble(String.format("%.2f", bondSellLogMapper.sumLossIncome(bondSellRequestDTO))));

        //利息
        double interest = Double.parseDouble(String.format("%.2f", bondSellLogMapper.sumInterest(bondSellRequestDTO)));
        statisticsDTO.setInterest(-interest);

        //查询买入金额
        List<BondBuyLog> buyLogs = getBondBuyLogs(gpId, DateUtils.getDateString(startDate, DateUtils.YYYY_MM_DD), DateUtils.getDateString(endDate, DateUtils.YYYY_MM_DD));
        Double buyAmount = 0.0;
        if (buyLogs != null) {
            for (BondBuyLog bondBuyLog : buyLogs) {
                buyAmount += bondBuyLog.getPrice() * bondBuyLog.getCount();
            }
        }
        statisticsDTO.setBuyAmount(Double.parseDouble(String.format("%.2f", buyAmount)));

        //查询卖出金额
        List<BondSellLog> sellLogs = getBondSellLogs(gpId, startDate, endDate);
        Double sellAmount = 0.0;
        Double cost = 0.0;
        Double maxProfit = 0.0;
        Double maxLoss = 0.0;
        if (buyLogs != null) {
            for (BondSellLog bondSellLog : sellLogs) {
                if (bondSellLog.getIncome() > 0) {
                    statisticsDTO.incrProfitNumber();
                } else {
                    statisticsDTO.incrPlossNumber();
                }
                if (bondSellLog.getIncome() > maxProfit) {
                    maxProfit = bondSellLog.getIncome();
                }
                if (bondSellLog.getIncome() < maxLoss) {
                    maxLoss = bondSellLog.getIncome();
                }
                sellAmount += bondSellLog.getPrice() * bondSellLog.getCount();
                cost += bondSellLog.getCost();
            }
        }
        statisticsDTO.setSellAmount(Double.parseDouble(String.format("%.2f", sellAmount)));
        statisticsDTO.setCost(Double.parseDouble(String.format("%.2f", cost)));
        if (statisticsDTO.getTotalNumber() > 0) {
            statisticsDTO.setWinning(StringUtils.pencentWin(statisticsDTO.getProfitNumber(), statisticsDTO.getTotalNumber()));
        }

        return statisticsDTO;
    }


    @Override
    public List<BondProfit> getBondProfits(Date startDate, Date endDate) {
        //top
        Map<Object, Object> profitByDate = getProfitByDate(startDate, endDate);
        List<BondProfit> bondProfits = new ArrayList<>();
        for (Object key : profitByDate.keySet()) {
            BondProfit bondProfit = new BondProfit();
            BondInfo bondInfo = bondInfoService.selectBondInfoById(key.toString());
            bondProfit.setName(bondInfo.getName());
            bondProfit.setMoney(Double.parseDouble(String.format("%.2f", Double.parseDouble(profitByDate.get(key).toString()))));
            bondProfits.add(bondProfit);
        }
        Collections.sort(bondProfits, new ComparatorProfit());
        return bondProfits.subList(0, bondProfits.size() >= 10 ? 10 : bondProfits.size());
    }

    @Override
    public EChartsData countProfitByRequest(BondSellRequestDTO bondSellRequestDTO) {
        EChartsData eChartsData = new EChartsData();
        BondInfo bondInfo = bondInfoService.selectBondInfoById(bondSellRequestDTO.getGpId());
        eChartsData.setText(bondInfo.getName());
        //近30天收益
        Date startDate = DateUtils.getNeverDayStartTime(180);
        String endDate = DateUtils.getTimeString(DateUtils.getTodayDateTime(23, 59, 59));
        Map<Object, Object> unsortMap = getProfitByGpId(bondSellRequestDTO.getGpId(), DateUtils.getDateString(startDate), endDate);
        Map<Object, Object> lastMonthProfitMap = new TreeMap<>(unsortMap);
        List<Object> incomeDateList = new ArrayList<>(lastMonthProfitMap.keySet());
        eChartsData.getXAxis().addAll(((List<String>) (List) incomeDateList));


        EChartsElement eChartsElement = new EChartsElement();
        eChartsElement.setName("Direct");
        eChartsElement.setType("bar");
        eChartsElement.setBarWidth("50%");

        List<Double> incomeList = new ArrayList<>();
        for (Object object : lastMonthProfitMap.values()) {
            incomeList.add(Double.parseDouble(String.format("%.0f", object)));
        }
        eChartsElement.setData(incomeList);

        List<EChartsElement> series = new ArrayList<>();
        series.add(eChartsElement);
        eChartsData.setSeries(series);
        return eChartsData;
    }

    private Map<Object, Object> getProfitByGpId(String gpId, String startTime, String endTime) {
        BondSellRequestDTO bondSellRequestDTO = new BondSellRequestDTO();
        bondSellRequestDTO.setStartTime(startTime);
        bondSellRequestDTO.setEndTime(endTime);
        bondSellRequestDTO.setGpId(gpId);
        List<Map<Object, Object>> profitList = bondSellLogMapper.listIncomeGroupByDate(bondSellRequestDTO);
        return BeanUtils.list2Map(profitList, "incomeDate", "income");
    }

    @Override
    public EChartsData totalProfit() {
        EChartsData eChartsData = new EChartsData();
        eChartsData.setText("收益分析");
        eChartsData.getLegend().add("短线收益");
        eChartsData.getLegend().add("长线收益");
        eChartsData.getLegend().add("总收益");

        ProfitDTO profitDTO = new ProfitDTO();
        for (int i = 1; i <= 12; i++) {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int curMonth = calendar.get(Calendar.MONTH) + 1;
            if (i > curMonth) {
                continue;
            }
            String month = i < 10 ? ("0" + i) : String.valueOf(i);
            profitDTO.getDate().add(year + month);
            eChartsData.getXAxis().add(year + month);

            BondSellRequestDTO bondSellRequestDTO = new BondSellRequestDTO();
            bondSellRequestDTO.setStartTime(DateUtils.getFirstDayOfMonth(i));
            bondSellRequestDTO.setEndTime(DateUtils.getLastDayOfMonth(i));

            //短线收益
            bondSellRequestDTO.setType(0);
            Double gridProfit = Double.parseDouble(String.format("%.2f", bondSellLogMapper.sumIncomeByType(bondSellRequestDTO)));
            profitDTO.getGridProfit().add(gridProfit);

            //短线收益
            bondSellRequestDTO.setType(1);
            Double stubProfit = Double.parseDouble(String.format("%.2f", bondSellLogMapper.sumIncomeByType(bondSellRequestDTO)));
            profitDTO.getStubProfit().add(stubProfit);


            profitDTO.getTotalProfit().add(Double.parseDouble(String.format("%.2f", gridProfit + stubProfit)));

            Double lossProfit = Double.parseDouble(String.format("%.2f", bondSellLogMapper.sumLossIncome(bondSellRequestDTO)));
            profitDTO.getLossProfit().add(lossProfit);

            Double cost = Double.parseDouble(String.format("%.2f", bondSellLogMapper.sumCost(bondSellRequestDTO)));
            profitDTO.getCost().add(cost);
        }
        for (String s : eChartsData.getLegend()) {
            eChartsData.getSeries().add(loadEChartsElement(s, profitDTO));
        }
        return eChartsData;
    }


    public EChartsElement loadEChartsElement(String s, ProfitDTO profitDTO) {
        List<Double> list = new ArrayList<>();
        if (s.equals("短线收益")) {
            list = profitDTO.getStubProfit();
        } else if (s.equals("长线收益")) {
            list = profitDTO.getGridProfit();
        } else if (s.equals("总收益")) {
            list = profitDTO.getTotalProfit();
        }
        EChartsElement eChartsElement = new EChartsElement();
        eChartsElement.setName(s);
        eChartsElement.setType("line");
//        eChartsElement.setStack("Total");
        eChartsElement.setData(list);
        return eChartsElement;
    }

    private TotalProfitDTO loadTotalProfitDTO() {
        TotalProfitDTO totalProfitDTO = new TotalProfitDTO();
        BondSellLogExample bondSellLogExample = new BondSellLogExample();
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);

        bondSellLogExample.createCriteria().andGpIdNotEqualTo("131810").andIncomeGreaterThan(0.0).andCreateTimeBetween(DateUtils.getBeginTime(year, 1), DateUtils.getEndTime(year, 12));
        Long totalProfitNumber = bondSellLogMapper.countByExample(bondSellLogExample);
        totalProfitDTO.setTotalProfitNumber(totalProfitNumber.intValue());

        bondSellLogExample = new BondSellLogExample();
        bondSellLogExample.createCriteria().andGpIdNotEqualTo("131810").andIncomeLessThan(0.0).andCreateTimeBetween(DateUtils.getBeginTime(year, 1), DateUtils.getEndTime(year, 12));
        long totalLossNumber = bondSellLogMapper.countByExample(bondSellLogExample);
        totalProfitDTO.setTotalLossNumber(totalLossNumber);
        if (totalProfitNumber + totalLossNumber > 0) {
            //胜率=获胜场次÷总比赛场次x100%
            totalProfitDTO.setAvgWinning(StringUtils.pencentWin(totalProfitNumber, totalProfitNumber + totalLossNumber));
        }

        BondSellRequestDTO bondSellRequestDTO = new BondSellRequestDTO();
        bondSellRequestDTO.setStartTime(DateUtils.getTimeString(DateUtils.getBeginTime(year, 1)));
        bondSellRequestDTO.setEndTime(DateUtils.getTimeString(DateUtils.getEndTime(year, 12)));

        Double totalProfit = bondSellLogMapper.sumIncome(bondSellRequestDTO);
        totalProfitDTO.setTotalProfit(Double.parseDouble(String.format("%.2f", totalProfit)));

        List<BondInfo> bondInfos = bondInfoService.selectBondInfoList(new BondInfo());
        Double stockValue = 0.0;
        Double todayStockProfit = 0.0;

        for (BondInfo bondInfo : bondInfos) {
            BondInfoDTO bondInfoDTO = loadBondInfoDTO(bondInfo);
            stockValue += bondInfoDTO.getMarket();
            todayStockProfit += bondInfoDTO.getTodayStockProfit();
        }

        totalProfitDTO.setTodayStockProfit(Double.parseDouble(String.format("%.2f", todayStockProfit)));
        totalProfitDTO.setStockValue(Double.parseDouble(String.format("%.2f", stockValue)));
        totalProfitDTO.setLossMoney(Double.parseDouble(String.format("%.2f", bondSellLogMapper.sumLossIncome(bondSellRequestDTO))));
        totalProfitDTO.setCost(Double.parseDouble(String.format("%.2f", bondSellLogMapper.sumCost(bondSellRequestDTO))));
        return totalProfitDTO;
    }

    @Override
    public EChartsData countProfitByDay() {
        EChartsData eChartsData = new EChartsData();
        eChartsData.setText("每日菜钱");
        //近30天收益
        Date startDate = DateUtils.getNeverDayStartTime(180);
        String endDate = DateUtils.getTimeString(DateUtils.getTodayDateTime(23, 59, 59));
        Map<Object, Object> unsortMap = getAllBondProfitByDate(DateUtils.getDateString(startDate), endDate);
        Map<Object, Object> lastMonthProfitMap = new TreeMap<>(unsortMap);
        List<Object> incomeDateList = new ArrayList<>(lastMonthProfitMap.keySet());
        eChartsData.getXAxis().addAll(((List<String>) (List) incomeDateList));


        EChartsElement eChartsElement = new EChartsElement();
        eChartsElement.setName("Direct");
        eChartsElement.setType("line");
        eChartsElement.setBarWidth("50%");

        List<Double> incomeList = new ArrayList<>();
        for (Object object : lastMonthProfitMap.values()) {
            incomeList.add(Double.parseDouble(String.format("%.0f", object)));
        }
        eChartsElement.setData(incomeList);

        List<EChartsElement> series = new ArrayList<>();
        series.add(eChartsElement);
        eChartsData.setSeries(series);
        return eChartsData;
    }


    /**
     * 查询指定范围内所有股票收益
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    public Map<Object, Object> getAllBondProfitByDate(String startTime, String endTime) {
        BondSellRequestDTO bondSellRequestDTO = new BondSellRequestDTO();
        bondSellRequestDTO.setStartTime(startTime);
        bondSellRequestDTO.setEndTime(endTime);
        List<Map<Object, Object>> profitList = bondSellLogMapper.listIncomeGroupByDate(bondSellRequestDTO);
        return BeanUtils.list2Map(profitList, "incomeDate", "income");
    }

    @Override
    public EChartsData statisticsLog() {
        EChartsData eChartsData = new EChartsData();
        eChartsData.setText("历史数据分析");
        eChartsData.getLegend().add("市值");
        eChartsData.getLegend().add("现金");
        eChartsData.getLegend().add("负债");
        eChartsData.getLegend().add("盈亏");

        BondStatisticsLogExample bondStatisticsLogExample = new BondStatisticsLogExample();
        bondStatisticsLogExample.setOrderByClause("create_time asc limit 0 ,30");
        List<BondStatisticsLog> bondStatisticsLogs = bondStatisticsLogMapper.selectByExample(bondStatisticsLogExample);
        for (BondStatisticsLog bondStatisticsLog : bondStatisticsLogs) {
            eChartsData.getXAxis().add(DateUtils.getDateString(bondStatisticsLog.getCreateTime(), DateUtils.YYYYMMDD));
        }

        for (String s : eChartsData.getLegend()) {
            List<Double> list = new ArrayList<>();
            for (BondStatisticsLog bondStatisticsLog : bondStatisticsLogs) {
                if (s.equals("市值")) {
                    list.add(Double.parseDouble(String.format("%.0f", bondStatisticsLog.getStock())));
                } else if (s.equals("现金")) {
                    list.add(Double.parseDouble(String.format("%.0f", bondStatisticsLog.getReady())));
                } else if (s.equals("负债")) {
                    list.add(Double.parseDouble(String.format("%.0f", bondStatisticsLog.getLiability())));
                } else if (s.equals("盈亏")) {
                    list.add(Double.parseDouble(String.format("%.0f", bondStatisticsLog.getProfit())));
                }
            }

            EChartsElement eChartsElement = new EChartsElement();
            eChartsElement.setName(s);
            eChartsElement.setType("line");
            eChartsElement.setData(list);

            eChartsData.getSeries().add(eChartsElement);
        }
        return eChartsData;
    }

    /**
     * 查询时间范围内股票出售记录
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return
     */
    public List<BondSellLog> getBondSellLogs(String gpId, Date startDate, Date endDate) {
        BondSellLogExample bondSellLogExample = new BondSellLogExample();
        BondSellLogExample.Criteria criteria = bondSellLogExample.createCriteria();
        criteria.andCountGreaterThan(0);
        criteria.andCreateTimeBetween(startDate, endDate);
        if (gpId != null) {
            criteria.andGpIdEqualTo(gpId);
        }
        bondSellLogExample.createCriteria().andCreateTimeBetween(startDate, endDate);
        return bondSellLogMapper.selectByExample(bondSellLogExample);
    }


    /**
     * 查询指定时间购买记录
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public List<BondBuyLog> getBondBuyLogs(String gpId, String startDate, String endDate) {
        BondBuyLogExample bondBuyLogExample = new BondBuyLogExample();
        BondBuyLogExample.Criteria criteria = bondBuyLogExample.createCriteria();
        criteria.andBuyDateBetween(startDate, endDate);
        criteria.andStatusBetween(BondConstants.NOT_SELL, BondConstants.SOLD);
        if (gpId != null) {
            criteria.andGpIdEqualTo(gpId);
        }
        return bondBuyLogMapper.selectByExample(bondBuyLogExample);
    }


    /**
     * 查询指定时间内股票收益
     * x
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return
     */
    @Override
    public Map<Object, Object> getProfitByDate(Date startDate, Date endDate) {
        BondSellRequestDTO bondSellRequestDTO = new BondSellRequestDTO();
        bondSellRequestDTO.setStartTime(DateUtils.getTimeString(startDate));
        bondSellRequestDTO.setEndTime(DateUtils.getTimeString(endDate));
        List<Map<Object, Object>> profitList = bondSellLogMapper.listGroupByGpId(bondSellRequestDTO);
        return BeanUtils.list2Map(profitList, "gpId", "income");
    }

    /**
     * 卖出均价 = (卖出数量*买入价格+ 收益) / 卖出数量
     *
     * @param bondBuyLog
     * @param buyLogDTO
     */
    @Override
    public void loadSellAvgPrice(BondBuyLog bondBuyLog, BondBuyLogDTO buyLogDTO) {
        if (bondBuyLog.getSellCount() <= 0) {
            return;
        }
        //卖出均价= (卖出数量*买入价格+ 收益) / 卖出数量
        double sellAvgPrice = (bondBuyLog.getPrice() * bondBuyLog.getSellCount() + bondBuyLog.getSellIncome() + bondBuyLog.getCost()) / bondBuyLog.getSellCount();
        Double avg = Double.parseDouble(String.format("%.3f", sellAvgPrice));
        buyLogDTO.setSellAvgPrice(avg + "(" + String.format("%.2f", ((avg - bondBuyLog.getPrice()) / avg) * 100) + "%)");
        BondSellLogExample bondSellLogExample = new BondSellLogExample();
        bondSellLogExample.createCriteria().andBuyIdEqualTo(buyLogDTO.getId());
        bondSellLogExample.setOrderByClause("create_time desc limit 0,1");
        List<BondSellLog> bondSellLogs = bondSellLogMapper.selectByExample(bondSellLogExample);
        if (bondSellLogs != null) {
            try {
                buyLogDTO.setSellDate(DateUtils.getDateString(bondSellLogs.get(0).getCreateTime()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void loadCurBondIncome(BondInfo bondInfo, BondBuyLog bondBuyLog, BondBuyLogDTO buyLogDTO) {
        //当前持股盈亏
        if (bondBuyLog.getCount() > bondBuyLog.getSellCount()) {
            int surplusCount = bondBuyLog.getCount() - bondBuyLog.getSellCount();
            Double curIncome = bondInfo.getPrice() * surplusCount - bondBuyLog.getPrice() * surplusCount;
            //当前收益 扣除佣金税费
            curIncome -= BondUtils.getTaxation( bondInfo.getPlate(), bondInfo.getIsEtf(), surplusCount * bondInfo.getPrice(), true);
            curIncome -= BondUtils.getTaxation( bondInfo.getPlate(), bondInfo.getIsEtf(), surplusCount * bondBuyLog.getPrice(), false);
            //当前收益 扣除未还利息
            if (bondBuyLog.getFinancing() == 1) {
                Double rzfz = (surplusCount * bondBuyLog.getPrice()) + BondUtils.getTaxation( bondInfo.getPlate(), bondInfo.getIsEtf(), surplusCount * bondBuyLog.getPrice(), false);
                Date lendDate;
                if (bondBuyLog.getBackTime() != null) {
                    lendDate = bondBuyLog.getBackTime();
                } else {
                    lendDate = DateUtils.string2Date(bondBuyLog.getBuyDate(), DateUtils.YYYY_MM_DD);
                }
                curIncome -= BondUtils.countInterest(rzfz, lendDate);
            }
            curIncome -= bondBuyLog.getInterest();
            //涨跌幅
            Double zdf = Double.parseDouble(String.format("%.2f", (((bondInfo.getPrice() - bondBuyLog.getPrice()) / bondInfo.getPrice()) * 100)));
            buyLogDTO.setIncome(curIncome);
            buyLogDTO.setCurIncome(Double.parseDouble(String.format("%.2f", curIncome)) + "(" + zdf + "%)");
        }
    }

    @Override
    public void buyBond(BondBuyLog bondBuyLog) {
        BondInfo bondInfo = bondInfoService.selectBondInfoById(bondBuyLog.getGpId());
        bondBuyLog.setCreateTime(new Date());
        bondBuyLog.setOperTime(new Date());
        bondBuyLog.setSellCount(0);
        bondBuyLog.setSellIncome(0.00);
        bondBuyLog.setStatus(bondBuyLog.getStatus());
        bondBuyLog.setFinancing(bondBuyLog.getFinancing());

        if (bondBuyLog.getStatus() != null && bondBuyLog.getStatus() != 3) {
            bondBuyLog.setBuyDate(bondBuyLog.getBuyDate());
            double cost = BondUtils.getTaxation( bondInfo.getPlate(), bondInfo.getIsEtf(), bondBuyLog.getPrice() * bondBuyLog.getCount(), false);
            bondBuyLog.setCost(Double.parseDouble(String.format("%.2f", cost)));
            bondBuyLog.setTotalPrice(Double.parseDouble(String.format("%.2f", bondBuyLog.getPrice() * bondBuyLog.getCount())));

            bondBuyLog.setBuyCost(Double.parseDouble(String.format("%.2f", bondBuyLog.getCost())));
            refeshBondStatistics(bondBuyLog.getTotalPrice(), bondBuyLog.getCost(), 0.5);
        }
        bondBuyLogService.insertBondBuyLog(bondBuyLog);
    }

    @Override
    public void sellBond(BondSellLog bondSellLog) {
        BondBuyLog bondBuyLog = bondBuyLogMapper.selectBondBuyLogById(bondSellLog.getBuyId());
        //如果是融资购买 先归还后出售
        if (bondBuyLog.getFinancing() == 1) {
            double notbackInterest = bondBuyLog.notbackInterest();
            BondBuyLogDTO bondBuyLogDTO = new BondBuyLogDTO();
            bondBuyLogDTO.setId(bondBuyLog.getId());
            bondBuyLogDTO.setInterest(notbackInterest);
            bondBuyLogDTO.setTotalPrice(Double.parseDouble(String.format("%.2f", bondSellLog.getPrice() * bondSellLog.getCount())));
            bondBuyLogDTO.setBackTime(bondSellLog.getCreateTime());
            backBond(bondBuyLogDTO);
            bondBuyLog = bondBuyLogMapper.selectBondBuyLogById(bondSellLog.getBuyId());
        }

        BondInfo bondInfo = bondInfoService.selectBondInfoById(bondBuyLog.getGpId());

        //卖出税费计算
        double sellTaxation = BondUtils.getTaxation( bondInfo.getPlate(), bondInfo.getIsEtf(), bondSellLog.getPrice() * bondSellLog.getCount(), true);
        bondSellLog.setCost(sellTaxation);
        bondBuyLog.setCost(Double.parseDouble(String.format("%.2f", bondBuyLog.getCost() + bondSellLog.getCost())));

        //买入税费计算
        double buyTaxation = BondUtils.getTaxation( bondInfo.getPlate(), bondInfo.getIsEtf(), bondBuyLog.getPrice() * bondSellLog.getCount(), false);
        //计算收益 出售总价 - 买入总价 - 买卖费用
        double income = bondSellLog.getPrice() * bondSellLog.getCount() - bondBuyLog.getPrice() * bondSellLog.getCount() - bondSellLog.getCost() - buyTaxation;

        bondSellLog.setIncome(Double.parseDouble(String.format("%.2f", income)));
        bondSellLog.setGpId(bondInfo.getId());
        bondSellLog.setTotalCost(Double.parseDouble(String.format("%.2f", buyTaxation + sellTaxation)));
        bondSellLog.setTotalPrice(Double.parseDouble(String.format("%.2f", bondSellLog.getPrice() * bondSellLog.getCount())));
        bondSellLog.setCreateTime(bondSellLog.getCreateTime());

        bondBuyLog.setSellIncome(Double.parseDouble(String.format("%.2f", bondBuyLog.getSellIncome() + bondSellLog.getIncome())));
        bondBuyLog.setSellCount(bondBuyLog.getSellCount() + bondSellLog.getCount());
        bondBuyLog.setOperTime(new Date());
        //查看是否股票是否全部售出
        if (bondBuyLog.getCount().equals(bondBuyLog.getSellCount())) {
            bondBuyLog.setStatus((byte) 1);
            if (bondBuyLog.getInterest() > 0) {
                bondBuyLog.setSellIncome(Double.parseDouble(String.format("%.2f", bondBuyLog.getSellIncome() - bondBuyLog.getInterest())));
            }
        }
        int surplusCount = getBondNumber(bondInfo, bondBuyLog.getType()).intValue();

        bondSellLog.setSurplusCount(surplusCount);

        BondStatistics bondStatistics = bondStatisticsMapper.selectBondStatisticsById(1L);
        bondSellLog.setRealyBefore(bondStatistics.getReady());
        bondStatistics = refeshBondStatistics(-bondSellLog.getTotalPrice(), bondSellLog.getCost(), bondSellLog.getFreeze());
        bondSellLog.setRealyAfter(bondStatistics.getReady());

        bondSellLogMapper.insertBondSellLog(bondSellLog);
        bondBuyLogMapper.updateBondBuyLog(bondBuyLog);
    }

    @Override
    public ResultDO backBond(BondBuyLogDTO bondBuyLogDTO) {
        BondBuyLog bondBuyLog = bondBuyLogMapper.selectBondBuyLogById(bondBuyLogDTO.getId());
        if (bondBuyLog.getFinancing() != 1) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, "融资已归还，请勿重复操作", null);
        }
        //剩余归还金额
        double surplusBackMoney = (bondBuyLog.getCount() - bondBuyLog.getSellCount()) * bondBuyLog.getPrice() - bondBuyLog.getBackMoney();

        bondBuyLog.setBackMoney(Double.parseDouble(String.format("%.2f", bondBuyLog.getBackMoney() + bondBuyLogDTO.getTotalPrice())));

        if (bondBuyLog.getBackMoney().doubleValue() >= bondBuyLog.getTotalPrice().doubleValue() || bondBuyLog.getBackMoney().doubleValue() >= surplusBackMoney) {
            //已归还完
            bondBuyLog.setFinancing((byte) 0);
            bondBuyLog.setBackMoney(bondBuyLog.getTotalPrice().doubleValue());
        }
        bondBuyLog.addInterest(bondBuyLogDTO.getInterest());
        bondBuyLog.setBackTime(bondBuyLogDTO.getBackTime());
        bondBuyLog.addRemarks(bondBuyLogDTO.getTotalPrice().doubleValue(), bondBuyLogDTO.getInterest());
        bondBuyLogMapper.updateBondBuyLog(bondBuyLog);

        //出售日志新增一条归还利息产生的负收益
        BondSellLog bondSellLog = new BondSellLog();
        bondSellLog.setBuyId(bondBuyLog.getId());
        bondSellLog.setGpId(bondBuyLog.getGpId());
        bondSellLog.setCost(0.0);
        bondSellLog.setTotalCost(0.0);
        bondSellLog.setTotalPrice(0.0);
        bondSellLog.setPrice(0.0);
        bondSellLog.setCount(0);
        bondSellLog.setIncome(-bondBuyLogDTO.getInterest());
        bondSellLog.setCreateTime(new Date());
        bondSellLogMapper.insertBondSellLog(bondSellLog);
        return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, null);
    }

    @Override
    public BondStatistics refeshBondStatistics(double value, Double cost, double freeze) {
        BondStatistics bondStatistics = bondStatisticsMapper.selectBondStatisticsById(1L);
        bondStatistics.setStock(Double.parseDouble(String.format("%.2f", bondStatistics.getStock() + value)));
        bondStatistics.setReady(Double.parseDouble(String.format("%.2f", bondStatistics.getReady() - value - cost - freeze)));
        bondStatistics.setFreeze(bondStatistics.getFreeze() + freeze);
        bondStatisticsMapper.updateBondStatistics(bondStatistics);
        return bondStatistics;
    }

    @Override
    public BondInfoDTO loadBondInfoDTO(BondInfo bondInfo) {
        BondInfoDTO bondInfoDTO = BeanUtils.copyBean(new BondInfoDTO(), bondInfo);
        Double stubProfit = bondBuyLogMapper.sumSellIncome(bondInfo.getId(), (byte) 1);
        if (stubProfit == null){
            stubProfit = 0.00;
        }
        bondInfoDTO.setStubProfit(Double.parseDouble(String.format("%.2f", stubProfit)));
        Double gridProfit = bondBuyLogMapper.sumSellIncome(bondInfo.getId(), (byte) 0);
        if (gridProfit == null){
            gridProfit = 0.00;
        }

        bondInfoDTO.setGridProfit(Double.parseDouble(String.format("%.2f", gridProfit)));

        Double superProfit = bondBuyLogMapper.sumSellIncome(bondInfo.getId(), (byte) 2);
        if (superProfit == null) {
            superProfit = 0.00;
        }
        bondInfoDTO.setSuperProfit(Double.parseDouble(String.format("%.2f", superProfit)));

        bondInfoDTO.setStubCount(getBondNumber(bondInfo, BondConstants.SHORT_LINE));
        bondInfoDTO.setGridCount(getBondNumber(bondInfo, BondConstants.LONG_LINE));
        bondInfoDTO.setSuperStubCount(getBondNumber(bondInfo, BondConstants.SUPER_SHORT_LINE));

        //当前持股盈亏
        BondBuyLogExample bondBuyLogExample = new BondBuyLogExample();
        BondBuyLogExample.Criteria criteria = bondBuyLogExample.createCriteria();
        criteria.andGpIdEqualTo(bondInfo.getId());
        criteria.andStatusEqualTo((byte) 0);
        List<BondBuyLog> bondBuyLogs = bondBuyLogMapper.selectByExample(bondBuyLogExample);
        if (bondBuyLogs != null) {
            Double total = 0.00;
            for (BondBuyLog bondBuyLog : bondBuyLogs) {
                if (bondBuyLog.getCount() > bondBuyLog.getSellCount()) {
                    int surplusCount = bondBuyLog.getCount() - bondBuyLog.getSellCount();
                    total += (bondInfo.getPrice() * surplusCount) - (bondBuyLog.getPrice() * surplusCount);
                }
            }
            bondInfoDTO.setGpProfit(Double.parseDouble(String.format("%.2f", total)));
        }

        BondSellRequestDTO bondSellRequestDTO = new BondSellRequestDTO();
        bondSellRequestDTO.setGpId(bondInfo.getId());
        bondInfoDTO.setTotalProfit(Double.parseDouble(String.format("%.2f", bondSellLogMapper.sumIncomeByGpId(bondSellRequestDTO))));


        bondSellRequestDTO.setStartTime(DateUtils.getTimeString(DateUtils.getBeginTime(Calendar.getInstance().get(Calendar.YEAR), 1)));
        bondSellRequestDTO.setEndTime(DateUtils.getTimeString(DateUtils.getBeginTime(Calendar.getInstance().get(Calendar.YEAR), 12)));
        bondInfoDTO.setCurYearProfit(Double.parseDouble(String.format("%.2f", bondSellLogMapper.sumIncome(bondSellRequestDTO))));


        //计算成本价 = (当前价格 * 股票数量 - 总盈亏) /数量
        Double costPrice = Double.parseDouble(String.format("%.3f", (bondInfo.getPrice() * bondInfoDTO.getGpCount() - bondInfoDTO.getCurProfit()) / bondInfoDTO.getGpCount()));
        Double ykb = (bondInfo.getPrice() - costPrice) / costPrice * 100;
        bondInfoDTO.setCostPrice(costPrice + "(" + Double.parseDouble(String.format("%.2f", ykb)) + "%)");

        //计算胜率
        BondSellLogExample bondSellLogExample = new BondSellLogExample();
        bondSellLogExample.createCriteria().andGpIdEqualTo(bondInfo.getId()).andIncomeGreaterThan(0.0);
        long winCount = bondSellLogMapper.countByExample(bondSellLogExample);
        bondSellLogExample = new BondSellLogExample();
        bondSellLogExample.createCriteria().andGpIdEqualTo(bondInfo.getId());
        long totalCount = bondSellLogMapper.countByExample(bondSellLogExample);
        bondInfoDTO.setWinning(StringUtils.pencentWin(winCount, totalCount));

        bondBuyLogExample = new BondBuyLogExample();
        bondBuyLogExample.createCriteria().andGpIdEqualTo(bondInfo.getId()).andStatusEqualTo(BondConstants.WAIT_BUY);
        List<BondBuyLog> waitBuyBondBuyLogS = bondBuyLogMapper.selectByExample(bondBuyLogExample);
        for (BondBuyLog bondBuyLog : waitBuyBondBuyLogS) {
            if (bondBuyLog != null) {
                if (bondBuyLog.getPrice() >= bondInfo.getPrice()) {
                    bondInfoDTO.setWaitBuy(true);
                    break;
                }
            }
        }

        bondInfoDTO.setMarket(Double.parseDouble(String.format("%.0f", bondInfo.getPrice() * bondInfoDTO.getGpCount())));
        BondStatistics bondStatistics = bondStatisticsMapper.selectBondStatisticsById(1L);

        bondInfoDTO.setRealPosition(Double.parseDouble(String.format("%.2f", bondInfoDTO.getMarket() / (bondStatistics.getStock() + bondStatistics.getReady()) * 10)));
        bondInfoDTO.setPosition(bondInfo.getPosition());

        //计算今日T收益
        bondSellRequestDTO.setStartTime(DateUtils.getTimeString(DateUtils.getTime(new Date(), 0, 0, 0)));
        bondSellRequestDTO.setEndTime(DateUtils.getTimeString(DateUtils.getTime(new Date(), 23, 59, 59)));
        bondInfoDTO.setTodayTProfit(Double.parseDouble(String.format("%.2f", bondSellLogMapper.sumIncomeByGpId(bondSellRequestDTO))));
        //计算今日盈亏 = 持股数量*当前价格-(昨日持股数量 * 昨日收盘价) + 今日T收益
        Double todayProfit = (bondInfoDTO.getGpCount() * bondInfo.getPrice() - bondInfoDTO.getGpCount() * bondInfo.getOldPrice()) + bondInfoDTO.getTodayTProfit();
        bondInfoDTO.setTodayStockProfit(todayProfit);

        return bondInfoDTO;
    }

    /**
     * 查询股票数量
     *
     * @param bondInfo
     * @param type     0：网格 1：短线
     * @return
     */
    public Long getBondNumber(BondInfo bondInfo, byte type) {
        long buyCount = 0, sellCount = 0;
        Map<Object, Object> map = bondBuyLogMapper.sumBuySellCount(bondInfo.getId(), type);
        if (map != null) {
            for (Object o : map.keySet()) {
                if (o.equals("buyCount")) {
                    buyCount = Long.valueOf(map.get(o).toString());
                } else if (o.equals("sellCount")) {
                    sellCount = Long.valueOf(map.get(o).toString());
                }
            }
        }
        return buyCount - sellCount;
    }

}
