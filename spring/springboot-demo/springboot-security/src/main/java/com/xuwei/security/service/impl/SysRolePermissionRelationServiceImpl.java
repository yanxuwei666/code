package com.xuwei.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuwei.security.domain.SysRolePermissionRelation;
import com.xuwei.security.mapper.SysRolePermissionRelationMapper;
import com.xuwei.security.service.SysRolePermissionRelationService;
import org.springframework.stereotype.Service;

/**
* @author yxw
* @description 针对表【sys_role_permission_relation(角色-权限关联关系表)】的数据库操作Service实现
* @createDate 2022-03-07 09:39:31
*/
@Service
public class SysRolePermissionRelationServiceImpl extends ServiceImpl<SysRolePermissionRelationMapper, SysRolePermissionRelation>
implements SysRolePermissionRelationService{

}
