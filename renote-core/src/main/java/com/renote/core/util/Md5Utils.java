package com.renote.core.util;

import org.springframework.util.DigestUtils;

/**
 * @author joder
 * @create 19-5-26
 **/
public class Md5Utils {

    private static final String salt = "Hello Renote";

    private Md5Utils() {
    }

    public static String md5(String s) {
        return DigestUtils.md5DigestAsHex(StringUtils.concat(s, salt).getBytes());
    }
}
