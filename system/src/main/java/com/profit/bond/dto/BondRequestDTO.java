package com.profit.bond.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BondRequestDTO {
    private String gpId;
    private int type;
    private String startTime;
    private String endTime;

}
