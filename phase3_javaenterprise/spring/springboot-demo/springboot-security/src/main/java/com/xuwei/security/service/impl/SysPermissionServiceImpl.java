package com.xuwei.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuwei.security.domain.SysPermission;
import com.xuwei.security.mapper.SysPermissionMapper;
import com.xuwei.security.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author yxw
* @description 针对表【sys_permission(权限表)】的数据库操作Service实现
* @createDate 2022-03-07 09:39:31
*/
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission>
implements SysPermissionService{

    @Autowired
    private SysPermissionMapper permissionMapper;

    @Override
    public List<SysPermission> selectListByUser(Integer userId) {
        return permissionMapper.selectListByUser(userId);
    }

    @Override
    public List<SysPermission> selectListByPath(String path) {
        return permissionMapper.selectListByPath(path);
    }
}
