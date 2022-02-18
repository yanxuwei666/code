package com.xuwei.admin.controller;

import com.xuwei.admin.feign.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description 订单服务
 * @Date 2022/1/26 11:06
 * @Author yxw
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StockFeignService stockFeignService;

    @RequestMapping("/add")
    public String add() {
        System.out.println("add success");
        //String msg = restTemplate.getForObject("http://localhost:8082/stock/reduce", String.class);
        //String msg = restTemplate.getForObject("http://stock-service/stock/reduce", String.class);
        String msg = stockFeignService.reduce();
        return "add success "+msg;
    }
}
