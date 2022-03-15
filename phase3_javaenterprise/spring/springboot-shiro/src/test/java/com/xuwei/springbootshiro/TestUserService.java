package com.xuwei.springbootshiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xuwei.springbootshiro.entity.User;
import com.xuwei.springbootshiro.mapper.UserDao;
import com.xuwei.springbootshiro.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description TODO
 * @Date 2022/2/28 13:16
 * @Author yxw
 */
@SpringBootTest
public class TestUserService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Test
    public void testGetUser() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", "yxw");
        System.out.println(userDao.selectOne(wrapper));
    }
}
