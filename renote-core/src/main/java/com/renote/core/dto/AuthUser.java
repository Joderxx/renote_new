package com.renote.core.dto;

import com.renote.core.model.Role;
import lombok.Data;

import java.util.List;

/**
 * @author joder
 * @date 19-6-1
 **/
@Data
public class AuthUser {
    private String username;
    private String password;
    private Long createTime;
    private List<Role> roles;
}
