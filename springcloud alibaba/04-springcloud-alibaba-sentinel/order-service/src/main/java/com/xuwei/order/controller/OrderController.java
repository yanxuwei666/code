package com.xuwei.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Date 2022/1/27 16:33
 * @Author yxw
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @RequestMapping(value = "/getOrderById")
    public String getOrderById() {
        System.out.println("调用order模块");
        return "男士内裤";
    }

    @RequestMapping("/addOrder")
    public String addOrder(){
        System.out.println("添加订单");
        return "reduce success";
    }
}
