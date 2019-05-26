package com.renote.server.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author joder
 * @create 19-5-26
 **/
public interface GroupRoleMapper {

    /**
     * 保存
     *
     * @param groupId
     * @param roleId
     * @return
     */
    int save(@Param("groupId") Integer groupId, @Param("roleId") Integer roleId);

    /**
     * 删除
     *
     * @param groupId
     * @param roleId
     * @return
     */
    int delete(@Param("groupId") Integer groupId, @Param("roleId") Integer roleId);
}
