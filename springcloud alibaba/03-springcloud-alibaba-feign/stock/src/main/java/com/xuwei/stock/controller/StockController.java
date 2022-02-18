package com.xuwei.stock.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Date 2022/1/26 11:07
 * @Author yxw
 */
@RestController
@RequestMapping("/stock")
public class StockController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/reduce")
    public String reduce(){
        System.out.println("扣减库存");
        return "reduce success" + port;
    }
}
