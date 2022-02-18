package com.xuwei.admin.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "stock-service", path = "/stock")
public interface OrderFeignService {

    // 根据ID查询订单
    @RequestMapping(value = "/findOrderByUserId/{id}")
    public String findOrderByUserId(@PathVariable("id") Integer id);
}
