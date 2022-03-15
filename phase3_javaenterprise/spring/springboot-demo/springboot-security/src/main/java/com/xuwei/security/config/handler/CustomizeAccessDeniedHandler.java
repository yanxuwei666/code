package com.xuwei.security.config.handler;

import com.alibaba.fastjson.JSON;
import com.xuwei.security.common.JsonResult;
import com.xuwei.security.common.ResultCode;
import com.xuwei.security.common.ResultTool;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 权限拒绝处理逻辑，一般是返回403页面
 * @Date 2022/3/7 11:25
 * @Author yxw
 */
public class CustomizeAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        JsonResult result = ResultTool.fail(ResultCode.NO_PERMISSION);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(result));
    }
}
