package com.xuwei.shiro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Date 2022/2/28 16:27
 * @Author yxw
 */
@RestController
public class IndexController {

    @GetMapping
    public String index() {
        return "index";
    }
}
