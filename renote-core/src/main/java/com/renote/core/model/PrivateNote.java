package com.renote.core.model;

import lombok.Data;

/**
 * @author joder
 * @create 19-5-25
 **/
@Data
public class PrivateNote {

    private Long privateId;
    private String filename;
    private String type;
    private Long createTime;
    private Long userId;
    private Long parentId;
    private Long contentId;
    private String source;
    private String suffix;
    private Boolean del;
}
