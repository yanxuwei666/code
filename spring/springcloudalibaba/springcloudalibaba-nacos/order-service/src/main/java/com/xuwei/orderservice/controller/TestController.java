package com.xuwei.orderservice.controller;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.listener.AbstractListener;
import com.xuwei.orderservice.config.RedisConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

/**
 * @Description TODO
 * @Date 2022/2/22 13:40
 * @Author yxw
 */
@RefreshScope
@RestController
@EnableConfigurationProperties(RedisConfig.class)
public class TestController {
    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private String redisPort;

    @Autowired
    private RedisConfig redisConfig;

    @Autowired
    private NacosConfigManager nacosConfigManager;

    @GetMapping("/test")
    public String test() {
        System.out.println("redisHost：" + redisHost +  ", redisPort：" + redisPort);
        return "test";
    }

    @PostConstruct
    public void init() {
        System.out.printf("[init] redis host : %s , port : %s%n", redisHost, redisPort);
    }

    @PreDestroy
    public void destroy() {
        System.out.printf("[destroy] redis host : %s , port : %s%n", redisHost, redisPort);
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            String dataId = "order-service-dev.yml";
            String group = "DEFAULT_GROUP";
            // 通过NacosConfigManager Bean获取ConfigService
            nacosConfigManager.getConfigService().addListener(dataId, group, new AbstractListener() {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    System.out.println("[Listener] " + configInfo);
                    System.out.println("[Before User] " + redisConfig);

                    // 将String内容转化为Properties对象，并将Properties属性值设置到对应的bean属性
                    Properties properties = new Properties();
                    try {
                        properties.load(new StringReader(configInfo));
                        String redisHost = properties.getProperty("spring.redis.host");
                        String redisPort = properties.getProperty("spring.redis.port");
                        int age = Integer.valueOf(properties.getProperty("user.age"));
                        redisConfig.setHost(redisHost);
                        redisConfig.setPort(redisPort);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("[After User] " + redisConfig);
                }
            });
        };
    }
}
