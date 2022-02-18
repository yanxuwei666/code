package com.xuwei.springsecurityapi.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description TODO
 * @Date 2022/2/16 15:56
 * @Author yxw
 */
@Controller
public class MainController {

    @RequestMapping("toMain")
    public String main(){
        return "redirect:main.html";
    }


    @RequestMapping("toLogin")
    public String login(){
        return "redirect:login.html";
    }


    @RequestMapping("toMain1")
    public String main1(){
        return "redirect:main.html";
    }

    @RequestMapping("toMain2")
    public String main2(){
        return "redirect:main.html";
    }

}
