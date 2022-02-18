package com.xuwei.admin.config;

import com.xuwei.admin.Interceptor.FeignAuthRequestInterceptor;
import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;

/**
 * @Description TODO
 * @Date 2022/1/27 9:58
 * @Author yxw
 */
// 注意：此处配置@Configuration注解就会全局生效，如果想指定对应微服务生效，就不能配置
public class FeignConfig {

    /**
     * 日志级别
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Request.Options options() {
        return new Request.Options(5000, 10000);
    }

    /**
     * 自定义拦截器
     * @return
     */
    @Bean
    public FeignAuthRequestInterceptor feignAuthRequestInterceptor(){
        return new FeignAuthRequestInterceptor();
    }
}
