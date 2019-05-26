package com.renote.server.mapper;

import com.renote.core.model.ShareNote;

/**
 * @author joder
 * @create 19-5-25
 **/
public interface ShareMapper {

    /**
     * 保存
     * @param shareNote
     * @return
     */
    int save(ShareNote shareNote);

    /**
     * 更新
     * @param shareNote
     * @return
     */
    int update(ShareNote shareNote);

    /**
     * 删除
     * @param shareId
     * @return
     */
    int delete(Long shareId);

    /**
     * get
     * @param shareNote
     * @return
     */
    ShareNote get(ShareNote shareNote);
}
