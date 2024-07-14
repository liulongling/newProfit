package com.profit.bond.domain;

import com.profit.common.annotation.Excel;
import com.profit.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 股票成交基础信息对象 bond_deal
 * 
 * @author ruoyi
 * @date 2024-03-05
 */
public class BondDeal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 股票ID */
    @Excel(name = "股票ID")
    private String gpId;

    /** 开盘价 */
    @Excel(name = "开盘价")
    private Double open;

    /** 收盘价 */
    @Excel(name = "收盘价")
    private Double close;

    /** 最高价 */
    @Excel(name = "最高价")
    private Double high;

    /** 最低价 */
    @Excel(name = "最低价")
    private Double low;

    /** 成交量 */
    @Excel(name = "成交量")
    private Long volume;

    /** 成交额 */
    @Excel(name = "成交额")
    private Long totalAmt;

    /** 振幅 */
    @Excel(name = "振幅")
    private Double rangeRate;

    /** 换手 */
    @Excel(name = "换手")
    private Double tRate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGpId(String gpId) 
    {
        this.gpId = gpId;
    }

    public String getGpId() 
    {
        return gpId;
    }
    public void setOpen(Double open) 
    {
        this.open = open;
    }

    public Double getOpen() 
    {
        return open;
    }
    public void setClose(Double close) 
    {
        this.close = close;
    }

    public Double getClose() 
    {
        return close;
    }
    public void setHigh(Double high) 
    {
        this.high = high;
    }

    public Double getHigh() 
    {
        return high;
    }
    public void setLow(Double low) 
    {
        this.low = low;
    }

    public Double getLow() 
    {
        return low;
    }
    public void setVolume(Long volume) 
    {
        this.volume = volume;
    }

    public Long getVolume() 
    {
        return volume;
    }
    public void setTotalAmt(Long totalAmt) 
    {
        this.totalAmt = totalAmt;
    }

    public Long getTotalAmt() 
    {
        return totalAmt;
    }
    public void setRangeRate(Double rangeRate) 
    {
        this.rangeRate = rangeRate;
    }

    public Double getRangeRate() 
    {
        return rangeRate;
    }
    public void settRate(Double tRate) 
    {
        this.tRate = tRate;
    }

    public Double gettRate() 
    {
        return tRate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("gpId", getGpId())
            .append("open", getOpen())
            .append("close", getClose())
            .append("high", getHigh())
            .append("low", getLow())
            .append("volume", getVolume())
            .append("totalAmt", getTotalAmt())
            .append("rangeRate", getRangeRate())
            .append("tRate", gettRate())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
