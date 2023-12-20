package com.profit.bond.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class EChartsData {

    /**
     * title
     */
    private String text;
    private List<String> legend = new ArrayList<>();
    /**
     * x 坐标
     */
    private List<String> xAxis = new ArrayList<>();
    /**
     *
     */
    private List<EChartsElement> series = new ArrayList<>();

}
