package com.renote.core.model;

import lombok.Data;

/**
 * @author joder
 * @create 19-5-25
 **/
@Data
public class PublicNote {

    private Long publicId;
    private String filename;
    private String type;
    private Long createTime;
    private Long userId;
    private Long privateId;
    private Long parentId;
    private Integer watch;
    private Integer comment;
}
