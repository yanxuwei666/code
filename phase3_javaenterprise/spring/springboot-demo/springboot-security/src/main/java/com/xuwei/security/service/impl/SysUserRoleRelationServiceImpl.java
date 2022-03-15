package com.xuwei.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuwei.security.domain.SysUserRoleRelation;
import com.xuwei.security.mapper.SysUserRoleRelationMapper;
import com.xuwei.security.service.SysUserRoleRelationService;
import org.springframework.stereotype.Service;

/**
* @author yxw
* @description 针对表【sys_user_role_relation(用户角色关联关系表)】的数据库操作Service实现
* @createDate 2022-03-07 09:39:31
*/
@Service
public class SysUserRoleRelationServiceImpl extends ServiceImpl<SysUserRoleRelationMapper, SysUserRoleRelation>
implements SysUserRoleRelationService{

}
