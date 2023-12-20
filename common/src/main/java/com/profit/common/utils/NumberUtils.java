package com.profit.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class NumberUtils {

    public static String percent(BigDecimal bigDecimal) {
        BigDecimal b = bigDecimal.setScale(4, RoundingMode.HALF_UP);
        return String.format("%.2f", b.doubleValue() * 100);
    }

    public static String percent(float value1, float value2) {
        float value = value1 * 100 / value2;
        DecimalFormat df = new DecimalFormat("0.0");
        return df.format(value) + "";
    }


}
