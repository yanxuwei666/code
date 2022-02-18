package com.xuwei.springsecurityapi.config;

import com.xuwei.springsecurityapi.config.handlers.LoginFailedHandler;
import com.xuwei.springsecurityapi.config.handlers.LoginSuccessHandler;
import com.xuwei.springsecurityapi.config.handlers.SecurityAccessDeniedHandler;
import com.xuwei.springsecurityapi.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @Description SecurityConfig配置类
 * @Date 2022/2/16 15:56
 * @Author yxw
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;
    @Autowired
    private LoginFailedHandler loginFailedHandler;
    @Autowired
    private SecurityAccessDeniedHandler accessDeniedHandler;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private PersistentTokenRepository persistentTokenRepository;

    @Bean
    public PasswordEncoder getPw(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 自定义登录表单页面
        http.formLogin()
                //登录页面
                .loginPage("/login.html")
                // 后端处理登录的方法
                .loginProcessingUrl("/login")
                .usernameParameter("userName")
                .passwordParameter("userPwd")
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailedHandler);

        // 页面访问权限
        http.authorizeRequests()
                // 登录页面执行放行
                .antMatchers("/login.html").access("permitAll")
                .antMatchers("/error.html").access("permitAll")
                // 其他资源均需登录才可访问
                .anyRequest().authenticated();
                //.anyRequest().access("@myServiceImpl.hasPermission(request, authentication)");


        // 自定义403页面处理
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);

        // 记住我免登录配置实现
        http.rememberMe()
                // 失效时间，单位秒
                .tokenValiditySeconds(15)
                //登录逻辑交给哪个对象
                .userDetailsService(userService)
                // 持久层对象
                .tokenRepository(persistentTokenRepository);

        //退出登录
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login.html"); //退出成功后跳转的页面

        // 关闭csrf
        http.csrf().disable();
    }

    @Bean
    public PersistentTokenRepository getPersistentTokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        // 自动建表，第一次启动时需要，第二次启动时注释掉
        //jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }
}
