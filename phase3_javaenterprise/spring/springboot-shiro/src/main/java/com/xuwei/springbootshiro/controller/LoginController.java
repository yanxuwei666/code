package com.xuwei.springbootshiro.controller;

import com.xuwei.springbootshiro.common.domain.AjaxResult;
import com.xuwei.springbootshiro.entity.User;
import com.xuwei.springbootshiro.security.JwtTokenUtil;
import com.xuwei.springbootshiro.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
public class LoginController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public AjaxResult<?> login(String username, String password, HttpServletResponse response) {
		// 查询用户
		username = StringUtils.lowerCase(username);
		User user = userService.getUser(username);
		if (!Objects.nonNull(user)) {
			return AjaxResult.fail("无此用户");
		}
		// 验证密码
		SimpleHash hash = new SimpleHash("sha-1", password, user.getSalt());
		if (!StringUtils.equalsIgnoreCase(user.getPassword(), hash.toHex())) {
			return AjaxResult.fail("密码错误");
		}
		// 创建token（TODO: 是否需要将用户权限信息放入token中）
		String token = JwtTokenUtil.sign(username, JwtTokenUtil.TOKEN_SECRET);

		// 将签发的 token 设置到 HttpServletResponse 的 Header 中
		response.setHeader(JwtTokenUtil.AUTH_HEADER, token);

		return AjaxResult.ok(null, "登录成功!");
	}
}
