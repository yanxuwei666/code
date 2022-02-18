package com.xuwei.admin.Interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.util.UUID;

/**
 * @Description
 * @Date 2022/1/27 10:41
 * @Author yxw
 */
public class FeignAuthRequestInterceptor  implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        // 业务逻辑
        String access_token = UUID.randomUUID().toString();
        requestTemplate.header("Authorization", access_token);
    }
}
