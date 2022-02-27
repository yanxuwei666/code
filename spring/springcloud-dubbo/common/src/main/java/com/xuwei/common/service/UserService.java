package com.xuwei.common.service;

import com.xuwei.common.domain.User;

/**
 * @Description 对外暴露的接口
 * @Date 2022/2/23 13:57
 * @Author yxw
 */
public interface UserService {
    String sayHello(String name);
    User getUserInfo(Integer id);
}
