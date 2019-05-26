package com.renote.server.websocket.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.websocket.Session;

/**
 * @author joder
 * @create 19-5-26
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocketEntry {

    private Session session;
    private Long userId;
    private Long expireTime;
}
