package com.xuwei.sba;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description TODO
 * @Date 2022/3/10 11:27
 * @Author yxw
 */
@EnableAdminServer // 添加此行代码
@SpringBootApplication
public class SBAApplication {
    public static void main(String[] args) {
        SpringApplication.run(SBAApplication.class, args);
    }
}
