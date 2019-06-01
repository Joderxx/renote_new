package com.renote.server.auth;

import com.renote.core.dto.AuthUser;
import com.renote.core.model.Role;
import com.renote.core.model.User;
import com.renote.server.service.user.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @author joder
 * @date 19-6-1
 **/
public class ShiroAuth extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Subject subject = SecurityUtils.getSubject();
        AuthUser user = (AuthUser)subject.getPrincipal();
        if(user != null){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            Collection<String> roleCollection = new HashSet<>();
            Collection<String> premissionCollection = new HashSet<>();
            // 读取并赋值用户角色与权限
            List<Role> roles = user.getRoles();
            for(Role role : roles){
                premissionCollection.add(role.getUrl());
                roleCollection.add(role.getName());
            }
            info.addStringPermissions(premissionCollection);
            info.addRoles(roleCollection);
            return info;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        AuthUser bean = userService.findUser(token.getUsername());
        if(bean == null){
            throw new UnknownAccountException();
        }
        ByteSource credentialsSalt = ByteSource.Util.bytes(bean.getUsername()+bean.getCreateTime());
        return new SimpleAuthenticationInfo(bean, bean.getPassword(),
                credentialsSalt, getName());

    }
}
