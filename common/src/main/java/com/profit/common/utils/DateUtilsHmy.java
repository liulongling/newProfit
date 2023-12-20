package com.profit.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author hanmanyi
 * @Description 时间日期工具类 封装工作中常用的一些时间日期计算方法等,还可以提供更多的重载方法,用于时间的转化等
 * @Date 2013-10-16下午08:24:32
 */
public class DateUtilsHmy {
    private DateUtilsHmy() {

    }

    /**
     * hhmmFormat="HH:mm"
     */
    public static final String hhmmFormat = "HH:mm";
    /**
     * MMddFormat="MM-dd"
     */
    public static final String MMddFormat = "MM-dd";
    /**
     * yyyyFormat="yyyy"
     */
    public static final String yyyyFormat = "yyyy";
    /**
     * yyyyFormat="yyyy-MM"
     */
    public static final String yyyyMMFormat = "yyyy-MM";
    /**
     * yyyyChineseFormat="yyyy年"
     */
    public static final String yyyyChineseFormat = "yyyy年";
    /**
     * yyyyMMddFormat="yyyy-MM-dd"
     */
    public static final String yyyyMMddFormat = "yyyy-MM-dd";
    /**
     * fullFormat="yyyy-MM-dd HH:mm:ss"
     */
    public static final String fullFormat = "yyyy-MM-dd HH:mm:ss";
    /**
     * yyyyMMddHHmmss="yyyyMMddHHmmss"
     */
    public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";
    /**
     * strFormat="yyyy/MM/dd HH:mm:ss"
     */
    public static final String strFormat = "yyyy/MM/dd HH:mm:ss";
    /**
     * MMddChineseFormat="MM月dd日"
     */
    public static final String MMddChineseFormat = "MM月dd日";
    /**
     * yyyyMMddChineseFormat="yyyy年MM月dd日"
     */
    public static final String yyyyMMddChineseFormat = "yyyy年MM月dd日";
    /**
     * yyyyMMddChineseFormat="yyyy年MM月"
     */
    public static final String yyyyMMChineseFormat = "yyyy年MM月";
    /**
     * fullChineseFormat="yyyy年MM月dd日HH时mm分ss秒"
     */
    public static final String fullChineseFormat = "yyyy年MM月dd日HH时mm分ss秒";
    /**
     * WEEKS={"星期日","星期一","星期二","星期三","星期四","星期五","星期六"}
     */
    public static final String[] WEEKS = {"星期日", "星期一", "星期二", "星期三", "星期四",
            "星期五", "星期六"};

    /**
     * 得到指定时间的时间日期格式
     *
     * @param date   指定的时间
     * @param format 时间日期格式
     * @return
     */
    public static String getFormatDateTime(Date date, String format) {
        if (date == null) return "";
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * 得到指定时间的时间日期格式(返回date)
     *
     * @param date   指定的时间
     * @param format 时间日期格式
     * @return
     */
    public static Date getDateFormatDateTime(Date date, String format) {
        DateFormat df = new SimpleDateFormat(format);
        String s = df.format(date);
        try {
            return df.parse(s);
        } catch (ParseException e) {
        }
        ;
        return date;
    }

    public static String getFormatDateToday(String format) {
        return getFormatDateTime(new Date(), format);
    }

    /**
     * 判断是否是润年
     *
     * @param date 指定的时间
     * @return true:是润年,false:不是润年
     */
    public static boolean isLeapYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return isLeapYear(cal.get(Calendar.YEAR));
    }

    /**
     * 判断是否是润年
     *
     * @param date 指定的年
     * @return true:是润年,false:不是润年
     */
    public static boolean isLeapYear(int year) {
        GregorianCalendar calendar = new GregorianCalendar();
        return calendar.isLeapYear(year);
    }

    /**
     * 判断指定的时间是否是今天
     *
     * @param date 指定的时间
     * @return true:是今天,false:非今天
     */
    public static boolean isInToday(Date date) {
        boolean flag = false;
        Date now = new Date();
        String fullFormat = getFormatDateTime(now, DateUtilsHmy.yyyyMMddFormat);
        String beginString = fullFormat + " 00:00:00";
        String endString = fullFormat + " 23:59:59";
        DateFormat df = new SimpleDateFormat(DateUtilsHmy.fullFormat);
        try {
            Date beginTime = df.parse(beginString);
            Date endTime = df.parse(endString);
            flag = date.before(endTime) && date.after(beginTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 判断两时间是否是同一天
     *
     * @param from 第一个时间点
     * @param to   第二个时间点
     * @return true:是同一天,false:非同一天
     */
    public static boolean isSameDay(Date from, Date to) {
        boolean isSameDay = false;
        DateFormat df = new SimpleDateFormat(DateUtilsHmy.yyyyMMddFormat);
        String firstDate = df.format(from);
        String secondDate = df.format(to);
        isSameDay = firstDate.equals(secondDate);
        return isSameDay;
    }

    /**
     * 方法描述: 判断两时间是否是同一时间，精确到秒 作者:zhanglei 时间:2013-11-2下午04:22:33
     *
     * @param from 第一个时间点
     * @param to   第二个时间点
     * @return true:是,false:非
     */
    public static boolean isSameTime(Date from, Date to) {
        boolean isSameDay = false;
        DateFormat df = new SimpleDateFormat(DateUtilsHmy.yyyyMMddHHmmss);
        String firstDate = df.format(from);
        String secondDate = df.format(to);
        isSameDay = firstDate.equals(secondDate);
        return isSameDay;
    }

    /**
     * 求出指定的时间那天是星期几
     *
     * @param date 指定的时间
     * @return 星期X
     */
    public static String getWeekString(Date date) {
        return DateUtilsHmy.WEEKS[getWeek(date) - 1];
    }

    /**
     * 求出指定时间那天是星期几
     *
     * @param date 指定的时间
     * @return 0-6 分别代表星期日-星期六
     */
    public static int getWeekDay(Date date) {
        int week = getWeek(date);
        return week - 1;
    }

    /**
     * 求出指定时间那天是星期几
     *
     * @param date 指定的时间
     * @return 1-7
     */
    public static int getWeek(Date date) {
        int week = 0;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        week = cal.get(Calendar.DAY_OF_WEEK);
        return week;
    }

    /**
     * 取得指定时间离现在是多少时间以前，如：3秒前,2小时前等 注意：此计算方法不是精确的
     *
     * @param date 已有的指定时间
     * @return 时间段描述
     */
    public static String getAgoTimeString(Date date) {
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        Date agoTime = cal.getTime();
        long mtime = now.getTime() - agoTime.getTime();
        String str = "";
        long stime = mtime / 1000;
        long minute = 60;
        long hour = 60 * 60;
        long day = 24 * 60 * 60;
        long weeks = 7 * 24 * 60 * 60;
        long months = 100 * 24 * 60 * 60;
        if (stime < minute) {
            long time_value = stime;
            if (time_value <= 0) {
                time_value = 1;
            }
            str = time_value + "秒前";
        } else if (stime >= minute && stime < hour) {
            long time_value = stime / minute;
            if (time_value <= 0) {
                time_value = 1;
            }
            str = time_value + "分前";
        } else if (stime >= hour && stime < day) {
            long time_value = stime / hour;
            if (time_value <= 0) {
                time_value = 1;
            }
            str = time_value + "小时前";
        } else if (stime >= day && stime < weeks) {
            long time_value = stime / day;
            if (time_value <= 0) {
                time_value = 1;
            }
            str = time_value + "天前";
        } else if (stime >= weeks && stime < months) {
            DateFormat df = new SimpleDateFormat(DateUtilsHmy.MMddFormat);
            str = df.format(date);
        } else {
            DateFormat df = new SimpleDateFormat(DateUtilsHmy.yyyyMMddFormat);
            str = df.format(date);
        }
        return str;
    }

    /**
     * 判断指定时间是否是周末
     *
     * @param date 指定的时间
     * @return true:是周末,false:非周末
     */
    public static boolean isWeeks(Date date) {
        boolean isWeek = false;
        isWeek = (getWeek(date) - 1 == 0 || getWeek(date) - 1 == 6);
        return isWeek;
    }

    /**
     * 得到今天的最开始时间
     *
     * @return 今天的最开始时间
     */
    public static Date getTodayBeginTime() {
        Date beginTime = new Date();
        beginTime = getBeginTime(beginTime);
        return beginTime;
    }

    /**
     * 得到指定日期的最开始时间
     *
     * @return 今天的最开始时间
     */
    public static Date getBeginTime(Date date) {
        Date beginTime = date;
        String beginString = getFormatDateTime(beginTime, DateUtilsHmy.yyyyMMddFormat) + " 00:00:00";
        beginTime = str2Date(beginString, DateUtilsHmy.fullFormat);
        return beginTime;
    }

    public static String getBeginTimeStr(Date date) {
        Date beginTime = date;
        String beginString = getFormatDateTime(beginTime, DateUtilsHmy.yyyyMMddFormat) + " 00:00:00";
        return beginString;
    }


    /**
     * 得到今天的最后结束时间
     *
     * @return 今天的最后时间
     */
    public static Date getTodayEndTime() {
        Date endTime = new Date();
        endTime = getEndTime(endTime);
        return endTime;
    }

    /**
     * 得到指定日期的最后结束时间
     *
     * @return 今天的最后时间
     */
    public static Date getEndTime(Date date) {

        Date endTime = date;
        String beginString = getFormatDateTime(endTime, DateUtilsHmy.yyyyMMddFormat) + " 23:59:59";
        endTime = str2Date(beginString, DateUtilsHmy.fullFormat);
        return endTime;
    }

    public static String getEndTimeStr(Date date) {

        Date endTime = date;
        String endString = getFormatDateTime(endTime, DateUtilsHmy.yyyyMMddFormat) + " 23:59:59";
        return endString;
    }


    /**
     * 取得本周的开始时间
     *
     * @return 本周的开始时间
     */
    public static Date getThisWeekBeginTime() {
        Date beginTime = null;
        Calendar cal = Calendar.getInstance();
        int week = getWeek(cal.getTime());
        week = week - 1;
        int days = 0;
        if (week == 0) {
            days = 6;
        } else {
            days = week - 1;
        }
        cal.add(Calendar.DAY_OF_MONTH, -days);
        beginTime = cal.getTime();
        return beginTime;
    }

    /**
     * 取得指定日期所在周的开始时间
     *
     * @return 本周的开始时间
     */
    public static Date getThisWeekBeginTime(Date date) {
        Date beginTime = null;
        int week = getWeek(date);
        week = week - 1;
        int days = 0;
        if (week == 0) {
            days = 6;
        } else {
            days = week - 1;
        }
        beginTime = addDays(date, -days);
        return beginTime;
    }

    /**
     * 取得本周的开始日期
     *
     * @param format 时间的格式
     * @return 指定格式的本周最开始时间
     */
    public static String getThisWeekBeginTimeString(String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(getThisWeekBeginTime());
    }

    /**
     * 取得本周的结束时间
     *
     * @return 本周的结束时间
     */
    public static Date getThisWeekEndTime() {
        Date endTime = null;
        Calendar cal = Calendar.getInstance();
        int week = getWeek(cal.getTime());
        week = week - 1;
        int days = 0;
        if (week != 0) {
            days = 7 - week;
        }
        cal.add(Calendar.DAY_OF_MONTH, days);
        endTime = cal.getTime();
        return endTime;
    }

    /**
     * 取得指定日期所在周的结束时间
     *
     * @return 本周的结束时间
     */
    public static Date getThisWeekEndTime(Date date) {
        Date endTime = null;
        int week = getWeek(date);
        week = week - 1;
        int days = 0;
        if (week != 0) {
            days = 7 - week;
        }
        endTime = addDays(date, days);
        return endTime;
    }

    /**
     * 取得本周的结束日期
     *
     * @param format 时间的格式
     * @return 指定格式的本周结束时间
     */
    public static String getThisWeekEndTimeString(String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(getThisWeekEndTime());
    }

    /**
     * 取得两时间相差的天数
     *
     * @param from 第一个时间
     * @param to   第二个时间
     * @return 相差的天数
     */
    public static long getBetweenDays(Date from, Date to) {
        long days = 0;
        long dayTime = 24 * 60 * 60 * 1000;
        long fromTime = from.getTime();
        long toTime = to.getTime();
        long times = Math.abs(fromTime - toTime);
        days = times / dayTime;
        return days;
    }

    /**
     * 获取时间相隔年份
     *
     * @param from
     * @param to
     * @return
     * @author zhanglei 2017-10-20 下午2:51:10
     */
    public static long getBetweenYears(Date from, Date to) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(from);
        int year = cal.get(Calendar.YEAR);
        cal.setTime(to);
        int year2 = cal.get(Calendar.YEAR);
        long years = Math.abs(year2 - year);
        return years;
    }

    /**
     * 取得两时间相差的小时数
     *
     * @param from 第一个时间
     * @param to   第二个时间
     * @return 相差的小时数
     */
    public static long getBetweenHours(Date from, Date to) {
        long hours = 0;
        long hourTime = 60 * 60 * 1000;
        long fromTime = from.getTime();
        long toTime = to.getTime();
        long times = Math.abs(fromTime - toTime);
        hours = times / hourTime;
        return hours;
    }

    /**
     * 取得两时间相差的分钟数
     *
     * @param from 第一个时间
     * @param to   第二个时间
     * @return 相差的分钟数
     */
    public static long getBetweenMinutes(Date from, Date to) {
        long m = 0;
        long mTime = 60 * 1000;
        long fromTime = from.getTime();
        long toTime = to.getTime();
        long times = Math.abs(fromTime - toTime);
        m = times / mTime;
        return m;
    }

    /**
     * 取得两时间相差的秒数
     *
     * @param from 第一个时间
     * @param to   第二个时间
     * @return 相差的秒数
     */
    public static long getBetweenSeconds(Date from, Date to) {
        long s = 0;
        long sTime = 1000;
        long fromTime = from.getTime();
        long toTime = to.getTime();
        long times = Math.abs(fromTime - toTime);
        s = times / sTime;
        return s;
    }

    /**
     * 取得在指定时间上加减 minute 分钟后的时间
     *
     * @param date
     * @param minute
     * @return
     * @author zhanglei 2015 三月 24 10:15:21
     */
    public static Date addMinutes(Date date, int minute) {
        Date time = null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minute);
        time = cal.getTime();
        return time;
    }


    /**
     * 取得在指定时间上加减days天后的时间
     *
     * @param date 指定的时间
     * @param days 天数,正为加，负为减
     * @return 在指定时间上加减days天后的时间
     */
    public static Date addDays(Date date, int days) {
        Date time = null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, days);
        time = cal.getTime();
        return time;
    }

    /**
     * 取得在指定时间上加减months月后的时间
     *
     * @param date   指定时间
     * @param months 月数，正为加，负为减
     * @return 在指定时间上加减months月后的时间
     */
    public static Date addMonths(Date date, int months) {
        Date time = null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months);
        time = cal.getTime();
        return time;
    }

    /**
     * 取得在指定时间上加减years年后的时间
     *
     * @param date  指定时间
     * @param years 年数，正为加，负为减
     * @return 在指定时间上加减years年后的时间
     */
    public static Date addYears(Date date, int years) {
        Date time = null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, years);
        time = cal.getTime();
        return time;
    }

    /**
     * 方法说明："yyyyMMddHHmmss"格式的字符串转成日期
     *
     * @param str_date
     * @return date
     * @author zhanglei
     * @createDate 2013-10-24 上午01:35:15
     */
    public static Date str2Date(String str_date, String format) {
        Date date = null;
        DateFormat df = new SimpleDateFormat(format == null ? DateUtilsHmy.yyyyMMddHHmmss : format);
        try {
            date = df.parse(str_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取当前年度
     *
     * @return
     */
    public static String getCurYear() {
        Calendar calendar = Calendar.getInstance();
        int yearInt = calendar.get(Calendar.YEAR);
        return String.valueOf(yearInt);
    }

    public static Date getFirstDayOfYear(String year) {
        Calendar calendar = Calendar.getInstance();
        if (year != null && !year.isEmpty()) {
            int yearInt = Integer.valueOf(year);
            calendar.set(Calendar.YEAR, yearInt);
        }
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static Date getLastDayOfYear(String year) {
        Calendar calendar = Calendar.getInstance();
        if (year != null && !year.isEmpty()) {
            int yearInt = Integer.valueOf(year);
            calendar.set(Calendar.YEAR, yearInt);
        }
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.DAY_OF_MONTH, 31);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    public static Date getLastDayOfQuarter(String year, int quarter) {
        Calendar calendar = Calendar.getInstance();
        if (year != null && !year.isEmpty()) {
            int yearInt = Integer.valueOf(year);
            calendar.set(Calendar.YEAR, yearInt);
        }
        if (quarter == 1) {
            calendar.set(Calendar.MONTH, 2);
            calendar.set(Calendar.DAY_OF_MONTH, 31);
        } else if (quarter == 2) {
            calendar.set(Calendar.MONTH, 5);
            calendar.set(Calendar.DAY_OF_MONTH, 30);
        } else if (quarter == 3) {
            calendar.set(Calendar.MONTH, 8);
            calendar.set(Calendar.DAY_OF_MONTH, 30);
        } else if (quarter == 4) {
            calendar.set(Calendar.MONTH, 11);
            calendar.set(Calendar.DAY_OF_MONTH, 31);
        }
        return calendar.getTime();
    }

    /**
     * 获取一个月的第一天
     *
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static Date getMonthFirstDate(String dateStr) throws ParseException {
        DateFormat df = new SimpleDateFormat(yyyyMMFormat);
        Date data = df.parse(dateStr);
        return data;
    }

    /**
     * 获取一个月的最后一天
     *
     * @param dateStr yyyy-MM
     * @return
     * @throws ParseException
     */
    public static Date getMonthLastDate(String dateStr) throws ParseException {
        DateFormat df = new SimpleDateFormat(yyyyMMFormat);
        Date data = df.parse(dateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        int value = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, value);
        return calendar.getTime();
    }

    public static void main(String[] args) {
        System.out.println(DateUtilsHmy.str2Date("2020年10月28日", DateUtilsHmy.yyyyMMddChineseFormat));
        System.out.println(new Date(1595174400000L));
    }
}
