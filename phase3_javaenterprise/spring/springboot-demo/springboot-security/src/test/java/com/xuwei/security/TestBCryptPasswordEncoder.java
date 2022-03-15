package com.xuwei.security;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Description TODO
 * @Date 2022/3/7 9:53
 * @Author yxw
 */
@SpringBootTest
public class TestBCryptPasswordEncoder {
    @Test
    public void testBCryptPasswordEncoder() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("123456");
        String encode2 = passwordEncoder.encode("123456");
        System.out.println("加密后：" + encode); // $2a$10$BfBCpnCEVy9W6ikMdLKX/.oS.417PkBybzKivy4/a24vBlN5nljDq
        System.out.println("加密后：" + encode2); // $2a$10$2gDzrxgVjsSAYymuaxTxceoD9XOa4n7LgniCNTRqJYjRS7YRoFbUG
        System.out.println("密码匹配结果：" + passwordEncoder.matches("123456", encode)); // true
        System.out.println("密码匹配结果：" + passwordEncoder.matches("123456", "encode2")); // true
    }
}
