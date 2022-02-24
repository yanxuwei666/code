package com.xuwei.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description TODO
 * @Date 2022/2/22 14:49
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
        //String msg = restTemplate.getForObject("http://localhost:8082/stock/reduce", String.class);
        String msg = restTemplate.getForObject("http://stock-service/stock/reduce", String.class);
        return "add success "+msg;
    }
}
