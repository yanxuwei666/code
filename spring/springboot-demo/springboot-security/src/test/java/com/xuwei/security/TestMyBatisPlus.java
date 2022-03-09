package com.xuwei.security;

import com.xuwei.security.domain.SysUser;
import com.xuwei.security.service.impl.SysUserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description TODO
 * @Date 2022/3/7 9:47
 * @Author yxw
 */
@SpringBootTest
public class TestMyBatisPlus {

    @Autowired
    private SysUserServiceImpl sysUserService;

    @Test
    public void testSysUserMapper() {
        SysUser sysUser = sysUserService.selectByName("user1");
        System.out.println(sysUser);
    }
}
