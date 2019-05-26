package com.renote.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author joder
 * @create 19-5-26
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message<T> {

    private Integer code;
    private String message;
    private T data;
}
