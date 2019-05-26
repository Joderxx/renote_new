package com.renote.server.service.key.impl;

import com.renote.server.service.key.KeyService;

/**
 * @author joder
 * @create 19-5-26
 **/
public class RedisKeyService implements KeyService {
    @Override
    public String general(Long userId) {
        return null;
    }

    @Override
    public boolean comsume(Long userId, String key) {
        return false;
    }
}
