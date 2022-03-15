package com.xuwei.openfeignprovider8082;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class OpenfeignProvider8082Application {

    public static void main(String[] args) {
        SpringApplication.run(OpenfeignProvider8082Application.class, args);
    }

}
