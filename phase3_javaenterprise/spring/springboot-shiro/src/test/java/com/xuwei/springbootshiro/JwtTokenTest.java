package com.xuwei.springbootshiro;

import com.xuwei.springbootshiro.security.JwtToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.junit.jupiter.api.Test;

/**
 * @Description TODO
 * @Date 2022/2/28 11:06
 * @Author yxw
 */
public class JwtTokenTest {

    @Test
    public void testJwtToken() {
        System.out.println(new JwtToken("yxw", "123")); // com.xuwei.springbootshiro.security.JwtToken@2f465398
        System.out.println(new UsernamePasswordToken("yxw", "123")); // org.apache.shiro.authc.UsernamePasswordToken - yxw, rememberMe=false
    }
}
