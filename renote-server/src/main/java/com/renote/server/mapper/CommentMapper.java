package com.renote.server.mapper;

import com.renote.core.model.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author joder
 * @create 19-5-25
 **/
public interface CommentMapper {

    /**
     * @param comment
     * @return
     */
    int save(Comment comment);

    /**
     * 删除
     *
     * @param comment
     * @return
     */
    int delete(Long comment);

    /**
     * 获得ｐｕｂｌｉｃ评论
     *
     * @param publicId
     * @param parentId
     * @return
     */
    List<Comment> getPublicList(@Param("publicId") Long publicId, @Param("parentId") Long parentId);

    /**
     * 获得share评论
     *
     * @param shareId
     * @param parentId
     * @return
     */
    List<Comment> getShareList(@Param("shareId") Long shareId, @Param("parentId") Long parentId);

    /**
     * @param commentId
     * @return
     */
    Comment get(Long commentId);
}
