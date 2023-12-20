package com.profit.bond.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BondStatisticsLog {
    /**
     * 主键
     */
    private Long id;

    /**
     * 持股市值
     */
    private Double stock;

    /**
     * 现金
     */
    private Double ready;

    /**
     * 负债
     */
    private Double liability;

    /**
     * 盈亏
     */
    private Double profit;

    /**
     * 
     */
    private Date createTime;
}