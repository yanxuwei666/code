package com.xuwei.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuwei.security.domain.SysUser;
import com.xuwei.security.mapper.SysUserMapper;
import com.xuwei.security.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author yxw
* @description 针对表【sys_user(用户表)】的数据库操作Service实现
* @createDate 2022-03-07 09:39:31
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
implements SysUserService{
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser selectByName(String userName) {
        return sysUserMapper.selectByName(userName);
    }
}
