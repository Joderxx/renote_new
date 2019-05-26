package com.renote.core.util;

/**
 * @author joder
 * @create 19-5-25
 **/
public class StringUtils {

    private StringUtils() {
    }

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static String concat(String... arr) {
        StringBuilder sb = new StringBuilder();
        if (arr.length > 0) {
            for (String e : arr) {
                sb.append(e);
            }
        }
        return sb.toString();
    }
}
