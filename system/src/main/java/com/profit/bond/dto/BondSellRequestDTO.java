package com.profit.bond.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BondSellRequestDTO extends BondRequestDTO{
    private Long buyId;
}
