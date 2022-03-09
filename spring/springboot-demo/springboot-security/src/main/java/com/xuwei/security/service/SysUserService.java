package com.xuwei.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuwei.security.domain.SysUser;

/**
* @author yxw
* @description 针对表【sys_user(用户表)】的数据库操作Service
* @createDate 2022-03-07 09:39:31
*/
public interface SysUserService extends IService<SysUser> {
    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return
     */
    SysUser selectByName(String userName);


}
