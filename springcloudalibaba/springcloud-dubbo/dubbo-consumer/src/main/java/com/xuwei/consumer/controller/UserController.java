package com.xuwei.consumer.controller;

import com.xuwei.common.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Date 2022/2/23 14:06
 * @Author yxw
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @DubboReference
    private UserService userService;

    @GetMapping("{name}")
    public String getData(@PathVariable String name) {
        String msg = userService.sayHello(name);
        System.out.println("调用远程服务得到的消息：" + msg);
        return msg;
    }
}
