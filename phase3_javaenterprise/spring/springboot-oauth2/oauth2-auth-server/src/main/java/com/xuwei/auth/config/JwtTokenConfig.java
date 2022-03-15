package com.xuwei.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @Description JWT token存储配置类
 * @Date 2022/3/9 11:08
 * @Author yxw
 */
@Configuration
public class JwtTokenConfig {

    private static final String SIGNING_KEY = "dev";

    @Bean
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    /**
     * 配置jwt令牌服务，生成jwt格式的令牌
     * @return
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SIGNING_KEY); // 对称秘钥，资源服务器使用该秘钥来验证
        return converter;
    }

    /**
     * token增强器
     * @return
     */
    @Bean
    public TokenEnhancer jwtTokenEnhancer(){
        return new JWTokenEnhancer();
    }
}
