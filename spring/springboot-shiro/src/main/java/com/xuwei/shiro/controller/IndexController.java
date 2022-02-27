package com.xuwei.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description TODO
 * @Date 2022/2/25 16:02
 * @Author yxw
 */
@Controller
public class IndexController {
    @GetMapping("index")
    public String index() {
        System.out.println("跳转至主页");
        return "index";
    }
}
