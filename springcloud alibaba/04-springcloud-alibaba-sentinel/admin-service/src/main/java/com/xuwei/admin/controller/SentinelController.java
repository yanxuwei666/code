package com.xuwei.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Date 2022/1/27 15:42
 * @Author yxw
 */
@RestController
public class SentinelController {

    @GetMapping
    public String index() {
        return "首页";
    }
}
