package com.profit.bond.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.profit.common.annotation.Excel;
import com.profit.common.core.domain.BaseEntity;

/**
 * 股票出售日志对象 bond_sell_log
 * 
 * @author liulongling
 * @date 2023-12-11
 */
@Data
public class BondSellLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一ID */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String gpId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long buyId;

    /** 出售价格 */
    @Excel(name = "出售价格")
    private Double price;

    /**
     * 预冻结资金
     */
    private Double freeze;

    /**
     * 利息
     */
    private Double interest;

    /** 出售数量 */
    @Excel(name = "出售数量")
    private Integer count;

    /** 出售总价格 */
    @Excel(name = "出售总价格")
    private Double totalPrice;

    /** 佣金 */
    @Excel(name = "佣金")
    private Double cost;

    /** 总佣金税费，包含购买佣金 */
    @Excel(name = "总佣金税费，包含购买佣金")
    private Double totalCost;

    /** 收益 */
    @Excel(name = "收益")
    private Double income;

    /** 出售后当前剩余数量 */
    @Excel(name = "出售后当前剩余数量")
    private int surplusCount;

    /** 出售前现金 */
    @Excel(name = "出售前现金")
    private Double realyBefore;

    /** 出售后现金 */
    @Excel(name = "出售后现金")
    private Double realyAfter;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("gpId", getGpId())
            .append("buyId", getBuyId())
            .append("price", getPrice())
            .append("count", getCount())
            .append("totalPrice", getTotalPrice())
            .append("cost", getCost())
            .append("totalCost", getTotalCost())
            .append("income", getIncome())
            .append("surplusCount", getSurplusCount())
            .append("realyBefore", getRealyBefore())
            .append("realyAfter", getRealyAfter())
            .append("createTime", getCreateTime())
            .toString();
    }
}
