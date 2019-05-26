package com.renote.server.mapper;

import com.renote.core.model.Role;

import java.util.List;

/**
 * @author joder
 * @create 19-5-25
 **/
public interface RoleMapper {

    /**
     * 保存
     *
     * @param role
     * @return
     */
    int save(Role role);

    /**
     * 更新
     *
     * @param role
     * @return
     */
    int update(Role role);

    /**
     * 删除
     *
     * @param roleId
     * @return
     */
    int delete(Integer roleId);

    /**
     * 根据Ｉｄ取值
     *
     * @param roleId
     * @return
     */
    Role get(Integer roleId);

    /**
     * 根据groupId 获取roles
     *
     * @param groupId
     * @return
     */
    List<Role> getList(Integer groupId);
}
