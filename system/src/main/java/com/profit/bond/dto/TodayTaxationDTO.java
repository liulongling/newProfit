package com.profit.bond.dto;

import com.profit.bond.domain.BondInfo;
import lombok.Data;

@Data
public class TodayTaxationDTO extends BondInfo {

    /**
     * 今日持股盈亏
     */
    private Double todayStockProfit;
    /**
     * 今日总收益
     */
    private Double todayProfit;
    /**
     * 今日止损金额
     */
    private Double todayLossProfit;
    /**
     * 交易金额
     */
    private Double transactionAmount;
    /**
     * 买入金额
     */
    private Double buyAmount;
    /**
     * 卖出金额
     */
    private Double sellAmount;
    /**
     * 佣金费用
     */
    private Double cost;
    /**
     * 买入次数
     */
    private int buyNumber;
    /**
     * 最大一笔亏损
     */
    private Double maxLoss;
    /**
     * 最大一笔盈利
     */
    private Double maxProfit;
    /**
     * 盈利次数
     */
    private int profitNumber;
    /**
     * 亏损次数
     */
    private int lossNumber;
    /**
     * 胜率
     */
    private String winning;

    public void incrProfitNumber() {
        profitNumber++;
    }

    public void incrPlossNumber() {
        lossNumber++;
    }

    public int getTotalNumber() {
        return profitNumber + lossNumber;
    }
}
