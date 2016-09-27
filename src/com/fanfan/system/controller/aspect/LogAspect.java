
package com.fanfan.system.controller.aspect;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fanfan.system.core.annotation.*;
import com.fanfan.system.service.ILogService;
import com.fanfan.system.util.VTools;
import net.sf.json.JSONArray;
import net.sf.json.util.JSONUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import com.fanfan.system.core.exception.BusinessException;
import com.fanfan.system.core.web.RequestResponseContext;
import com.fanfan.system.util.constants.System_Constants;
import com.fanfan.system.vo.LoginInfo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

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
    @Autowired
    private ILogService logService;

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

		HttpServletRequest request = RequestResponseContext.getRequest();
		String checkLogin = request.getParameter("checkLogin");
		checkLogin = "false".equals(checkLogin) ? "false" : "true";
        String method = joinPoint.getSignature().toLongString();
        if(method.indexOf("SystemController.login")==-1 && method.indexOf("SystemController.logout") == -1){

            if(checkLogin.equals("true")){
                log.error(e.getMessage(), e);
                String params = "";
                if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {
                    for ( int i = 0; i < joinPoint.getArgs().length; i++) {
                        params += JSONArray.fromObject(joinPoint.getArgs()[i])+" ";
                    }
                }
                //记录异常日志到数据库
                LoginInfo loginInfo = (LoginInfo) request.getSession().getAttribute(System_Constants.USER_LOGININFO);
                com.fanfan.system.entity.Log databaseLog = new com.fanfan.system.entity.Log();
                databaseLog.setDescription(e.getMessage());
                databaseLog.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
                databaseLog.setType(1);
                databaseLog.setRequestIp(VTools.getLoginIp(request));
                databaseLog.setExceptionCode( e instanceof BusinessException ? ((BusinessException)e).getType()+"" : "0");
                databaseLog.setExceptionDetail(e.toString());
                databaseLog.setParams( params);
                databaseLog.setCreator(loginInfo.getUser().getId());
                databaseLog.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                //保存数据库
                logService.saveOrUpdate(databaseLog);
                throw new BusinessException(e.getMessage());//加上这句让异常拦截器获取到e.getMessage()
            }
        }

	}

    //切入controller切点

    /**
     * 记录controller日志到数据库
     * @param joinPoint
     */
    @Before("controllerPointcut()")
    public void beforeController(JoinPoint joinPoint) {

        try {
            String params = "";
            if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {
                for ( int i = 0; i < joinPoint.getArgs().length; i++) {
                    params += JSONArray.fromObject(joinPoint.getArgs()[i])+" ";
                }
            }
            HttpServletRequest request = RequestResponseContext.getRequest();
            LoginInfo loginInfo = (LoginInfo) request.getSession().getAttribute(System_Constants.USER_LOGININFO);
            com.fanfan.system.entity.Log databaseLog = new com.fanfan.system.entity.Log();
            databaseLog.setDescription(LogAspect.getAnnotationDescription(joinPoint, ControllerLog.class));
            databaseLog.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            databaseLog.setType(0);
            databaseLog.setRequestIp(VTools.getLoginIp(request));
            databaseLog.setExceptionCode( null);
            databaseLog.setExceptionDetail( null);
            databaseLog.setParams(params);
            databaseLog.setCreator(loginInfo.getUser().getId());
            databaseLog.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            //保存数据库
            logService.saveOrUpdate(databaseLog);
        }catch (Exception e){
            log.error(e.getMessage(), e);
        }
    }

    //切入service切点
    /**
     * 记录service日志到数据库
     * @param joinPoint
     */
    @Before("servicePointcut()")
    public void beforeService(JoinPoint joinPoint) {
        try {

            String params = "";
            if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {
                for ( int i = 0; i < joinPoint.getArgs().length; i++) {
                    params += JSONArray.fromObject(joinPoint.getArgs()[i])+" ";
                }
            }
            HttpServletRequest request = RequestResponseContext.getRequest();
            LoginInfo loginInfo = (LoginInfo) request.getSession().getAttribute(System_Constants.USER_LOGININFO);
            com.fanfan.system.entity.Log databaseLog = new com.fanfan.system.entity.Log();
            databaseLog.setDescription(LogAspect.getAnnotationDescription(joinPoint, ServiceLog.class));
            databaseLog.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            databaseLog.setType(0);
            databaseLog.setRequestIp(VTools.getLoginIp(request));
            databaseLog.setExceptionCode( null);
            databaseLog.setExceptionDetail( null);
            databaseLog.setParams( params);
            databaseLog.setCreator(loginInfo.getUser().getId());
            databaseLog.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            //保存数据库
            logService.saveOrUpdate(databaseLog);
        }catch (Exception e){
            log.error(e.getMessage(), e);
        }
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
