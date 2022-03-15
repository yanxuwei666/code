package com.xuwei.springbootshiro.security;

import com.xuwei.springbootshiro.service.AuthService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @Description 自定义Realm
 * @Date 2022/2/28 11:09
 * @Author yxw
 */
public class JwtTokenRealm extends AuthorizingRealm {

    @Autowired
    AuthService authService;

    /**
     * 用户认证
     * @param token 这里的token是从JwtTokenFilter的 executeLogin()方法传递过来的
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String jwtToken = (String) token.getCredentials();

        // 构建 AuthenticationInfo 对象并返回
        return new SimpleAuthenticationInfo(username, jwtToken, this.getName());
    }

    /**
     * 授权模块，获取用户角色和权限（TODO: 此处需要结合token创建时考虑，权限放入token中，还是从数据库获取）
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        // 查询用户权限
        Set<String> permissionSet = authService.listPermissions(username);
        simpleAuthorizationInfo.setStringPermissions(permissionSet);

        // 查询用户角色
        Set<String> roleSet = authService.listRoles(username);
        simpleAuthorizationInfo.setRoles(roleSet);

        System.out.println("-----权限获取------");
        return simpleAuthorizationInfo;
    }
}
