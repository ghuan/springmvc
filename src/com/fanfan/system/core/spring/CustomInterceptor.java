package com.fanfan.system.core.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fanfan.system.core.exception.BusinessException;
import com.fanfan.system.core.web.RequestResponseContext;

/**
 * 
* Copy right huan.gao 下午1:31:14
* All right reserved
* QQ:2223486623 
* description：自定义拦截器,每次请求将request，response存入ThreadLocal
 */
public class CustomInterceptor extends HandlerInterceptorAdapter{
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		
		try {
			RequestResponseContext.setRequest(request);
			RequestResponseContext.setResponse(response);
		} catch (Exception e) {
			throw new BusinessException("存入客户端请求失败！");
		}
		return true;
	}
}
