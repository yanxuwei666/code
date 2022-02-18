package com.xuwei.nacos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @Description TODO
 * @Date 2022/2/18 13:34
 * @Author yxw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@RefreshScope
@ConfigurationProperties(prefix = "user")
public class User implements InitializingBean, DisposableBean {
    private String name;
    private int age;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("[afterPropertiesSet()] " + toString());
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("[destroy()] " + toString());
    }
}
