package com.renote.server.websocket;

import com.renote.core.dto.Message;
import com.renote.core.util.Md5Utils;
import com.renote.core.util.MessageUtils;
import com.renote.core.util.StringUtils;
import com.renote.core.util.TimeUtils;
import com.renote.server.websocket.entry.SocketEntry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author joder
 * @create 19-5-26
 **/
@ServerEndpoint("/userTipSocket/{userId}/{time}/{md5}")
@RestController
@Slf4j
public class UserTipSocket {


    private static ConcurrentMap<Long, SocketEntry> map = new ConcurrentHashMap<>();
    private static Thread thread = null;

    //定时清除过时连接
    static {
        thread = new Thread(() -> {
            while (true) {
                long now = TimeUtils.getNow();
                if (map.size() > 0) {
                    Iterator<Map.Entry<Long, SocketEntry>> iterator = map.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<Long, SocketEntry> entry = iterator.next();
                        SocketEntry e = entry.getValue();
                        if (now > e.getExpireTime() || !e.getSession().isOpen()) {
                            iterator.remove();
                        }
                    }
                }
                try {
                    Thread.sleep(60 * 60 * 1000);
                } catch (InterruptedException e) {
                    log.error("Thread Error", e);
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    public static void sendMessage(Long userId, Message message) throws Exception {
        SocketEntry entry = map.get(userId);
        long now = TimeUtils.getNow();
        if (entry != null && now <= entry.getExpireTime() && entry.getSession().isOpen()) {
            entry.getSession().getAsyncRemote().sendObject(message);
        }
    }

    @OnOpen
    public void onOpen(Session session,
                       @PathParam("userId") Long userId,
                       @PathParam("time") Long time,
                       @PathParam("md5") String md5) throws Exception {
        if (TimeUtils.getNow() > time) {
            Message message = MessageUtils.build(401, "账号认证过期.", null);
            session.getAsyncRemote().sendObject(message);
        }
        String sign = Md5Utils.md5(StringUtils.concat(userId, time));
        if (StringUtils.isEmpty(sign) || !sign.equals(md5)) {
            Message message = MessageUtils.build(401, "账号未认证.", null);
            session.getAsyncRemote().sendObject(message);
        } else {
            SocketEntry socketEntry = new SocketEntry(session, userId, time);
            map.put(userId, socketEntry);
            session.getAsyncRemote().sendObject(MessageUtils.buildSuccess());
        }
    }

    @OnClose
    public void onClose() {
        log.error("Close");
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("Receive a message from client: " + message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        session.getAsyncRemote().sendObject(MessageUtils.buildError());
    }
}
