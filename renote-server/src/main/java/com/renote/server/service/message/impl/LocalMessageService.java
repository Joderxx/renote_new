package com.renote.server.service.message.impl;

import com.renote.core.dto.AdviceMessage;
import com.renote.server.service.message.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author joder
 * @date 19-5-26
 **/
@Slf4j
@Service
public class LocalMessageService implements MessageService<AdviceMessage> {

    LinkedBlockingQueue<AdviceMessage> queue = new LinkedBlockingQueue<>();

    @Override
    public boolean put(AdviceMessage data) {
        return queue.offer(data);
    }

    @Override
    public AdviceMessage get() {
        return queue.poll();
    }
}
