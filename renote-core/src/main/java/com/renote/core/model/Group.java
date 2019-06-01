package com.renote.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author joder
 * @create 19-5-25
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {

    private Integer groupId;
    private String name;
    private String description;
    private List<Role> roles;
}
