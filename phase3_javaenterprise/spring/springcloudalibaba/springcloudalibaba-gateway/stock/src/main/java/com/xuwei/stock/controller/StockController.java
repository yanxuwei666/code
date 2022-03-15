package com.xuwei.stock.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Date 2022/2/21 11:22
 * @Author yxw
 */
@Slf4j
@RestController
@RequestMapping("/stock")
public class StockController {

    @RequestMapping("/reduce")
    public String reduce(ServerHttpRequest request){
        System.out.println("扣减库存");
        log.info("gateWay获取请求头access-token："
                +request.getHeaders().get("access-token"));
        return "reduce success";
    }

    @GetMapping("/testgateway")
    public String testGateway(ServerHttpRequest request) throws Exception {
        log.info("gateWay获取请求头access-token："
                +request.getHeaders().get("access-token"));
        return "success";
    }
    @GetMapping("/testgateway2")
    public String testGateway(@RequestHeader("access-token") String token) throws Exception {
        log.info("gateWay获取请求头access-token："+token);
        return "success";
    }

    @GetMapping("/testgateway3")
    public String testGateway3(@RequestParam("color") String color) throws Exception {
        log.info("gateWay获取请求参数color:"+color);
        return "success";
    }
}
