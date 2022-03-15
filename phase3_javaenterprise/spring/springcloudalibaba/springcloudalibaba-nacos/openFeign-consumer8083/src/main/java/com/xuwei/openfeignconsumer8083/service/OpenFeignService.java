package com.xuwei.openfeignconsumer8083.service;

import com.xuwei.orderservice.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Date 2022/2/22 15:23
 * @Author yxw
 */
@Service
@FeignClient(value = "openFeign-provider")
public interface OpenFeignService {
    /**
     * 参数默认是@RequestBody标注的，如果通过POJO表单传参的，使用@SpringQueryMap标注
     */
    @PostMapping("/openfeign/provider/order1")
    Order createOrder1(@SpringQueryMap Order order);

    /**
     * 参数默认是@RequestBody标注的，这里的@RequestBody可以不填
     * 方法名称任意
     */
    @PostMapping("/openfeign/provider/order2")
    Order createOrder2(@RequestBody Order order);

    @GetMapping("/openfeign/provider/test/{id}")
    String test1(@PathVariable("id")Integer id);

    /**
     * 必须要@RequestParam注解标注，且value属性必须填上参数名
     * 方法参数名可以任意，但是@RequestParam注解中的value属性必须和provider中的参数名相同
     */
    @PostMapping("/openfeign/provider/test2")
    String test2(@RequestParam("id") String arg1, @RequestParam("name") String arg2);
}
