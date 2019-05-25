package com.renote.core.model;

import lombok.Data;

/**
 * @author joder
 * @create 19-5-25
 **/
@Data
public class Comment {

    private Long commentId;
    private String content;
    private Long createTime;
    private Long userId;
    private Long publicId;
    private Long shareId;
    private Long parentId;

}
