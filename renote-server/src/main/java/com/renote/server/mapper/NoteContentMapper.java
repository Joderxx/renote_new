package com.renote.server.mapper;

import com.renote.core.model.NoteContent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author joder
 * @create 19-5-25
 **/
public interface NoteContentMapper {

    /**
     * 保存
     *
     * @param noteContent
     * @return
     */
    int save(NoteContent noteContent);

    /**
     * 更新标签
     *
     * @param contentId
     * @param tags
     * @return
     */
    int updateTag(@Param("contentId") Long contentId, @Param("tags") String tags);

    /**
     * 获得content
     *
     * @param contentId
     * @return
     */
    NoteContent get(Long contentId);

    /**
     * 取得某篇的历史信息时间和ＩＤ
     *
     * @param privateId
     * @return
     */
    List<NoteContent> getTimeList(Long privateId);
}
