package com.fanfan.system.core.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
* Copy right huan.gao 下午2:11:00
* All right reserved
* QQ:2223486623 
* description：解决多线程并发问题及普通类获取request，response
 */
public class RequestResponseContext {
	private static ThreadLocal<HttpServletRequest> request_threadLocal = new ThreadLocal<HttpServletRequest>();
	private static ThreadLocal<HttpServletResponse> response_threadLocal = new ThreadLocal<HttpServletResponse>();
	
	public static void setRequest(HttpServletRequest request){
		
		request_threadLocal.set(request);
	}
	public static HttpServletRequest getRequest(){
		
		return request_threadLocal.get();
	}
	public static void removeRequest(){
		
		request_threadLocal.remove();
	}
	public static void setResponse(HttpServletResponse response){
		
		response_threadLocal.set(response);
	}
	public static HttpServletResponse getResponse(){
		
		return response_threadLocal.get();
	}
	public static void removeResponse(){
		
		response_threadLocal.remove();
	}
}
