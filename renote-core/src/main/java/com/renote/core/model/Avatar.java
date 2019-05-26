package com.renote.core.model;

import lombok.Data;

/**
 * @author joder
 * @create 19-5-25
 **/
@Data
public class Avatar {

    private Long avatarId;
    private byte[] content;
    private Long createTime;
    private Long modifiedTime;
    private String suffix;
    private Long userId;
}
