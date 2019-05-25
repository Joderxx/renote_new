package com.renote.core.model;

import lombok.Data;

/**
 * @author joder
 * @create 19-5-25
 **/
@Data
public class Advice {

    private Long adviceId;
    private String message;
    private Long userId;
    private Long createTime;
    private Boolean watch;
}
