package com.xuwei.openfeignprovider8082.controller;

import com.xuwei.orderservice.entity.Order;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;

/**
 * @Description TODO
 * @Date 2022/2/22 15:27
 * @Author yxw
 */
@RestController
@RequestMapping("/openfeign/provider")
public class OpenFeignProviderController {
    @PostMapping("/order1")
    public Order createOrder1(Order order){
        System.out.println("表单传输 order");
        return order;
    }

    @PostMapping("/order2")
    public Order createOrder2(@RequestBody Order order){
        System.out.println("请求体传输：order");
        return order;
    }

    @GetMapping("/test/{id}")
    public String test(@PathVariable("id")Integer id){
        System.out.println("请求url带参数：" + id);
        return "accept one msg id="+id;
    }

    @PostMapping("/test2")
    public String test2(String id, String name) throws InterruptedException {
        System.out.println("请求参数：" + id + name);
        return MessageFormat.format("accept on msg id={0}，name={1}",id,name);
    }
}
