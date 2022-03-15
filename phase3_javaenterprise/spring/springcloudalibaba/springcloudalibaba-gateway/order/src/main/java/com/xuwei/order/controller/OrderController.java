package com.xuwei.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description TODO
 * @Date 2022/2/21 11:27
 * @Author yxw
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/add")
    public String add() {
        return "add success ";
    }
}
