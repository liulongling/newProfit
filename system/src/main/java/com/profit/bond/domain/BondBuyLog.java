package com.profit.bond.domain;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.profit.common.utils.BondUtils;
import com.profit.common.utils.DateUtils;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.profit.common.annotation.Excel;
import com.profit.common.core.domain.BaseEntity;

/**
 * 股票购买日志对象 bond_buy_log
 * 
 * @author liulongling
 * @date 2023-12-11
 */
@Data
public class BondBuyLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一ID */
    private Long id;

    /** 股票代码 */
    @Excel(name = "股票代码")
    private String gpId;

    /** 购买价格 */
    @Excel(name = "购买价格")
    private Double price;

    /** 购买数量 */
    @Excel(name = "购买数量")
    private Integer count;

    /** 购买总价格 */
    @Excel(name = "购买总价格")
    private Double totalPrice;

    /** 融资归还金额 */
    @Excel(name = "融资归还金额")
    private Double backMoney;

    /** 融资归还时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "融资归还时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date backTime;

    /** 利息 */
    @Excel(name = "利息")
    private Double interest;

    /** 购买消耗佣金 */
    @Excel(name = "购买消耗佣金")
    private Double buyCost;

    /** 税费 */
    @Excel(name = "税费")
    private Double cost;

    /** type:0 网格 type:1短线 */
    @Excel(name = "type:0 网格 type:1短线")
    private Byte type;

    /** 已出售数量 */
    @Excel(name = "已出售数量")
    private Integer sellCount;

    /** 出售收益 */
    @Excel(name = "出售收益")
    private Double sellIncome;

    /** 购买日期 */
    @Excel(name = "购买日期")
    private String buyDate;

    /** 0:未售完 1:已售完 */
    @Excel(name = "0:未售完 1:已售完")
    private Byte status;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date operTime;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 是否融资买入 0:不是 1：是 */
    @Excel(name = "是否融资买入 0:不是 1：是")
    private Byte financing;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("gpId", getGpId())
            .append("price", getPrice())
            .append("count", getCount())
            .append("totalPrice", getTotalPrice())
            .append("backMoney", getBackMoney())
            .append("backTime", getBackTime())
            .append("interest", getInterest())
            .append("buyCost", getBuyCost())
            .append("cost", getCost())
            .append("type", getType())
            .append("sellCount", getSellCount())
            .append("sellIncome", getSellIncome())
            .append("buyDate", getBuyDate())
            .append("status", getStatus())
            .append("operTime", getOperTime())
            .append("remarks", getRemarks())
            .append("financing", getFinancing())
            .append("createTime", getCreateTime())
            .toString();
    }

    @JSONField(serialize = false, deserialize = false)
    public void addInterest(Double intersert) {
        this.interest += intersert;
    }

    @JSONField(serialize = false, deserialize = false)
    public void addRemarks(Double backMoney, Double intersert) {
        remarks += DateUtils.getDateString(backTime, DateUtils.YYYYMMDDHHMMSS) + "归还金额" + backMoney + "利息:" + intersert + ";";
    }


    @JSONField(serialize = false, deserialize = false)
    public double countInterest() {
        double interest = this.interest;
        if (financing == 1) {
            Date lendDate;
            if (backTime != null) {
                lendDate = backTime;
            } else {
                lendDate = DateUtils.string2Date(buyDate, DateUtils.YYYY_MM_DD);
            }
            Double lendMoney = (count - sellCount * price - backMoney) + buyCost;
            interest += BondUtils.countInterest(lendMoney, lendDate);
        }

        return interest;
    }

    @JSONField(serialize = false, deserialize = false)
    public double notbackInterest() {
        if (financing == 1) {
            Date lendDate;
            if (backTime != null) {
                lendDate = backTime;
            } else {
                lendDate = DateUtils.string2Date(buyDate, DateUtils.YYYY_MM_DD);
            }
            Double lendMoney = (count - sellCount * price - backMoney) + buyCost;
            return BondUtils.countInterest(lendMoney, lendDate);
        }
        return 0;
    }
}
