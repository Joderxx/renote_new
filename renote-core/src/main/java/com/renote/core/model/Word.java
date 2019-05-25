package com.renote.core.model;

import lombok.Data;

/**
 * @author joder
 * @create 19-5-25
 **/
@Data
public class Word {

    private Long wordId;
    private String name;
    private String url;
    private String description;
}
