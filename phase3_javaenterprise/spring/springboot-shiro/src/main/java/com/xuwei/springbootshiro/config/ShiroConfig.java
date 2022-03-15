package com.xuwei.springbootshiro.config;

import com.xuwei.springbootshiro.security.JwtCredentialsMatcher;
import com.xuwei.springbootshiro.security.JwtTokenFilter;
import com.xuwei.springbootshiro.security.JwtTokenRealm;
import com.xuwei.springbootshiro.security.StatelessSubjectFactory;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description Shiro配置类
 * @Date 2022/2/28 11:08
 * @Author yxw
 */
@Configuration
public class ShiroConfig {

    /**
     * 自定义Realm，完成认证和授权
     * @return
     */
    @Bean
    public Realm realm() {
        JwtTokenRealm realm = new JwtTokenRealm();
        CredentialsMatcher credentialsMatcher = new JwtCredentialsMatcher();
        realm.setCredentialsMatcher(credentialsMatcher);
        realm.setCachingEnabled(false);
        return  realm;
    }

    /**
     * 关闭session校验轮询
     * @return
     */
    @Bean
    public DefaultSessionManager sessionManager() {
        DefaultWebSessionManager shiroSessionManager = new DefaultWebSessionManager();
        // 关闭session校验轮询
        shiroSessionManager.setSessionValidationSchedulerEnabled(false);
        return shiroSessionManager;
    }

    @Bean
    public DefaultWebSubjectFactory subjectFactory() {
        return new StatelessSubjectFactory();
    }

    /**
     * 自定义秘钥管理器
     * @return
     */
    @Bean
    public DefaultSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        // 禁用session
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator sessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        sessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(sessionStorageEvaluator);
        securityManager.setSubjectDAO(subjectDAO);

        // 设置自定义Realm，完成认证和授权
        securityManager.setRealm(realm());
        // 设置自定义SubjectFactory,不创建session
        securityManager.setSubjectFactory(subjectFactory());
        // 设置自定义SessionManager
        securityManager.setSessionManager(sessionManager());
        // 禁用RememberMe
        securityManager.setRememberMeManager(null);

        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());

        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/authorized");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

        // 设置自定义过滤器
        Map<String, Filter> filters = new HashMap<>(1);
        filters.put("jwtFilter", new JwtTokenFilter());
        shiroFilterFactoryBean.setFilters(filters);

        // 拦截器配置
        LinkedHashMap<String, String> filterChainDefinitions = new LinkedHashMap<>();
        filterChainDefinitions.put("/login", "anon");
        filterChainDefinitions.put("/logout", "logout");

        filterChainDefinitions.put("/error", "anon");
        filterChainDefinitions.put("/druid/**","anon");
        filterChainDefinitions.put("/img/**", "anon");
        filterChainDefinitions.put("/static/**", "anon");
        filterChainDefinitions.put("/**", "jwtFilter");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitions);

        return shiroFilterFactoryBean;
    }

    /**
     * 启用自动代理（类代理）
     */
    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxy = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxy.setProxyTargetClass(true);
        return defaultAdvisorAutoProxy;
    }

    /**
     * 支持Shiro权限注解
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager());
        return advisor;
    }
}
