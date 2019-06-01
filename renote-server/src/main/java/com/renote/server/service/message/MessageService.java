package com.renote.server.service.message;

/**
 * 消息推送
 *
 * @author joder
 * @date 19-5-26
 **/
public interface MessageService<T> {

    /**
     * 放入消息
     *
     * @param data
     * @return
     */
    boolean put(T data);

    /**
     * 取出消息
     *
     * @return
     */
    T get();
}
