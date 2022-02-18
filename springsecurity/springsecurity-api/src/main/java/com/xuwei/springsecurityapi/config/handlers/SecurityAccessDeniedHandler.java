package com.xuwei.springsecurityapi.config.handlers;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description TODO
 * @Date 2022/2/17 9:39
 * @Author yxw
 */
@Component
public class SecurityAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/403.html");

        //response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        //response.setHeader("Content-Type", "application/json;charset=utf-8");
        //PrintWriter out = response.getWriter();
        //out.write("{\"status\":\"error\",\"msg\":\"权限不足，请联系管理员！\"}");
        //out.flush();
        //out.close();
    }
}
