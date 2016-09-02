
package com.fanfan.system.controller.aspect;


import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Controller;

import com.fanfan.system.core.exception.BusinessException;
import com.fanfan.system.core.web.RequestResponseContext;
import com.fanfan.system.util.constants.System_Constants;
import com.fanfan.system.vo.LoginInfo;

/**
 * 
* Copy right huan.gao 2015-7-4下午08:36:37
* All right reserved
* QQ:2223486623 
* description：AOP
 */
@Controller
@Aspect
public class LogAspect{   
	
	//定义切点
    @Pointcut("execution(* com.fanfan.*..controller..*.*(..))")
    public void simplePointcut() { 
    }
    //切入切点  
    @AfterReturning(pointcut = "simplePointcut()", returning = "result") 
    public void afterAdvice(JoinPoint joinPoint, Object result) { 
    	String method = joinPoint.getSignature().toLongString();
    	System.out.println("执行结束:"+method);
//        for(Method methodObj:joinPoint.getTarget().getClass().getMethods()){
//			if(method.equals(methodObj.getName())){
//					Object[] params = joinPoint.getArgs();//请求参数
//				break;
//			}
//		}
    }
    //切入切点  
	@Before("simplePointcut()")   
    public void beforeAdvice(JoinPoint joinPoint) { 
    	
		String method = joinPoint.getSignature().toLongString();
		
		System.out.println("开始执行:"+method);
		if(method.indexOf("SystemController.login")==-1){

			HttpServletRequest request = RequestResponseContext.getRequest();
			String checkLogin = request.getParameter("checkLogin");
			checkLogin = "false".equals(checkLogin) ? "false" : "true";
			if(checkLogin.equals("true")){
				
				LoginInfo loginInfo = (LoginInfo) request.getSession().getAttribute(System_Constants.USER_LOGININFO);
				if(loginInfo == null){
					
					throw new BusinessException("对不起，您的登陆信息已失效，请重新登陆！",Integer.parseInt(System_Constants.EXCEPTION_TYPE_SESSION));//会话失效
				}
			}
		}	
    }
	
}
