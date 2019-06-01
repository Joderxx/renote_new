package com.renote.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author joder
 * @date 19-5-26
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdviceMessage {

    private Long userId;
    private Message message;
}
