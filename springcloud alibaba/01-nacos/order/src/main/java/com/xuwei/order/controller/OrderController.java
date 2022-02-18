package com.xuwei.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description TODO
 * @Date 2022/2/18 13:57
 * @Author yxw
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/add")
    public String add() {
        System.out.println("add success");
        String msg = restTemplate.getForObject("http://localhost:8082/stock/reduce", String.class);
        return "add success "+msg;
    }
}
