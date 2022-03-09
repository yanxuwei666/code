package com.xuwei.security.config.handler;

import com.alibaba.fastjson.JSON;
import com.xuwei.security.common.JsonResult;
import com.xuwei.security.common.ResultCode;
import com.xuwei.security.common.ResultTool;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 匿名用户访问无权限资源时的异常
 * @Date 2022/3/7 10:08
 * @Author yxw
 */
public class CustomizeAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        JsonResult result = ResultTool.fail(ResultCode.USER_NOT_LOGIN);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(result));
    }
}
