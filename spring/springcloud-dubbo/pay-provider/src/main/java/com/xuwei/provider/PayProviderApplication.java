package com.xuwei.provider;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description TODO
 * @Date 2022/2/23 14:02
 * @Author yxw
 */
@EnableDubbo
@SpringBootApplication
public class PayProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(PayProviderApplication.class, args);
    }
}
