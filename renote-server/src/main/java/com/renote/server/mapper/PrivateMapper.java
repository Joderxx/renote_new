package com.renote.server.mapper;

import com.renote.core.model.PrivateNote;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author joder
 * @create 19-5-25
 **/
public interface PrivateMapper {

    /**
     * 保存
     *
     * @param privateNote
     * @return
     */
    int save(PrivateNote privateNote);

    /**
     * 修改filename,del,parentId
     *
     * @param privateNote
     * @return
     */
    int update(PrivateNote privateNote);

    /**
     * 删除
     *
     * @param privateId
     * @return
     */
    int delete(Long privateId);

    /**
     * 是否重名,userId,type,parentId,filename
     *
     * @param privateNote
     * @return
     */
    int existName(PrivateNote privateNote);

    /**
     * 获得列表
     *
     * @param userId
     * @param parentId
     * @return
     */
    List<PrivateNote> getList(@Param("userId") Long userId, @Param("parentId") Long parentId);


}
