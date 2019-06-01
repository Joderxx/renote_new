package com.renote.core.util;

import com.renote.core.dto.Message;

/**
 * @author joder
 * @create 19-5-26
 **/
public class MessageUtils {

    public static final int successCode = 1, errorCode = -1, failCode = -2;
    public static final String successMsg = "成功", errorMsg = "错误", failMsg = "失败";

    private MessageUtils() {
    }

    public static <T> Message<T> build(int code, String msg, T data) {
        Message message = new Message(code, msg, data);
        return message;
    }

    public static <T> Message<T> buildSuccess(String msg, T data) {
        return build(successCode, msg, data);
    }

    public static <T> Message<T> buildSuccess(T data) {
        return build(successCode, successMsg, data);
    }

    public static <T> Message<T> buildSuccess() {
        return build(successCode, successMsg, null);
    }

    public static <T> Message<T> buildError(T data) {
        return build(errorCode, errorMsg, data);
    }

    public static <T> Message<T> buildError() {
        return build(errorCode, errorMsg, null);
    }
}
