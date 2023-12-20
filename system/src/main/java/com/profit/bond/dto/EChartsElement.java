package com.profit.bond.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class EChartsElement {
    /**
     * 标题
     */
    private String name;
    /**
     * ECharts 图表类型 line 折线图 bar 柱状图
     */
    private String type;
    /**
     *
     */
    private String stack;
    /**
     *
     */
    private String barWidth;
    /**
     * 数据
     */
    private List<?> data;
}
