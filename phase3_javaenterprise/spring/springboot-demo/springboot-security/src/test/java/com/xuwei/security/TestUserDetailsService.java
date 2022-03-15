package com.xuwei.security;

import com.xuwei.security.domain.SysPermission;
import com.xuwei.security.domain.SysUser;
import com.xuwei.security.service.SysPermissionService;
import com.xuwei.security.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Date 2022/3/7 10:54
 * @Author yxw
 */
@SpringBootTest
public class TestUserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysPermissionService sysPermissionService;

    @Test
    public void testUserDetailsService() {
        // 根据用户名查找用户
        SysUser sysUser = sysUserService.selectByName("user2");
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
        System.out.println(new User(sysUser.getAccount(),
                sysUser.getPassword(),
                sysUser.getEnabled(),
                sysUser.getAccountNonExpired(),
                sysUser.getCredentialsNonExpired(),
                sysUser.getAccountNonLocked(),
                grantedAuthorities));
    }
}
