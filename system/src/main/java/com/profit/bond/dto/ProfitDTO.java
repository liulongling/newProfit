package com.profit.bond.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProfitDTO {
    private List<String> date;
    private List<Double> stubProfit;
    private List<Double> gridProfit;
    private List<Double> lossProfit;
    private List<Double> cost;
    private List<Double> totalProfit;

    public ProfitDTO() {
        date = new ArrayList<>();
        stubProfit = new ArrayList<>();
        gridProfit = new ArrayList<>();
        lossProfit = new ArrayList<>();
        cost = new ArrayList<>();
        totalProfit = new ArrayList<>();
    }

}
