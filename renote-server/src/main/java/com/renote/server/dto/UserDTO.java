package com.renote.server.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author joder
 * @date 19-6-1
 **/
@Data
public class UserDTO {

    @NotNull
    @NotBlank
    private String username;
    @NotNull
    @NotBlank
    private String password;
    @Email
    private String email;
}
