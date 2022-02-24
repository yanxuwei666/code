package com.xuwei.openfeignconsumer8083.controller;

import com.xuwei.openfeignconsumer8083.service.OpenFeignService;
import com.xuwei.orderservice.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;

/**
 * @Description TODO
 * @Date 2022/2/22 15:23
 * @Author yxw
 */
@RestController
@RequestMapping("/openfeign")
public class OpenFeignConsumerController {

    @Autowired
    private OpenFeignService openFeignService;

    @PostMapping("/order1")
    public Order createOrder1(Order order){
        return openFeignService.createOrder1(order);
    }

    @PostMapping("/order2")
    public Order createOrder2(@RequestBody Order order){
        return openFeignService.createOrder2(order);
    }

    @GetMapping("/test/{id}")
    public String test(@PathVariable("id")Integer id){
        return openFeignService.test1(id);
    }

    @PostMapping("/test2")
    public String test2(@RequestParam String id, @RequestParam String name) {
        return openFeignService.test2(id, name);
    }
}
