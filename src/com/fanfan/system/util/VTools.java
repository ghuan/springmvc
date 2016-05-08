package com.fanfan.system.util;

import java.beans.PropertyDescriptor;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import com.fanfan.system.core.exception.BusinessException;

/**
 * 
* Copy right huan.gao 2015-7-4下午09:12:35
* All right reserved
* QQ:2223486623 
* description：工具类
 */
public class VTools{

	/**
	 * md5
	 * @param param
	 * @return String
	 */
	public static String getMD5(String param){
		
		MD5 md5 = new MD5();
		return md5.md5s(param);
	}
	
	/**
	 * 判断list是否为空
	 * @param list
	 * @return boolean
	 */
	@SuppressWarnings("rawtypes")
	public static boolean ListIsEmpty(List list){
		
		if(list == null || list.size() == 0){
			
			return true;
		}else {
			
			return false;
		}
	}
	
	/**
	 * 判断字符串是否为空
	 * @param param
	 * @return
	 */
	public static boolean StringIsEmpty(String param){
		
		if("".equals(param) || null == param){
			
			return true;
		}else {
			
			return false;
		}
	}
	
	/**
	 * 判断数组是否为空
	 * @param array
	 * @return
	 */
	public static boolean ArrayIsNullOrEmpty(Object[] array) {
		return (array == null) || (array.length == 0);
	}
	
	/**
	 * 根据name获取Cookie值
	 * @param name
	 * @param request
	 * @return
	 */
	public static String getCookie(String name,HttpServletRequest request){
		
		Cookie[] cook = request.getCookies();
		for(Cookie c:cook){
			
			if(name.equals(c.getName())){
				
				return c.getValue();
			}
		}
		return "";
	}
	
	/**
	 * 生成新UUID
	 * @return
	 */
	public static String getNewUUID(){
		
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	/**
	 * 获取用户客户端ip
	 * @param request
	 * @return
	 */
	public static String getLoginIp(HttpServletRequest request){
		
		String ip = request.getHeader("x-forwarded-for");
	    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
	      ip = request.getHeader("Proxy-Client-IP");
	    }
	    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
	      ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
	      ip = request.getHeader("HTTP_CLIENT_IP");
	    }
	    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
	      ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	    }
	    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
	      ip = request.getRemoteAddr();
	    }
	    return ip;
	}
	
	/**
	 *  获取当前时间
	 * @param formatParam
	 * @return
	 */
	public static String getTimeNow(String formatParam){
		
		try
	    {
	      Date localDate = new Date();
	      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(formatParam);
	      return localSimpleDateFormat.format(localDate);
	    }
	    catch (Exception localException)
	    {
	      localException.printStackTrace();
	    }
	    return "";
	}
	
	
	/**
	 * Object 转  String
	 * @param o
	 * @return
	 */
	public static String ObjectToString(Object o){
		
		if(o == null){
			
			return null;
		}
		return o.toString();
	}
	
	/**
	 * Object 转  Integer
	 * @param o
	 * @return
	 */
	public static Integer ObjectToInteger(Object o){
		
		if(o == null){
			
			return 0;
		}
		return Integer.parseInt(o.toString());
	}
	
	/**
     * 将数据库查询得出的List<Map>中的属性设置到实体对象中，并加入list
     * @param entity
     * @param map
     * @param isLowerCase[true:Map中属性为小写;false:Map中属性为大写]
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static List getListBeanFromSqlListMap(Class clazz, List<Map> list, Boolean isLowerCase){
		
    	List rs = new ArrayList();
		try {
			
			for(Map map : list){
				
				//实例化对象
				Object bean = clazz.newInstance();
				setBeanFromSqlMap(bean, map, isLowerCase,null);
				rs.add(bean);
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			throw new BusinessException(e.getMessage());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			throw new BusinessException(e.getMessage());
		}
		
		return rs;
	}
	/**
     * 将数据库查询得出的Map中的属性设置到实体对象中，属性不区分大小写
     * @param entity
     * @param map
     * @param isLowerCase[true:Map中属性为小写;false:Map中属性为大写]
     */
    @SuppressWarnings("rawtypes")
	public static void setBeanFromSqlMap(Object bean, Map map, Boolean isLowerCase) {
    	setBeanFromSqlMap(bean, map, isLowerCase,null);
    }
    @SuppressWarnings("rawtypes")
	public static void setBeanFromSqlMap(Object bean, Map map, Boolean isLowerCase, String[] ignore) {
    	List list = new ArrayList();
    	if(null != ignore){
    		list = Arrays.asList(ignore);
    	}
        PropertyDescriptor[] descr = PropertyUtils.getPropertyDescriptors(bean);
        for (int i = 0; i < descr.length; i++) {
            PropertyDescriptor d = descr[i];
            String key;
            if(list.contains(d.getName())){
				continue;
			}
            if(isLowerCase){
            	key = d.getName().toLowerCase();
            }else{
            	key = d.getName().toUpperCase();
            }
            if (d.getWriteMethod() == null) //当前属性没有对应的可写的方法
                continue;
            if (!map.containsKey(key)) //Map无当前属性
                continue;
            try {
                Class clazz = d.getPropertyType();
                Object value = map.get(key);
                if (value == null || (!String.class.equals(clazz) && "".equals(value))) {
                    continue;
                }
                if (value.getClass().equals(clazz)) {//String型
                    PropertyUtils.setProperty(bean, d.getName(), value);
                }else if(value.getClass().equals(BigDecimal.class)){//数字类型
                	BigDecimal big = (BigDecimal) value;
                	if(clazz.equals(Long.class)){
                		PropertyUtils.setProperty(bean, d.getName(), big.longValue());
                	}else if(clazz.equals(Double.class)){
                		PropertyUtils.setProperty(bean, d.getName(), big.doubleValue());
                	}else if(clazz.equals(Integer.class)){
                		PropertyUtils.setProperty(bean, d.getName(), big.intValue());
                	}else if(clazz.equals(String.class)){
                		PropertyUtils.setProperty(bean, d.getName(), value.toString());
                	}
                }else if(value.getClass().equals(Timestamp.class)){//时间类型
                	Date date = (Date) value;
                	PropertyUtils.setProperty(bean, d.getName(), date);
            	}
            } catch (Exception e) {
                throw new BusinessException("属性名：" + d.getName() + " 设置到bean中时出错", e);
            }
        }
    }
    
    /**
     * 获取request
     * @return
     */
    public static HttpServletRequest getHttpServletRequest(){
    	
    	return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }
    
    /**
     * 获取response
     * @return
     */
    public static HttpServletResponse getHttpServletResponse(){
    	
    	return ((ServletWebRequest)RequestContextHolder.getRequestAttributes()).getResponse();
    }
    
    /**
     * 获取session
     * @return
     */
    public static HttpSession getHttpSession(){
    	
    	return getHttpServletRequest().getSession();
    }
}
