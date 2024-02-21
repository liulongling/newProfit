package com.profit.bond.dto;

import com.profit.bond.domain.BondInfo;
import lombok.Data;

@Data
public class BondInfoDTO extends BondInfo {

    /**
     * 今年总收益
     */
    public Double curYearProfit;
    /**
     * 总收益
     */
    public Double totalProfit;
    /**
     * 短线收益
     */
    public Double stubProfit;
    /**
     * 网格收益
     */
    public Double gridProfit;
    /**
     * 超短收益
     */
    public Double superProfit;
    /**
     * 持股数量
     */
    public long gpCount;

    /**
     * 持仓市值
     */
    public Double market;

    /**
     * 仓位占比
     */
    public Double realPosition;

    /**
     * 规划仓位
     */
    public Double position;

    /**
     * 短线持股数量
     */
    public long stubCount;
    /**
     * 网格持股数量
     */
    public long gridCount;
    /**
     * 超短持股数量
     */
    public long superStubCount;
    /**
     * 成本价
     */
    public String costPrice;
    /**
     * 持股数量盈亏
     */
    public Double gpProfit;
    /**
     * 当前总盈亏
     */
    public Double curProfit;
    /**
     * 上月总收益
     */
    public Double lastMonthProfit;
    /**
     * 本月总收益
     */
    public Double curMonthProfit;
    /**
     * 今日T收益
     */
    public Double todayTProfit = 0.0;
    /**
     * 今日盈亏
     */
    public Double todayStockProfit;
    /**
     * 胜率
     */
    public String winning;
    /**
     * 是否有可购买
     */
    public boolean waitBuy;


    public Double getCurProfit() {
        return Double.parseDouble(String.format("%.2f", stubProfit + gridProfit + gpProfit + superProfit));
    }

    public long getGpCount() {
        return stubCount + gridCount + superStubCount;
    }


    public Double getProfit() {
        return Double.parseDouble(String.format("%.2f", stubProfit + gridProfit + superProfit));
    }


}