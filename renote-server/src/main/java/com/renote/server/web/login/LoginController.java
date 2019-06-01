package com.renote.server.web.login;

import com.renote.core.dto.Message;
import com.renote.core.util.MessageUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author joder
 * @date 19-6-1
 **/
@RestController
public class LoginController {

    @PostMapping("/login")
    public Message login(String username,String password){
        // 1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        // 2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 3.执行登录方法
        try{
            subject.login(token);
            return MessageUtils.buildSuccess("登录成功",null);
        } catch (UnknownAccountException e){
            return MessageUtils.build(-1,"账号不存在",null);
        } catch (IncorrectCredentialsException e){
            return MessageUtils.build(-1,"密码不正确",null);
        }
    }

    @GetMapping("/logout")
    public Message logout(){
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return MessageUtils.buildSuccess("退出成功",null);
    }
}
