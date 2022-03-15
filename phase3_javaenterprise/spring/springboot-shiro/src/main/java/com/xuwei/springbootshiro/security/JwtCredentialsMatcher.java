package com.xuwei.springbootshiro.security;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

/**
 * @Description 自定义生成token
 * @Date 2022/2/28 11:18
 * @Author yxw
 */
public class JwtCredentialsMatcher implements CredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String username = token.getPrincipal().toString();
        String jwtToken = token.getCredentials().toString();
        return (JwtTokenUtil.verify(jwtToken, username, JwtTokenUtil.TOKEN_SECRET)
                && JwtTokenUtil.isExpired(jwtToken));
    }
}
