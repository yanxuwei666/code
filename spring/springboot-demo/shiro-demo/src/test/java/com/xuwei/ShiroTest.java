package com.xuwei;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @Description TODO
 * @Date 2022/3/3 9:21
 * @Author yxw
 */
public class ShiroTest {

    @Test
    public void testShiroIni() {
        // 创建安全管理器，获取用户权限数据
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(new IniRealm("classpath:shiro.ini"));
        // 在安装工具类中设置默认安全管理器
        SecurityUtils.setSecurityManager(securityManager);
        // 获取主体，可能是用户，也可能是一段程序
        Subject subject = SecurityUtils.getSubject();
        // 创建用户登录凭证，从controller传递过来的
        UsernamePasswordToken token = new UsernamePasswordToken("guest", "123456");
        // 登录校验，这里进行认证
        subject.login(token);
        // 判断用户已经认证
        System.out.println(subject.isAuthenticated()); // true

        // 判断权限
        System.out.println(subject.hasRole("admin")); // false
        System.out.println(subject.isPermitted("winnebago:drive:eagle5")); // true
    }
}
