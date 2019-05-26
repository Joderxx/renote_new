package com.renote.server.service.key;

/**
 * 防止重复提交
 *
 * @author joder
 * @create 19-5-26
 **/
public interface KeyService {

    /**
     * 生成唯一ｋｅｙ
     *
     * @param userId
     * @return
     */
    String general(Long userId);

    /**
     * 消费ｋｅｙ,放回结果
     *
     * @param userId
     * @param key
     * @return
     */
    boolean comsume(Long userId, String key);
}
