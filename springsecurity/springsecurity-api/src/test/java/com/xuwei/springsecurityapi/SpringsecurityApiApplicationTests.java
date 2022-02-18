package com.xuwei.springsecurityapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class SpringsecurityApiApplicationTests {

    @Test
    void contextLoads() {
        PasswordEncoder pe = new BCryptPasswordEncoder();
        String encode = pe.encode("123"); // $2a$10$/CdaNpsfCg8rizhvcpcYfOv4QkU4otSb4Ipjbu1z1dNJlE0kfIQrW
        boolean result = pe.matches("123", encode); // true
        System.out.println("加密后：" + encode);
    }

}
