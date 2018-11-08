package com.sc.util.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期格式处理
 *
 * @author 孔垂云
 * @date 2017-05-23
 */
public class DateUtil {
    private static final String defaultDateFormatStr = "yyyy-MM-dd";//系统默认的格式化字符串
    public static final String defaultTimeFormatStr = "yyyy-MM-dd HH:mm:ss";//系统默认的格式化字符串
    public static final String defaultCnTimeFormatStr = "yyyy年MM月dd日HH时mm分ss秒";//系统中文默认的格式化字符串
    public static final String DEFAULT_SERVER_TIME_PATTERN = "HH:mm:";//交易时间


    /**
     * 日期转字符串
     *
     * @param date
     * @param formatStr 格式化字符串
     * @return
     */
    public static String dateToString(Date date, String formatStr) {
        DateFormat df = new SimpleDateFormat(formatStr);
        return df.format(date);
    }

    /**
     * 日期转字符串
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        return dateToString(date, defaultDateFormatStr);
    }

    /**
     * 字符串转换到时间格式
     *
     * @param dateStr   需要转换的字符串
     * @param formatStr 需要格式的目标字符串 比如 yyyy-MM-dd
     * @return Date 返回转换后的时间
     */
    public static Date stringToDate(String dateStr, String formatStr) {
        DateFormat sdf = new SimpleDateFormat(formatStr);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 取得系统时间，格式为yyyy-MM-dd HH:mm:ss
     *
     * @return
     * @author 孔垂云
     * @date 2017-05-23
     */
    public static String getSystemTime() {
        String strTime = "";
        DateFormat df = new SimpleDateFormat(defaultTimeFormatStr);
        strTime = df.format(new Date());
        return strTime;
    }

    /**
     * 取得系统日期，格式为yyyy-MM-dd
     *
     * @return
     */
    public static String getSystemDate() {
        String strDate = "";
        SimpleDateFormat df = new SimpleDateFormat(defaultDateFormatStr);
        strDate = df.format(new Date());
        return strDate;
    }


    /**
     * 取得系统时间
     *
     * @return
     */
    public static String getShortSystemTime() {
        String strTime = "";
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        strTime = df.format(new Date());
        return strTime;
    }


    /**
     * 取得系统短日期，yyyyMMdd
     *
     * @return
     */
    public static String getShortSystemDate() {
        String strTime = "";
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        strTime = df.format(new Date());
        return strTime;
    }

    /**
     * 系统时间加减
     *
     * @param date      当前日期
     * @param dayNum    加减的日期数
     * @param formatStr 格式化字符串
     * @return
     */
    public static String getOperaDate(String date, int dayNum, String formatStr) {
        Date dt = null;
        SimpleDateFormat df = new SimpleDateFormat(formatStr);
        try {
            dt = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dt);
        gc.add(5, dayNum);
        return df.format(gc.getTime());
    }

    /**
     * 系统时间加减，默认日期格式
     *
     * @param date   当前日期
     * @param dayNum 加减的日期数
     * @return
     */
    public static String getOperaDate(String date, int dayNum) {
        return getOperaDate(date, dayNum, defaultDateFormatStr);
    }

    /**
     * 系统月份加减
     *
     * @param date      日期字符串
     * @param monthNum  月份数
     * @param formatStr 格式化字符串
     * @return
     */
    public static String getOperaMonth(String date, int monthNum, String formatStr) {
        Date dt = null;
        SimpleDateFormat df = new SimpleDateFormat(formatStr);
        try {
            dt = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dt);
        gc.add(2, monthNum);
        return df.format(gc.getTime());
    }

    /**
     * 系统年份加减
     *
     * @param date      日期字符串
     * @param yearNum   年份数
     * @param formatStr 格式化字符串
     * @return
     */
    public static String getOperaYear(String date, int yearNum, String formatStr) {
        Date dt = null;
        SimpleDateFormat df = new SimpleDateFormat(formatStr);
        try {
            dt = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dt);
        gc.add(Calendar.YEAR, yearNum);
        return df.format(gc.getTime());
    }

    /**
     * 系统月份加减
     *
     * @param date
     * @param monthNum
     * @return
     */
    public static String getOperaMonth(String date, int monthNum) {
        return getOperaMonth(date, monthNum, "yyyy-MM");
    }

    /**
     * 系统年份加减
     *
     * @param date    日期字符串
     * @param yearNum 年份数
     * @return
     */
    public static String getOperaYear(String date, int yearNum) {
        return getOperaYear(date, yearNum, defaultDateFormatStr);
    }

    /**
     * 取得两个日期的时间差
     *
     * @param date1     日期1
     * @param date2     日期2
     * @param formatStr 格式化字符串
     * @return
     */
    public static int getDateDifference(String date1, String date2, String formatStr) {
        SimpleDateFormat formatter = new SimpleDateFormat(formatStr);
        ParsePosition pos = new ParsePosition(0);
        ParsePosition pos1 = new ParsePosition(0);
        Date dt1 = formatter.parse(date1, pos);
        Date dt2 = formatter.parse(date2, pos1);
        int l = (int) ((dt2.getTime() - dt1.getTime()) / (3600 * 24 * 1000));
        return l;
    }

    /**
     * 取得两个日期的时间差，两个都是字符串
     *
     * @param date1 日期1
     * @param date2 日期2
     * @return
     */
    public static int getDateDifference(String date1, String date2) {
        return getDateDifference(date1, date2, defaultDateFormatStr);
    }

    /**
     * 取得两个日期的时间差,两个都是日期型
     *
     * @param date1 日期1
     * @param date2 日期2
     * @return
     */
    public static int getHourDifference(Date date1, Date date2) {
        int l = (int) ((date1.getTime() - date2.getTime()) / (3600 * 1000));
        return l;
    }

    /**
     * 取得两个日期的月份差
     *
     * @param date1     日期1
     * @param date2     日期2
     * @param formatStr 格式化字符换
     * @return
     */
    public static int getMonthDifference(String date1, String date2, String formatStr) {
        int result = 0;
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(sdf.parse(date1));
            c2.setTime(sdf.parse(date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int monthDiff = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
        int yearDiff = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
        result = monthDiff + yearDiff * 12;
        return result == 0 ? 1 : Math.abs(result);
    }

    /**
     * 取得两个日期的月份差
     *
     * @param date1 日期1
     * @param date2 日期2
     * @return
     */
    public static int getMonthDifference(String date1, String date2) {
        int result = 0;
        SimpleDateFormat sdf = new SimpleDateFormat(defaultDateFormatStr);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(sdf.parse(date1));
            c2.setTime(sdf.parse(date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int monthDiff = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
        int yearDiff = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
        result = monthDiff + yearDiff * 12;
        return result;
    }

    /**
     * 取得两个日期的月份差
     *
     * @param date1 日期1
     * @param date2 日期2
     * @return
     */
    public static int getMonthDifference(Date date1, Date date2) {
        int result;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date1);
        c2.setTime(date2);
        int monthDiff = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
        int yearDiff = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
        result = monthDiff + yearDiff * 12;
        return result;
    }

    /**
     * 取得当月最后一天
     *
     * @return
     */
    public static String getLastDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));// 年
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH));// 月，因为Calendar里的月是从0开始，所以要减1
        cal.set(Calendar.DATE, 1);// 日，设为一号
        cal.add(Calendar.MONTH, 1);// 月份加一，得到下个月的一号
        cal.add(Calendar.DATE, -1);// 下一个月减一为本月最后一天
        return new SimpleDateFormat(defaultDateFormatStr).format(cal.getTime());
    }

    /**
     * 取得当月第一天
     *
     * @return
     */
    public static String getFirstDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));// 年
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH));// 月，因为Calendar里的月是从0开始，所以要减1
        cal.set(Calendar.DATE, 1);// 日，设为一号
        String df = new SimpleDateFormat(defaultDateFormatStr).format(cal.getTime());
        return df;// 获得月初是几号
    }

    /**
     * 取得这个月的第一天
     *
     * @param dateStr 日期字符串
     */
    public static String getFirstDayOfMonth(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(defaultDateFormatStr);
        Date date = null;
        String str = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.DATE, 1);
            str = sdf.format(calendar.getTime());
        }
        return str;
    }

    /**
     * 取得上个月的第一天
     *
     * @return
     * @author 孔垂云
     * @date 2017-05-23
     */
    public static String getFirstDayOfLastMonth() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));// 年
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH));// 月，因为Calendar里的月是从0开始，所以要减1
        cal.set(Calendar.DATE, 1);// 日，设为一号
        cal.add(Calendar.MONTH, -1);// 月份减一，得到上个月的一号
        String df = new SimpleDateFormat(defaultDateFormatStr).format(cal.getTime());
        return df;// 获得月初是几号
    }

    /**
     * 取得上个月的最后一天
     *
     * @return
     */
    public static String getLastDayOfLastMonth() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));// 年
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH));// 月，因为Calendar里的月是从0开始，所以要减1
        cal.set(Calendar.DATE, 1);// 日，设为一号
        cal.add(Calendar.MONTH, 0);// 月份加一，得到下下个月的一号
        cal.add(Calendar.DATE, -1);// 下下一个月减一为下个月最后一天
        String df = new SimpleDateFormat(defaultDateFormatStr).format(cal.getTime());
        return df;// 获得月末是几号
    }

    /**
     * 取得这个月的最后一天
     *
     * @param dateStr 日期字符串
     */
    public static String getLastDayOfMonth(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(defaultDateFormatStr);
        Date date = null;
        String str = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.DATE, 1);
            calendar.add(Calendar.MONTH, 1);
            calendar.add(Calendar.DATE, -1);
            str = sdf.format(calendar.getTime());
        }
        return str;
    }

    /**
     * 取得下个月的最后一天
     *
     * @return
     */
    public static String getLastDayOfNextMonth() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));// 年
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH));// 月，因为Calendar里的月是从0开始，所以要减1
        cal.set(Calendar.DATE, 1);// 日，设为一号
        cal.add(Calendar.MONTH, 2);// 月份加一，得到下下个月的一号
        cal.add(Calendar.DATE, -1);// 下下一个月减一为下个月最后一天
        String df = new SimpleDateFormat(defaultDateFormatStr).format(cal.getTime());
        return df;// 获得月末是几号
    }

    /**
     * 获取某个时间段的所有天数集合(包含起始日期与终止日期)
     *
     * @param starDate
     * @param endDate
     * @return
     */
    public static List<String> getDayList(String starDate, String endDate) {
        SimpleDateFormat format = new SimpleDateFormat(defaultDateFormatStr);
        List<String> dayList = new ArrayList<String>();
        if (starDate.equals(endDate)) {
            dayList.add(starDate);
        } else if (starDate.compareTo(endDate) < 0) {
            while (starDate.compareTo(endDate) <= 0) {
                dayList.add(starDate);
                long l = stringToDate(starDate, "yyyy-MM-dd").getTime();
                starDate = format.format(l + 3600 * 24 * 1000);
            }
        } else {
            dayList.add(endDate);
        }
        return dayList;
    }


    /**
     * 获取某个时间段的所有天数(包含起始日期与终止日期)
     *
     * @param starDate
     * @param endDate
     * @return
     */
    public static int getDays(String starDate, String endDate) {
        SimpleDateFormat format = new SimpleDateFormat(defaultDateFormatStr);
        List<String> dayList = new ArrayList<String>();
        if (starDate.equals(endDate)) {
            dayList.add(starDate);
        } else if (starDate.compareTo(endDate) < 0) {
            while (starDate.compareTo(endDate) <= 0) {
                dayList.add(starDate);
                long l = stringToDate(starDate, "yyyy-MM-dd").getTime();
                starDate = format.format(l + 3600 * 24 * 1000);
            }
        } else {
            dayList.add(endDate);
        }
        return dayList.size();
    }

    /**
     * 取得N个月前的今天
     *
     * @return
     */
    public static String getDayFromMonth(String date, int month) {
        SimpleDateFormat sdf = new SimpleDateFormat(defaultDateFormatStr);
        Calendar c = Calendar.getInstance();
        try {
            Date d = sdf.parse(date);
            c.setTime(d);
            c.add(Calendar.MONTH, -month);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat(defaultDateFormatStr).format(c.getTime());
    }

    /**
     * 取得下N年的今天
     *
     * @return
     */
    public static String getDayFromYear(String date, int year) {
        SimpleDateFormat sdf = new SimpleDateFormat(defaultDateFormatStr);
        Calendar c = Calendar.getInstance();
        try {
            Date d = sdf.parse(date);
            c.setTime(d);
            c.add(Calendar.YEAR, year);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat(defaultDateFormatStr).format(c.getTime());
    }

    /**
     * 根据消息发送日期，判断显示内容
     *
     * @param date
     * @return
     */
    public static String getShowDate(Date date) {
        String ret = "";
        //如果一天内，显示几点几分
        //其余显示日期
        int hoursDiff = getHourDifference(new Date(), date);
        if (hoursDiff <= 24) return dateToString(date, "HH:mm");
        return DateUtil.dateToString(date);
    }

    /**
     * 获取时分格式时间
     */
    public static String getServerTime() {
        return new SimpleDateFormat(DEFAULT_SERVER_TIME_PATTERN).format(System.currentTimeMillis());
    }

    public static void main(String[] args) throws ParseException {
//        System.out.println(DateUtil.getOperaDate("2018-02-08",-60));
//        System.out.println(DateUtil.getDays("2016-04-09", "2016-04-09"));
        System.out.println(DateUtil.getFirstDayOfLastMonth());
        System.out.println(DateUtil.getFirstDayOfMonth("2018-03-22"));
        System.out.println(DateUtil.getLastDayOfLastMonth());
        System.out.println(DateUtil.getLastDayOfMonth("2018-03-22"));
//        System.out.println(DateUtil.getLastDayOfLastMonth());
    }

}
