package com.profit.bond.dto;

import lombok.Data;

@Data
public class BondTransactionDTO {
    public long id;
    public String name;
    public String gpId;
    public String remarks;
    public Double cost;
    public Double price;
    public int count;
    public String operateDate;

}