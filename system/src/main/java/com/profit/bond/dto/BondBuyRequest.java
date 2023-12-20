package com.profit.bond.dto;

import com.profit.bond.domain.BondBuyLog;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BondBuyRequest extends BondBuyLog {
    private String sellDate;
    private Double sellPrice;
}
