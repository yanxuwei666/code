package com.xuwei.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuwei.security.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
* @author yxw
* @description 针对表【sys_user(用户表)】的数据库操作Mapper
* @createDate 2022-03-07 09:39:31
* @Entity com.xuwei.security.domain.SysUser
*/
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return
     */
    SysUser selectByName(String userName);
}
