package com.xuwei.springbootshiro;

import com.xuwei.springbootshiro.entity.User;
import com.xuwei.springbootshiro.mapper.UserDao;
import com.xuwei.springbootshiro.util.SaltUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootShiroApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        userDao.insert(new User("4", "yxw4", "123", SaltUtils.getSalt(8)));
        new UsernamePasswordToken();
    }

}
