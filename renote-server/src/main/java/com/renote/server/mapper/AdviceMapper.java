package com.renote.server.mapper;

import com.renote.core.model.Advice;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author joder
 * @create 19-5-25
 **/
@Mapper
public interface AdviceMapper {


    int save(Advice advice);
}
