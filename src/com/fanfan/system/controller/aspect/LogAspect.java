
package com.fanfan.system.controller.aspect;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fanfan.system.core.annotation.*;
import net.sf.json.util.JSONUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fanfan.system.core.exception.BusinessException;
import com.fanfan.system.core.web.RequestResponseContext;
import com.fanfan.system.util.constants.System_Constants;
import com.fanfan.system.vo.LoginInfo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import java.lang.reflect.Method;

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

//	@Autowired
//	private HttpServletRequest request;
//	@Autowired
//	private HttpServletResponse response;
//	@Autowired
//	private HttpSession session;
	protected static final Log log = LogFactory.getLog("errorLog");
	//定义通用切点
    @Pointcut("execution(* com.fanfan.*..controller..*.*(..))")
    public void simplePointcut() { 
    }

    //定义controller层切点
    @Pointcut("@annotation(com.fanfan.system.core.annotation.ControllerLog)")
    public void controllerPointcut(){
    }

    //定义service层切点
    @Pointcut("@annotation(com.fanfan.system.core.annotation.ServiceLog)")
    public void servicePointcut(){
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

	/**
	 * 异常输出日志
	 *
	 * @param joinPoint
	 * @param e
	 */
	@AfterThrowing(pointcut = "simplePointcut()", throwing = "e")
	public  void afterThrowing(JoinPoint joinPoint, Throwable e) {

		String method = joinPoint.getSignature().toLongString();
		HttpServletRequest request = RequestResponseContext.getRequest();
		String checkLogin = request.getParameter("checkLogin");
		checkLogin = "false".equals(checkLogin) ? "false" : "true";
		if(checkLogin.equals("true")){
			log.error(e.getMessage(), e);
		}

	}

    //切入controller切点
    @Before("controllerPointcut()")
    public void beforeController(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toLongString();
        String aa = LogAspect.getAnnotationDescription(joinPoint, ControllerLog.class);
        System.out.println(aa);
    }

    //切入service切点
    @Before("servicePointcut()")
    public void beforeService(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toLongString();
    }

    /**
     * 获取注释description内容
     * @param joinPoint
     * @param clazz
     * @return
     */
    public static String getAnnotationDescription(JoinPoint joinPoint,Class clazz){
        String description = "";
        try {
            String targetName = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            Object[] arguments = joinPoint.getArgs();
            Class targetClass = Class.forName(targetName);
            Method[] methods = targetClass.getMethods();

            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    Class[] clazzs = method.getParameterTypes();
                    if (clazzs.length == arguments.length) {
                        if(clazz.equals(ControllerLog.class)){
                            description = method.getAnnotation(ControllerLog.class).description();
                        }else if(clazz.equals(ServiceLog.class)){
                            description = method.getAnnotation(ControllerLog.class).description();
                        }
                        break;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return description;
    }

}
