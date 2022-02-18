package com.xuwei.springsecurityapi.config.handlers;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoginFailedHandler  implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        request.getRequestDispatcher("/toLogin").forward(request,response);

        //response.setContentType("application/json;charset=utf-8");
        //response.setCharacterEncoding("utf-8");
        //PrintWriter pw = response.getWriter();
        //Map<String,Object> map =new HashMap<>();
        //map.put("code", 500);
        //map.put("msg", exception.getMessage());
        //pw.write(JSON.toJSONString(map));
        //pw.flush();
        //pw.close();
    }
}
