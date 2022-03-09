package com.xuwei.security.service.impl;

import com.xuwei.security.domain.SysPermission;
import com.xuwei.security.domain.SysUser;
import com.xuwei.security.service.SysPermissionService;
import com.xuwei.security.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 用户登录认证逻辑
 * @Date 2022/3/7 9:15
 * @Author yxw
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysPermissionService sysPermissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //需要构造出 org.springframework.security.core.userdetails.User 对象并返回
        if (username == null || "".equals(username)) {
            throw new RuntimeException("用户名不能为空");
        }
        // 根据用户名查找用户
        SysUser sysUser = sysUserService.selectByName(username);
        if (sysUser == null) {
            throw new RuntimeException("用户不存在");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (sysUser != null) {
            //获取该用户所拥有的权限
            List<SysPermission> sysPermissions = sysPermissionService.selectListByUser(sysUser.getId());
            // 声明用户授权
            sysPermissions.forEach(sysPermission -> {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(sysPermission.getPermissionCode());
                grantedAuthorities.add(grantedAuthority);
            });
        }
        return new User(sysUser.getAccount(),
                        sysUser.getPassword(),
                        sysUser.getEnabled(),
                        sysUser.getAccountNonExpired(),
                        sysUser.getCredentialsNonExpired(),
                        sysUser.getAccountNonLocked(),
                        grantedAuthorities);
    }
}
