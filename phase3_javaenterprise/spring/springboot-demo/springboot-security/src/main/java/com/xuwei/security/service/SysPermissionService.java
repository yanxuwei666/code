package com.xuwei.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuwei.security.domain.SysPermission;

import java.util.List;

/**
* @author yxw
* @description 针对表【sys_permission(权限表)】的数据库操作Service
* @createDate 2022-03-07 09:39:31
*/
public interface SysPermissionService extends IService<SysPermission> {
    /**
     * 查询用户的权限列表
     *
     * @param userId
     * @return
     */
    List<SysPermission> selectListByUser(Integer userId);

    /**
     * 查询具体某个接口的权限
     *
     * @param path 接口路径
     * @return
     */
    List<SysPermission> selectListByPath(String path);

}
