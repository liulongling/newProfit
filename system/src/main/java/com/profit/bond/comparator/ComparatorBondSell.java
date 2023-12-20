package com.profit.bond.comparator;


import com.profit.bond.dto.BondBuyLogDTO;

import java.util.Comparator;

/**
 * 收益排序
 *
 * @Author:liulongling
 * @Date:2022/4/27 10:50
 */
public class ComparatorBondSell implements Comparator {

    public ComparatorBondSell() {
    }

    @Override
    public int compare(Object o1, Object o2) {
        BondBuyLogDTO className1 = (BondBuyLogDTO) o1;
        BondBuyLogDTO className2 = (BondBuyLogDTO) o2;
        if (className1.getSellDate() != null && className2.getSellDate() != null) {
            String sellDate1 = className1.getSellDate().replace("-", "");
            String sellDate2 = className2.getSellDate().replace("-", "");
            if (Integer.valueOf(sellDate1) < Integer.valueOf(sellDate2)) {
                return 1;
            }
        }
        return -1;
    }
}
