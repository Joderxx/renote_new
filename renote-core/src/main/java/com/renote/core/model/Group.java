package com.renote.core.model;

import lombok.Data;

import java.util.List;

/**
 * @author joder
 * @create 19-5-25
 **/
@Data
public class Group {

    private Integer groupId;
    private String name;
    private String description;
    private List<Role> roles;
}
