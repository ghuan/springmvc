package com.fanfan.system.core.exception;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.fanfan.system.util.VTools;

import net.sf.json.JSONObject;

/**
 * 
* Copy right huan.gao 2015-7-13下午06:50:28
* All right reserved
* QQ:2223486623 
* description：全局异常处理类
 */
public class CustomSimpleMappingExceptionResolver extends  
        SimpleMappingExceptionResolver {  
  
    protected ModelAndView doResolveException(HttpServletRequest request,  
            HttpServletResponse response, Object handler, Exception ex) {  
        // Expose ModelAndView for chosen error view.  
    	try {
    		//ajax请求返回json
    		Map<String,Object> map = new HashMap<String,Object>();
    		map.put("success", false);
            PrintWriter writer = response.getWriter();
        	if(ex instanceof BusinessException){
        		if(VTools.StringIsEmpty(ex.getMessage())){
                	
                	map.put("msg", "服务器内部错误，请联系管理员！");
                }else {
                	
                	map.put("type", ((BusinessException)ex).getType());
                	map.put("msg", ex.getMessage());
                	
                	//如果是会话失效
//                	if(((BusinessException)ex).getType() == Integer.parseInt(System_Constants.EXCEPTION_TYPE_SESSION)){
//                		response.setStatus(response.SC_OK);//200
//                	}else {
//                		
//                		response.setStatus(response.SC_INTERNAL_SERVER_ERROR);//500
//                	}
                }
        	}
            writer.write(JSONObject.fromObject(map).toString()); 
            writer.flush(); 
            return null;
        } catch (IOException e) {  
            e.printStackTrace();  
        }
        return null;
    }  
}  