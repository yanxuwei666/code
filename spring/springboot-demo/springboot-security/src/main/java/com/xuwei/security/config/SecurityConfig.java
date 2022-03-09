package com.xuwei.security.config;

import com.xuwei.security.config.handler.*;
import com.xuwei.security.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * @Description TODO
 * @Date 2022/3/4 16:11
 * @Author yxw
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 用户认证
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {
        // 获取用户账号密码及权限信息
        return new UserDetailsServiceImpl();
    }

    /**
     * 密码加密，多次加密结果是不同的，通过encode加密，matches密码匹配
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 设置默认的加密方式（强hash方式加密）
        return new BCryptPasswordEncoder();
    }

    /**
     * 匿名用户访问无权限资源
     * @return
     */
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new CustomizeAuthenticationEntryPoint();
    }

    /**
     * 权限拒绝处理器，即没有权限访问返回403
     * @return
     */
    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomizeAccessDeniedHandler();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new CustomizeAuthenticationSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomizeAuthenticationFailureHandler();
    }

    // 访问决策管理器
    @Autowired
    private CustomizeAccessDecisionManager accessDecisionManager;

    // 设置安全元数据源
    @Autowired
    private CustomizeFilterInvocationSecurityMetadataSource securityMetadataSource;

    // 权限拦截器
    @Autowired
    private CustomizeAbstractSecurityInterceptor securityInterceptor;

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new CustomizeLogoutSuccessHandler();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 关闭csrf
        http.cors().and().csrf().disable();

        // 登入处理
        http.formLogin().permitAll()
            .successHandler(authenticationSuccessHandler())
            .failureHandler(authenticationFailureHandler());
        // 登出处理
        http.logout().permitAll()
            .logoutSuccessHandler(logoutSuccessHandler())
            .deleteCookies("JSESSIONID"); // 登出之后删除cookie
        // 异常处理
        http.exceptionHandling()
            .accessDeniedHandler(accessDeniedHandler()) //权限拒绝处理逻辑
            .authenticationEntryPoint(authenticationEntryPoint()); // 匿名用户访问无权限资源时的异常处理
        // 页面访问权限
        http.authorizeRequests()
                //.antMatchers("/getUser").hasAuthority("query_user"); // 权限控制，写死的
            .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                 @Override
                 public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                     o.setAccessDecisionManager(accessDecisionManager);//决策管理器
                     o.setSecurityMetadataSource(securityMetadataSource);//安全元数据源
                     return o;
                 }
             });
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilterBefore(securityInterceptor, FilterSecurityInterceptor.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 配置认证方式等
        auth.userDetailsService(userDetailsService());
    }
}
