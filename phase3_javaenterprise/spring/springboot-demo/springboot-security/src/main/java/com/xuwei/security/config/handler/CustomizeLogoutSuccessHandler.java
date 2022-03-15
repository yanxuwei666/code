package com.xuwei.security.config.handler;

import com.alibaba.fastjson.JSON;
import com.xuwei.security.common.JsonResult;
import com.xuwei.security.common.ResultTool;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 登出成功处理逻辑，将登出成功时结果返回给前台，并且登出之后进行将cookie失效或删除
 * @Date 2022/3/7 10:22
 * @Author yxw
 */
public class CustomizeLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        JsonResult result = ResultTool.success();
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(result));
    }
}
