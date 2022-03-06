package com.xuwei.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Description TODO
 * @Date 2022/3/4 16:11
 * @Author yxw
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .mvcMatchers("/login.html").permitAll()
                .mvcMatchers("/index").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/doLogin")
                .usernameParameter("uname")
                .passwordParameter("passwd")
                .successForwardUrl("/index") 		 //forward 跳转           注意:不会跳转到之前请求路径
                //.defaultSuccessUrl("/index")   //redirect 重定向    注意:如果之前请求路径,会有优先跳转之前请求路径
                .failureUrl("/login.html")
                .and()
                .csrf().disable();//这里先关闭 CSRF
    }

}
