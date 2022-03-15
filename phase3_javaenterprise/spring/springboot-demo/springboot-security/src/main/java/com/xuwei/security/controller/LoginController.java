package com.xuwei.security.controller;

import com.xuwei.security.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Date 2022/3/4 16:09
 * @Author yxw
 */
@RestController
public class LoginController {

    @Autowired
    private SysUserService sysUserService;


}
