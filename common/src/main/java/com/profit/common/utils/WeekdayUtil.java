package com.profit.common.utils;

import org.apache.commons.lang3.BooleanUtils;

import java.io.File;
import java.util.*;

/**
 * 节假日判断工具类
 * 做这个工具的缘由：大厂接口要收费，小长接口怕不稳定，索性自己写一个吧。
 *
 * @author hanmanyi
 */
public class WeekdayUtil {

    static Map<String, Object> config = new HashMap<String, Object>();

    /**
     * 初始化节假日配置
     */
    static {
        //节假日存储路径，文件需以YYYY.txt命名
        String fileFolder = "D:\\work\\profit\\doc";
        File ff = new File(fileFolder);
        File[] flist = ff.listFiles();
        if (flist != null && flist.length > 0) {
            for (int i = 0; i < flist.length; i++) {
                File f = flist[i];
                Map<String, Object> year = new HashMap<>();
                FilesUtils.readAll2Conig(f.getAbsolutePath(), "UTF-8", year);//初始化节假日设置
                config.put(f.getName().replace(".txt", ""), year);
            }
        }
    }

    public static boolean isWeekDay() {
        String date = DateUtils.getDateString(new Date(), DateUtils.YYYY_MM_DD);
        Map<String, Object> map = WeekdayUtil.isWeekday(date);
        if (map != null && BooleanUtils.toBoolean(map.get("isWeekDay").toString())) {
            return true;
        }
        return false;
    }

    /**
     * 是否为工作日
     * 1、如果为节假日：false
     * 2、如果为调休日：true
     * 3、如果为周末：false，否则true
     *
     * @param date 形如“yyyy-MM-dd”
     * @return msg：接口返回消息，type：节假日/调休/周末/工作日，isWeekDay：工作日/调休-true，节假日/周末-false
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> isWeekday(String date) {
        Map<String, Object> ret = new HashMap<>();
        boolean isWeekDay = true;
        String type = "";
        String msg = "";
        //校验格式
        if (date.length() < 10 || date.indexOf("-") < 0) {
            msg = "请检查参数格式是否正确(yyyy-MM-dd)";
            ret.put("isWeekDay", isWeekDay);
            ret.put("type", type);
            ret.put("msg", msg);
            return ret;
        }
        Set<String> yearSet = config.keySet();
        String year = date.substring(0, 4);
        String mmdd = date.substring(5);
        if (!yearSet.contains(year)) {
            msg = "抱歉，还未导入该年度的节假日安排，请联系员导入";
            ret.put("isWeekDay", isWeekDay);
            ret.put("type", type);
            ret.put("msg", msg);
            return ret;
        }
        Map<String, Object> yearConifg = (Map<String, Object>) config.get(year);

        //是否为节假日
        List<String> holidayList = (List<String>) yearConifg.get("holidayList");
        if (holidayList != null && holidayList.size() > 0) {
            for (int i = 0; i < holidayList.size(); i++) {
                String holiday = holidayList.get(i);
                String start = holiday.split("~")[0];
                String end = holiday.split("~")[1];
                if (mmdd.compareTo(start) >= 0 && end.compareTo(mmdd) >= 0) {
                    isWeekDay = false;
                    type = "节假日";
                    msg = "接口调用成功";
                    ret.put("isWeekDay", isWeekDay);
                    ret.put("type", type);
                    ret.put("msg", msg);
                    return ret;
                }
            }
        }

        //是否为调休日
        List<String> weekdayList = (List<String>) yearConifg.get("weekdayList");
        for (int i = 0; i < weekdayList.size(); i++) {
            String weekday = weekdayList.get(i);
            if (mmdd.compareTo(weekday) == 0) {
                isWeekDay = true;
                type = "调休";
                msg = "接口调用成功";
                ret.put("isWeekDay", isWeekDay);
                ret.put("type", type);
                ret.put("msg", msg);
                return ret;
            }
        }

        //是否为周末
        boolean isWeekend = DateUtilsHmy.isWeeks(DateUtilsHmy.str2Date(date, DateUtilsHmy.yyyyMMddFormat));
        if (isWeekend) {
            isWeekDay = false;
            type = "周末";
            msg = "接口调用成功";
            ret.put("isWeekDay", isWeekDay);
            ret.put("type", type);
            ret.put("msg", msg);
            return ret;
        }

        ret.put("isWeekDay", true);
        ret.put("type", "工作日");
        ret.put("msg", "接口调用成功");
        return ret;
    }
}
