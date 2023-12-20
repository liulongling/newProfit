package com.profit.bond.comparator;

import com.profit.bond.dto.BondTransactionDTO;
import com.profit.common.utils.BondUtils;

import java.util.Comparator;


/**
 * 收益排序
 *
 * @Author:liulongling
 * @Date:2022/4/27 10:50
 */
public class ComparatorGpId implements Comparator {


    public ComparatorGpId() {
    }

    @Override
    public int compare(Object o1, Object o2) {
        BondTransactionDTO className1 = (BondTransactionDTO) o1;
        BondTransactionDTO className2 = (BondTransactionDTO) o2;

        if (Integer.parseInt(BondUtils.getBaseId(className1.getGpId())) < Integer.parseInt(BondUtils.getBaseId(className2.getGpId()))) {
            return 1;
        }

        return -1;
    }
}
