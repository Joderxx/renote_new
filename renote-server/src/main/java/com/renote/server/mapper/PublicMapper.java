package com.renote.server.mapper;

import com.renote.core.model.PublicNote;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author joder
 * @create 19-5-25
 **/
public interface PublicMapper {

    /**
     * 保存
     *
     * @param publicNote
     * @return
     */
    int save(PublicNote publicNote);

    /**
     * 更新文件名或者父节点
     *
     * @param publicNote
     * @return
     */
    int update(PublicNote publicNote);

    /**
     * watch自增
     *
     * @param publicId
     * @return
     */
    int incrWatch(Long publicId);

    /**
     * comment自增
     *
     * @param publicId
     * @return
     */
    int incrComment(Long publicId);

    /**
     * 删除
     *
     * @param publicId
     * @return
     */
    int delete(Long publicId);

    /**
     * 获得某路径下的文件列表
     *
     * @param userId
     * @param parentId
     * @return
     */
    List<PublicNote> getDirList(@Param("userId") Long userId,
                                @Param("parentId") Long parentId);
}
