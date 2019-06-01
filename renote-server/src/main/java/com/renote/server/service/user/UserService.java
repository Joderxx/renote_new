package com.renote.server.service.user;

import com.renote.core.dto.AuthUser;
import com.renote.core.model.User;
import com.renote.core.util.GroupUtils;
import com.renote.core.util.TimeUtils;
import com.renote.server.dto.UserDTO;
import com.renote.server.mapper.RoleMapper;
import com.renote.server.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author joder
 * @date 19-6-1
 **/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    public AuthUser findUser(String username) {
        User user = userMapper.getUser(username);
        if (user == null) {
            return null;
        }
        AuthUser authUser = new AuthUser();
        authUser.setUsername(user.getUsername());
        authUser.setPassword(user.getPassword());
        authUser.setCreateTime(user.getCreateTime());
        authUser.setRoles(roleMapper.getList(user.getGroupId()));
        return authUser;
    }

    public boolean register(UserDTO userDTO) {
        long time = TimeUtils.getNow();
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setCreateTime(time);
        user.setGroupId(GroupUtils.DEFAULT.getGroupId());
        return userMapper.save(user) > 0;
    }
}
