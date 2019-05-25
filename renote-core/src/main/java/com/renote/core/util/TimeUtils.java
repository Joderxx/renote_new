package com.renote.core.util;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author joder
 * @create 19-5-25
 **/
public class TimeUtils {

    public static final String YYYY_MM_DD = "yyyy-MM-dd",
            YYYYMMDD = "yyyyMMdd",
            YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss",
            HH_MMSS = "HH:mm:ss",
            MM_DD = "MM-dd",
            YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final long ONE_DAY = 86400000L;

    /**
     * SimpleDateFormat F_YYYY_MM_DD = new SimpleDateFormat(YYYY_MM_DD);
     * SimpleDateFormat F_YYYYMMDD = new SimpleDateFormat(YYYYMMDD);
     * SimpleDateFormat F_YYYY_MM_DD_HH_mm_SS = new SimpleDateFormat(YYYY_MM_DD_HH_mm_SS);
     * SimpleDateFormat F_HH_mm_SS = new SimpleDateFormat(HH_mm_SS);
     * SimpleDateFormat F_MM_DD = new SimpleDateFormat(MM_DD);
     * SimpleDateFormat F_YYYY_MM_DD_HH_mm = new SimpleDateFormat(YYYY_MM_DD_HH_mm);
     */

    private TimeUtils() {
    }

    public static Date getNowDate() {
        return new Date();
    }

    public static Date getTodayDate() {
        Date date = getNowDate();
        SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD);
        try {
            return format.parse(format.format(date));
        } catch (ParseException e) {
            return null;
        }
    }

    public static synchronized long getNow() {
        return System.currentTimeMillis();
    }

    public static Date getDate(String str, String format) {
        SimpleDateFormat f = new SimpleDateFormat(format);
        Date parse = null;
        try {
            parse = f.parse(str);
        } catch (ParseException e) {
            parse = getTodayDate();
        }
        return parse;
    }

    public static String getString(Data date, String format) {
        SimpleDateFormat f = new SimpleDateFormat(format);
        return f.format(date);
    }

    public static Date getDay(Date date) {
        SimpleDateFormat f = new SimpleDateFormat(YYYY_MM_DD);
        try {
            return f.parse(f.format(date));
        } catch (ParseException e) {
            return null;
        }
    }

    public static int diffDay(Date date1, Date date2) {
        date1 = getDay(date1);
        date2 = getDay(date2);
        if (date1 == null && date2 == null) {
            return 0;
        } else if (date1 == null) {
            return -Integer.MAX_VALUE;
        } else if (date2 == null) {
            return Integer.MAX_VALUE;
        } else {
            return (int) ((date1.getTime() - date2.getTime()) / ONE_DAY);
        }
    }

    public static boolean compare(Date date1, Date date2) {
        return diffDay(date1, date2) > 0;
    }
}
