package com.renote.core.model;

import lombok.Data;

/**
 * @author joder
 * @create 19-5-25
 **/
@Data
public class User {

    private Long userId;
    private String username;
    private String password;
    private Long createTime;
    private Long experience;
    private Integer level;
    private Integer reward;
    private Boolean vip;
    private Long expireTime;
    private Integer groupId;
    private String email;
    private String phone;
    private String qq;
    private String wechat;
    private String alipay;
    private String github;

}
