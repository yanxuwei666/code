package com.xuwei.consumer.controller;

import com.xuwei.common.domain.User;
import com.xuwei.common.service.UserService;
import com.xuwei.storage.service.StorageService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

/**
 * @Description TODO
 * @Date 2022/2/23 14:06
 * @Author yxw
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @DubboReference(retries = 4, version = "1.0.1")
    private UserService userService;

    @DubboReference(group = "payStorage")
    private StorageService storageService;

    //@GetMapping("/{name}")
    //public String getData(@PathVariable String name) {
    //    String msg = userService.sayHello(name);
    //    System.out.println("调用远程服务得到的消息：" + msg);
    //    return msg;
    //}

    @GetMapping("/{id}")
    public String getUserInfo(@PathVariable Integer id) {
        User user = userService.getUserInfo(id);
        return user.toString();
    }

    @GetMapping("/storage")
    public String getStorage() {
        InputStream is = storageService.getStorageStream();
        return "使用自己定义的 storageservice 方法";
    }
}
