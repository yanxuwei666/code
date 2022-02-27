package com.xuwei.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@SpringBootApplication
public class OrderServiceApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    public static void main(String[] args) {
        //SpringApplication.run(OrderServiceApplication.class, args);
        ConfigurableApplicationContext applicationContext = SpringApplication.run(OrderServiceApplication.class, args);
        String redisHost = applicationContext.getEnvironment().getProperty("spring.redis.host");
        String redisPort = applicationContext.getEnvironment().getProperty("spring.redis.port");
        System.out.println("redisHost :"+redisHost+"; redisPort: "+redisPort);
    }

}
