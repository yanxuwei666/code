package com.xuwei.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * @Description TODO
 * @Date 2022/2/25 14:06
 * @Author yxw
 */
public class TestAuthenticator {
    public static void main(String[] args) {
        // 创建securityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();

        //defaultSecurityManager.setRealm(new IniRealm("classpath:shiro.ini"));
        CustomerRealm customerRealm = new CustomerRealm();

        // 使用md5 + salt认证，使用自定义realm获取认证数据
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(1024);//设置散列次数
        customerRealm.setCredentialsMatcher(credentialsMatcher);
        defaultSecurityManager.setRealm(customerRealm);

        // 设置默认安全管理器
        SecurityUtils.setSecurityManager(defaultSecurityManager);

        // 获取主体对象
        Subject subject = SecurityUtils.getSubject();

        // 创建token令牌
        UsernamePasswordToken token = new UsernamePasswordToken("xiaochen", "123");
        System.out.println("token令牌：" + token);
        try {
            subject.login(token);
            System.out.println("登录成功~~");
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误!!");
        } catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("密码错误!!!");
        }

        // 认证通过
        if (subject.isAuthenticated()) {
            // 基于角色权限管理
            boolean admin = subject.hasRole("admin"); // true
            System.out.println(admin);

            boolean permitted = subject.isPermitted("product:create:001"); // true
            System.out.println(permitted);
        }
    }
}
