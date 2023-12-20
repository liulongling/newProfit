package com.profit.bond.dto;

import lombok.Data;

import java.util.List;

@Data
public class StatisticsDTO {

    /**
     * 持股盈亏
     */
    private Double stockProfit;
    /**
     * 收益
     */
    private Double profit;
    /**
     * 买入金额
     */
    private Double buyAmount;
    /**
     * 卖出金额
     */
    private Double sellAmount;
    /**
     * 止损金额
     */
    private Double lossProfit;
    /**
     * 佣金费用
     */
    private Double cost;
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
    /**
     * 胜率
     */
    private List<BondProfit> topList;

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
