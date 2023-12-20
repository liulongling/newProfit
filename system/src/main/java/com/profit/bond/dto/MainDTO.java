package com.profit.bond.dto;

import lombok.Data;

/**
 * @author: liulongling
 * @date: 2023/12/16 20:18
 * @Description:
 */
@Data
public class MainDTO {
    private StatisticsDTO today = new StatisticsDTO();
    private StatisticsDTO month = new StatisticsDTO();
    private StatisticsDTO year = new StatisticsDTO();
    private StatisticsDTO total = new StatisticsDTO();
}
