package com.profit.bond.comparator;


import com.profit.bond.dto.BondInfoDTO;

import java.util.Comparator;

/**
 * 收益排序
 *
 * @Author:liulongling
 * @Date:2022/4/27 10:50
 */
public class ComparatorBondMarket implements Comparator {

    public ComparatorBondMarket() {
    }

    @Override
    public int compare(Object o1, Object o2) {
        BondInfoDTO className1 = (BondInfoDTO) o1;
        BondInfoDTO className2 = (BondInfoDTO) o2;
        if (className1.getMarket() != null && className2.getMarket() != null) {
            if (className1.getMarket() < className2.getMarket()) {
                return 1;
            }
        }
        return -1;
    }
}
