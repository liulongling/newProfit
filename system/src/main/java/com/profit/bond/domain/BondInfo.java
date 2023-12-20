package com.profit.bond.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.profit.common.annotation.Excel;
import com.profit.common.core.domain.BaseEntity;

/**
 * 股票信息对象 bond_info
 *
 * @author liulongling
 * @date 2023-12-13
 */
public class BondInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 股票名称 */
    @Excel(name = "股票名称")
    private String name;

    /** 当前股价 */
    @Excel(name = "当前股价")
    private Double price;

    /** 昨日收盘价 */
    @Excel(name = "昨日收盘价")
    private Double oldPrice;

    /** 上市所属板块 0：上证 1:深圳 2：创业板 3：etf */
    @Excel(name = "上市所属板块 0：上证 1:深圳 2：创业板 3：etf")
    private String plate;

    /** 是否ETF 1：etf */
    @Excel(name = "是否ETF 1：etf")
    private Integer isEtf;

    /** 仓位占比 */
    @Excel(name = "仓位占比")
    private Double position;

    /** 0:上架 -1：下架 */
    @Excel(name = "0:上架 -1：下架")
    private Integer status;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Double getPrice()
    {
        return price;
    }
    public void setOldPrice(Double oldPrice)
    {
        this.oldPrice = oldPrice;
    }

    public Double getOldPrice()
    {
        return oldPrice;
    }
    public void setPlate(String plate)
    {
        this.plate = plate;
    }

    public String getPlate()
    {
        return plate;
    }
    public void setIsEtf(Integer isEtf)
    {
        this.isEtf = isEtf;
    }

    public Integer getIsEtf()
    {
        return isEtf;
    }
    public void setPosition(Double position)
    {
        this.position = position;
    }

    public Double getPosition()
    {
        return position;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("price", getPrice())
                .append("oldPrice", getOldPrice())
                .append("plate", getPlate())
                .append("isEtf", getIsEtf())
                .append("position", getPosition())
                .append("status", getStatus())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
