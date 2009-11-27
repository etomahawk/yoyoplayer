package com.chinacnd.framework.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Hades
 */
public class DateUtils {

    public final static String[] SUPPORTED_FORMATS = {"yyyy-MM-dd", "MM/dd/yyyy HH:mm:ss", "MM-dd-yyyy HH:mm:ss", "MM-dd-yyyy hh:mm:ss a", "MM-dd-yyyy",
        "MM-dd-yy", "MM/dd/yyyy", "MM.dd.yyyy", "MM.dd.yy", "MMddyyyy", "MMddyy"};
    public static SimpleDateFormat SHORT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat FULL_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static Date date(int year, int month, int day) {
        return date(year, month, day, 0, 0, 0);
    }

    public static Date date(int year, int month, int day, int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, minute, second);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 偿试去格式化一个字符串为日期，如果无法转换，返回null
     * @param s
     * @return
     */
    public static Date tryToConvertStringToDate(String s){
        return null;
    }

    public static Date add(Date date, int field, int value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, value);
        return calendar.getTime();
    }

    public static Calendar calendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar;
    }

    public static int age(Date dateOfBirth, Date targetDate) {
        Calendar birth = calendar(dateOfBirth);
        Calendar target = calendar(targetDate);
        int age = target.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        if ((birth.get(Calendar.MONTH) > target.get(Calendar.MONTH)) || (birth.get(Calendar.MONTH) == target.get(Calendar.MONTH) && birth.get(Calendar.DAY_OF_MONTH) > target.get(Calendar.DAY_OF_MONTH))) {
            age--;
        }
        return age;
    }

    public static String format(Date date, String format) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(format).format(date);
    }

    public static String formatShortDate(Date date) {
        return SHORT_DATE_FORMAT.format(date);
    }

    public static String formatFulltDate(Date date) {
        return FULL_DATE_FORMAT.format(date);
    }

    public static Date toFullDate(String text) {
        if (StringUtils.isEmpty(text)) {
            return null;
        }
        try {
            return FULL_DATE_FORMAT.parse(text);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date toDate(String string) {
        if (string == null) {
            return null;
        }
        string = string.trim();
        SimpleDateFormat sdf = null;
        Date one = null;
        for (String format : SUPPORTED_FORMATS) {
            sdf = new SimpleDateFormat(format);
            sdf.setLenient(false);
            try {
                one = sdf.parse(string);
                return one;
            } catch (ParseException e) {
            }
        }
        return null;
    }

    public static void main(String[] args) {
        long time = 5152777777l;
        long h = time%3600l;
        long m = time%60l;
        System.out.println(h+":"+m);
    }
}
