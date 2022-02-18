package com.xuwei.springsecurityapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableGlobalMethodSecurity(securedEnabled = true)
@SpringBootApplication
public class SpringsecurityApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityApiApplication.class, args);
    }

}
