package com.renote.server.mapper;

import com.renote.core.model.Group;

/**
 * @author joder
 * @create 19-5-25
 **/
public interface GroupMapper {

    /**
     * 保存
     *
     * @param group
     * @return
     */
    int save(Group group);

    /**
     * 更新
     *
     * @param group
     * @return
     */
    int update(Group group);

    /**
     * 删除
     *
     * @param groupId
     * @return
     */
    int delete(Integer groupId);

    /**
     * 根据Ｉｄ取值
     *
     * @param groupId
     * @return
     */
    Group get(Integer groupId);
}
