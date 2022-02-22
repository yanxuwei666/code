package com.xuwei.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Date 2022/2/18 16:10
 * @Author yxw
 */
@RestController
public class IndexController {

    @GetMapping("/test")
    public String test() {
        return "hello world";
    }
}
