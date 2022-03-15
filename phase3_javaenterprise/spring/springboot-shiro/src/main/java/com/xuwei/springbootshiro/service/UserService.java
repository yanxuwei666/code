package com.xuwei.springbootshiro.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuwei.springbootshiro.entity.User;
import com.xuwei.springbootshiro.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Date 2022/2/28 11:28
 * @Author yxw
 */
@Service
public class UserService extends ServiceImpl<UserDao, User> {
    @Autowired
    private UserDao userDao;

    public User getUser(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        System.out.println(userDao.selectOne(wrapper));
        return userDao.selectOne(wrapper);
    }
}
