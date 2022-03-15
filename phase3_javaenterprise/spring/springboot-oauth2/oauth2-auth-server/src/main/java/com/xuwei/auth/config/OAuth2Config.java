package com.xuwei.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.JdbcClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Date 2022/3/9 10:51
 * @Author yxw
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Autowired
    public UserDetailsService kiteUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    //@Autowired
    //private TokenStore redisTokenStore;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private TokenStore jwtTokenStore;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    /**
     * 注入token增强器
     */
    @Autowired
    private TokenEnhancer jwtTokenEnhancer;

    /**
     * 配置令牌访问端点
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        /**
         * redis token 方式
         */
        //endpoints.authenticationManager(authenticationManager)
        //        .tokenStore(redisTokenStore)
        //        .userDetailsService(kiteUserDetailsService);

        /**
         * 普通jwt模式
         */
        //endpoints.tokenStore(jwtTokenStore)
        //        .accessTokenConverter(jwtAccessTokenConverter)
        //        .userDetailsService(kiteUserDetailsService)
        //        // 设置authenticationManager支持password模式
        //        .authenticationManager(authenticationManager);

        /**
         * 增强jwt模式
         */
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> enhancerList = new ArrayList<>();
        enhancerList.add(jwtTokenEnhancer);
        enhancerList.add(jwtAccessTokenConverter);
        enhancerChain.setTokenEnhancers(enhancerList);

        endpoints.tokenStore(jwtTokenStore)
                .userDetailsService(kiteUserDetailsService)
                .authenticationManager(authenticationManager) // 这一步支持password模式
                .tokenEnhancer(enhancerChain)
                .accessTokenConverter(jwtAccessTokenConverter);
    }

    /**
     * 配置客户端详细信息
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource);

        //clients.inMemory()
        //        .withClient("order-client")
        //        .secret(passwordEncoder.encode("order-secret-8888"))
        //        .authorizedGrantTypes("refresh_token", "authorization_code", "password")
        //        .scopes("all")
        //        .and()
        //        .withClient("user-client")
        //        .secret(passwordEncoder.encode("user-secret-8888"))
        //        .authorizedGrantTypes("refresh_token", "authorization_code", "password")
        //        .scopes("all");
    }

    /**
     * 令牌端点的安全约束
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients();
        security.checkTokenAccess("isAuthenticated()");
        security.tokenKeyAccess("isAuthenticated()");
    }
}
