package com.renote.server.service.key.impl;

import com.renote.core.util.StringUtils;
import com.renote.server.service.key.KeyService;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author joder
 * @create 19-5-26
 **/
@Service("localKeyService")
public class LocalKeyService implements KeyService {

    private ConcurrentMap<Long,String> keyMap = new ConcurrentHashMap<>();

    @Override
    public String general(Long userId) {
        String str = UUID.randomUUID().toString();
        keyMap.put(userId,str);
        return str;
    }

    @Override
    public boolean comsume(Long userId, String key) {
        if (StringUtils.isEmpty(key)){
            return false;
        }
        String str = keyMap.getOrDefault(userId, "");
        return str.equals(key);
    }
}
