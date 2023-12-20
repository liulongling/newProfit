package com.profit.bond.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.profit.common.annotation.Excel;
import com.profit.common.core.domain.BaseEntity;

/**
 * 股票信息对象 bond_statistics
 * 
 * @author liulongling
 * @date 2023-12-13
 */
@Data
public class BondStatistics extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 持股市值 */
    @Excel(name = "持股市值")
    private Double stock;

    /** 现金 */
    @Excel(name = "现金")
    private Double ready;

    /** 冻结费用 */
    @Excel(name = "冻结费用")
    private Double freeze;

    /** 仓位占比 */
    @Excel(name = "仓位占比")
    private Double position;

    /** 盈利笔数 */
    @Excel(name = "盈利笔数")
    private int profitNumber;

    /** 亏损笔数 */
    @Excel(name = "亏损笔数")
    private int lossNumber;

    /** 胜率 */
    @Excel(name = "胜率")
    private String winning;

    /** 总收益 */
    @Excel(name = "总收益")
    private Double profit;

    /** 购买总金额 */
    @Excel(name = "购买总金额")
    private Double buyMoney;

    /** 出售总金额 */
    @Excel(name = "出售总金额")
    private Double sellMoney;

    /** 止损金额 */
    @Excel(name = "止损金额")
    private Double lossMoney;

    /** 消耗总佣金 */
    @Excel(name = "消耗总佣金")
    private Double cost;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("stock", getStock())
            .append("ready", getReady())
            .append("freeze", getFreeze())
            .append("position", getPosition())
            .append("profitNumber", getProfitNumber())
            .append("lossNumber", getLossNumber())
            .append("winning", getWinning())
            .append("profit", getProfit())
            .append("buyMoney", getBuyMoney())
            .append("sellMoney", getSellMoney())
            .append("lossMoney", getLossMoney())
            .append("cost", getCost())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
