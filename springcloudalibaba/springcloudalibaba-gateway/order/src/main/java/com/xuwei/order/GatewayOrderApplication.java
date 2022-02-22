package com.xuwei.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Description TODO
 * @Date 2022/2/21 11:22
 * @Author yxw
 */
@SpringBootApplication
public class GatewayOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayOrderApplication.class, args);
    }

    //@Bean
    //@LoadBalanced
    //public RestTemplate restTemplate(RestTemplateBuilder builder){
    //    return builder.build();
    //}
}
