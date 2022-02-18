package com.xuwei.admin.feign;

import com.xuwei.admin.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description TODO
 * @Date 2022/1/27 10:20
 * @Author yxw
 */
@FeignClient(name = "stock-service", path = "/stock", configuration = FeignConfig.class)
public interface StockFeignService {
    /**
     * 声明需要调用的rest解开了对应的方法
     * @return
     */
    @RequestMapping("reduce")
    public String reduce();
}
