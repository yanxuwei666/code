package com.xuwei.springbootshiro.security;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenFilter extends AuthenticatingFilter {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
		// 获取请求 token
        String accessToken = getRequestToken((HttpServletRequest) request);
        if (StringUtils.isBlank(accessToken)) {

            // 返回错误状态信息
            Map<String, Object> result = new HashMap<>();
            result.put("code", 3);
            result.put("msg", "未登陆");
            String json = JSON.toJSONString(result);
            response(request, response, json);
            return null;
        }

    	return new JwtToken(JwtTokenUtil.getUsername(accessToken), accessToken);
	}

	/**
	 * 步骤一：所有请求全部拒绝，除了 OPTIONS 请求
	 *
	 * 1、返回 true 表示允许访问，就不会再调用 onAccessDenied()方法了
	 * 2、返回 false 表示拒绝访问，需要进一步调用 onAccessDenied()方法判断
	 * 3、跨域时会首先发送一个 option请求，因此这里我们针对 option请求直接返回 true
	 */
	@Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return ((HttpServletRequest) request).getMethod().equals(RequestMethod.OPTIONS.name());
    }

	/**
	 * 步骤二：拒绝访问的请求，会调用 onAccessDenied()方法，方法中先获取 token，再调用 executeLogin()方法
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("- 访问的URI: {}", ((HttpServletRequest) request).getRequestURI());
		}
		// 获取请求 token，如果 token 不存在，直接返回
        String token = getRequestToken((HttpServletRequest) request);
        if (StringUtils.isBlank(token)) {
            // 返回错误状态信息
            Map<String, Object> result = new HashMap<>();
            result.put("code", 3);
            result.put("msg", "未登陆");
            String json = JSON.toJSONString(result);
            response(request, response, json);
            return false;
        }

        // 提交给 JwtTokenRealm 进行登入
        return executeLogin(request, response);
	}

	/**
	 * 登陆失败时候调用
	 */
	@Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        // 处理登录失败的异常
        Throwable throwable = e.getCause() == null ? e : e.getCause();
        Map<String, Object> result = new HashMap<>();
        result.put("code", 3);
        result.put("msg", throwable.toString());
        String json = JSON.toJSONString(result);
        response(request, response, json);
        return false;
    }

	/**
	 * 从请求头中获取 accessToken
	 *
	 * @param httpRequest
	 * @return
	 */
	private String getRequestToken(HttpServletRequest httpRequest) {
        // 从 header 中获取 token
        String token = httpRequest.getHeader(JwtTokenUtil.AUTH_HEADER);
        // 如果 header 中不存在 token，则从参数中获取 token
        if (StringUtils.isBlank(token)) {
            token = httpRequest.getParameter("token");
        }
        return token;
    }

	/**
	 * 返回响应
	 *
	 * @param request
	 * @param response
	 * @param json
	 */
	private void response(ServletRequest request, ServletResponse response, String json) {
		// 增加跨域支持
		HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String myOrigin = httpServletRequest.getHeader("origin");
        httpResponse.setContentType("application/json;charset=utf-8");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        //httpResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        //httpResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        httpResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with, X-Access-Token, datasource-Key");
        httpResponse.setHeader("Access-Control-Allow-Origin", myOrigin);
        httpResponse.setCharacterEncoding("UTF-8");
        // 返回错误状态信息
        try {
        	httpResponse.getWriter().print(json);
        } catch (IOException e1) {
        }
	}
}
