package com.xuwei.provider.service;

import com.xuwei.common.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @Description TODO
 * @Date 2022/2/23 13:59
 * @Author yxw
 */
@DubboService
public class UserServiceImpl implements UserService {
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
