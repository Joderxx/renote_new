package com.renote.core.model;

import lombok.Data;

/**
 * @author joder
 * @create 19-5-25
 **/
@Data
public class NoteContent {

    private Long contentId;
    private Long privateId;
    private Long createTime;
    private byte[] content;
    private String tags;
}
