package com.xuwei.springbootshiro.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description 从数据库中获取用户角色及权限
 * @Date 2022/2/28 11:13
 * @Author yxw
 */
@Service
public class AuthService {

    /**
     * 查询用户权限
     * @param username
     * @return
     */
    public Set<String> listPermissions(String username) {
        Set<String> permissionSet = new HashSet<>();
        permissionSet.add("other:view");
        return permissionSet;
    }

    /**
     * 查询用户角色
     * @param username
     * @return
     */
    public Set<String> listRoles(String username) {
        Set<String> roleSet = new HashSet<>();
        roleSet.add("admin");
        return roleSet;
    }
}
