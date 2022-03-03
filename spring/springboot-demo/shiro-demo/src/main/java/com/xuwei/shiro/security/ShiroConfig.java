package com.xuwei.shiro.security;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Date 2022/3/3 10:03
 * @Author yxw
 */
@Configuration
public class ShiroConfig {

    /**
     * 定义Realm
     * @return
     */
    @Bean
    public Realm realm() {
        // 创建 SimpleAccountRealm 对象(使用内存作为数据源)
        SimpleAccountRealm realm = new SimpleAccountRealm();
        // 添加两个用户，参数是username、password、roles
        realm.addAccount("admin", "123456", "ADMIN");
        realm.addAccount("normal", "123456", "NORMAL");
        return realm;
    }

    /**
     * 定义SecurityManager
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置其使用的Realm
        securityManager.setRealm(this.realm());
        return securityManager;
    }

    /**
     * 定义ShiroFilter，实现对请求拦截
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        // 1、创建ShiroFilterFactoryBean对象，用于创建ShiroFilter过滤器
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        // 2、设置SecurityManager
        filterFactoryBean.setSecurityManager(this.securityManager());
        // 3、设置URL
        filterFactoryBean.setLoginUrl("/login"); // 登录URL
        filterFactoryBean.setSuccessUrl("/login_success"); // 登录成功URL
        filterFactoryBean.setUnauthorizedUrl("/unauthorized"); // 无权限URL
        // 4、设置URL的权限配置
        filterFactoryBean.setFilterChainDefinitionMap(this.filterChainDefinitionMap());
        return filterFactoryBean;
    }

    /**
     * 设置URL权限配置
     * @return
     */
    private Map<String, String> filterChainDefinitionMap() {
        Map<String, String> filterMap = new LinkedHashMap<>(); // 这里要使用有序的LinkedHashMap
        filterMap.put("/test/echo", "anon"); // 允许匿名访问
        filterMap.put("/test/admin", "roles[ADMIN]"); // 需要ADMIN角色
        filterMap.put("/test/normal", "roles[NORMAL]"); // 需要NORMAL角色
        filterMap.put("/logout", "logout"); // 退出
        filterMap.put("/**", "authc"); // 默认剩余的URL，需要经过认证
        return filterMap;
    }
}
