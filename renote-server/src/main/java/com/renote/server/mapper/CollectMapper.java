package com.renote.server.mapper;

import com.renote.core.model.CollectNote;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author joder
 * @create 19-5-25
 **/
public interface CollectMapper {

    /**
     * 保存
     *
     * @param collectNote
     * @return
     */
    int save(CollectNote collectNote);

    /**
     * 更新文件名或者父节点
     *
     * @param collectNote
     * @return
     */
    int update(CollectNote collectNote);

    /**
     * 删除
     *
     * @param collectId
     * @return
     */
    int delete(Long collectId);

    /**
     * 获得某路径下的文件列表
     *
     * @param userId
     * @param parentId
     * @return
     */
    List<CollectNote> getDirList(@Param("userId") Long userId,
                                 @Param("parentId") Long parentId);
}
