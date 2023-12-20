package com.profit.bond.dto;

import lombok.Data;


@Data
public class TotalProfitDTO extends TodayTaxationDTO {
    /**
     * 总盈利次数
     */
    private int totalProfitNumber;
    /**
     * 亏损次数
     */
    private Long totalLossNumber;
    /**
     * 胜率
     */
    private String avgWinning;

    /**
     * 止损金额
     */
    private Double lossMoney;

    /**
     * 总收益
     */
    private Double totalProfit;

    /**
     * 持股市值
     */
    private Double stockValue;
    /**
     * 现金
     */
    private Double ready;
}
