package com.renote.core.model;

import lombok.Data;

/**
 * @author joder
 * @create 19-5-25
 **/
@Data
public class ShareNote {

    private Long shareId;
    private String filename;
    private String type;
    private Long expiredTime;
    private Long privateId;
    private Long userId;
    private String sign;
    private Boolean key;
    private Integer watch;
    private Integer comment;
}
