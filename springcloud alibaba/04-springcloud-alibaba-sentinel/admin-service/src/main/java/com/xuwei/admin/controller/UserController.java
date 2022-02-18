package com.xuwei.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description TODO
 * @Date 2022/1/27 16:20
 * @Author yxw
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/findOrderByUserId")
    public String  findOrderByUserId() {
        String result = restTemplate.getForObject("http://localhost:9002/order/getOrderById/", String.class);
        return result;
    }

    @RequestMapping("/addOrder")
    public String add() {
        System.out.println("add order success");
        String msg = restTemplate.getForObject("http://localhost:9002/order/addOrder", String.class);
        return "add order "+msg;
    }
}
