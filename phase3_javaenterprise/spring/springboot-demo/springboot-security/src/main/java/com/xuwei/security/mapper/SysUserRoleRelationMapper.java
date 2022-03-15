package com.xuwei.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuwei.security.domain.SysUserRoleRelation;
import org.apache.ibatis.annotations.Mapper;

/**
* @author yxw
* @description 针对表【sys_user_role_relation(用户角色关联关系表)】的数据库操作Mapper
* @createDate 2022-03-07 09:39:31
* @Entity com.xuwei.security.domain.SysUserRoleRelation
*/
@Mapper
public interface SysUserRoleRelationMapper extends BaseMapper<SysUserRoleRelation> {


}
