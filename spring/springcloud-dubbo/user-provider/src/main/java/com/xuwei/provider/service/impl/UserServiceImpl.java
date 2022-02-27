package com.xuwei.provider.service.impl;

import com.xuwei.common.domain.User;
import com.xuwei.common.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;


/**
 * @Description TODO
 * @Date 2022/2/23 13:59
 * @Author yxw
 */
@DubboService(version = "1.0.1")
public class UserServiceImpl implements UserService {
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }

    @Override
    public User getUserInfo(Integer id) {
        return new User(id, "威少");
    }
}
