package com.xuwei.shiro.config.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.Objects;

/**
 * @Description 自定义Realm，大部分情况需要从数据库中读取用户信息
 * @Date 2022/2/25 14:13
 * @Author yxw
 */
public class CustomerRealm extends AuthorizingRealm {
    // 用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal();
        if (Objects.equals(principal, "xiaochen")) {
            String password = "3c88b338102c1a343bcb88cd3878758e";
            String salt = "Q4F%";
            return new SimpleAuthenticationInfo(principal, password,
                    ByteSource.Util.bytes(salt),this.getName());
        }
        return null;
    }

    // 授权模块
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        System.out.println("primaryPrincipal = " + primaryPrincipal);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole("admin");
        simpleAuthorizationInfo.addStringPermission("user:update:*");
        simpleAuthorizationInfo.addStringPermission("product:*:*");
        return simpleAuthorizationInfo;
    }
}
