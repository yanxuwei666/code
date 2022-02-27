package com.xuwei.openfeignconsumer8083;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OpenFeignConsumer8083Application {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignConsumer8083Application.class, args);
    }

}
