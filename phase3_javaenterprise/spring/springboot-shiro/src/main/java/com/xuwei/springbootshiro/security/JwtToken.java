package com.xuwei.springbootshiro.security;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Description 自定义返回token类
 * @Date 2022/2/28 11:02
 * @Author yxw
 */
public class JwtToken implements AuthenticationToken {

    private static final long serialVersionUID = 8332394212585154814L;

    private String username;
    private String jwtToken;

    public JwtToken(String username, String jwtToken) {
        this.username = username;
        this.jwtToken = jwtToken;
    }

    @Override
    public Object getPrincipal() {
        return username;
    }

    @Override
    public Object getCredentials() {
        return jwtToken;
    }
}
