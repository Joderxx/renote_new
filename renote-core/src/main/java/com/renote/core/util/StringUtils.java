package com.renote.core.util;

/**
 * @author joder
 * @create 19-5-25
 **/
public class StringUtils {

    public static boolean isEmpty(String str){
        return str==null||"".equals(str.trim());
    }

    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}
