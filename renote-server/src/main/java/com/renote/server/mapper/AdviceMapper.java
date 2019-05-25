package com.renote.server.mapper;

import com.renote.core.model.Advice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author joder
 * @create 19-5-25
 **/
@Mapper
public interface AdviceMapper {

    /**
     * 保存
     *
     * @param advice
     * @return
     */
    int save(Advice advice);

    /**
     * 获取用户通知
     *
     * @param userId
     * @return
     */
    List<Advice> getUserAdvice(@Param("userId") Long userId);

    /**
     * 修改通知为已读
     * @param adviceId
     * @return
     */
    int updateWatch(@Param("adviceId") Long adviceId);

}
