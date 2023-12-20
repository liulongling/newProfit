package com.profit.bond.comparator;


import com.profit.bond.dto.BondProfit;

import java.util.Comparator;


/**
 * 收益排序
 *
 * @Author:liulongling
 * @Date:2022/4/27 10:50
 */
public class ComparatorProfit implements Comparator {


    public ComparatorProfit() {
    }

    @Override
    public int compare(Object o1, Object o2) {
        BondProfit className1 = (BondProfit) o1;
        BondProfit className2 = (BondProfit) o2;
        //收益高的排在最前面
        if (className1.getMoney() < className2.getMoney()) {
            return 1;
        }

        return -1;
    }
}
