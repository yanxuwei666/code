package com.xuwei.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Date 2022/3/4 16:04
 * @Author yxw
 */
@RestController
public class TestController {

    @GetMapping("test")
    public String test() {
        return "test";
    }
}
