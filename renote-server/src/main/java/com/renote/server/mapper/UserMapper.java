package com.renote.server.mapper;

import com.renote.core.model.User;

/**
 * @author joder
 * @create 19-5-25
 **/
public interface UserMapper {

    /**
     * 保存
     * @param user
     * @return
     */
    int save(User user);

    /**
     * update
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 删除
     * @param userId
     * @return
     */
    int delete(Long userId);

    /**
     * get
     * @param userId
     * @return
     */
    User getUserById(Long userId);

    /**
     * 登录
     * @param user
     * @return
     */
    User getUser(User user);
}
