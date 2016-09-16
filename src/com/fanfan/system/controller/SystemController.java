package com.fanfan.system.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fanfan.system.core.annotation.ControllerLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fanfan.system.core.exception.BusinessException;
import com.fanfan.system.entity.Dict;
import com.fanfan.system.entity.Menu;
import com.fanfan.system.entity.User;
import com.fanfan.system.service.ISystemService;
import com.fanfan.system.util.VTools;
import com.fanfan.system.util.constants.System_Constants;
import com.fanfan.system.vo.LoginInfo;

/**
 * 
* Copy right huan.gao 2015-6-17下午11:21:45
* All right reserved
* QQ:2223486623 
* description：管理Action
 */
@Controller
@RequestMapping(value="system")
@SessionAttributes(System_Constants.USER_LOGININFO)//定义loginInfo 存入 session'
public class SystemController{

	@Autowired
	private ISystemService systemService;
	
	/**
	 * 登录
	 * @param request
	 * @return
	 */
	@RequestMapping(value="login")
	@ResponseBody
	public void login(User user,Model model,HttpServletRequest request) {
		
		try {
			LoginInfo loginInfo = systemService.LoginAndGetLoginInfo(user);
			if(loginInfo.isSuccess()){
				//更新用户登陆ip与时间
			    loginInfo.getUser().setLastIp(VTools.getLoginIp(request));
			    loginInfo.getUser().setLastTime(VTools.getTimeNow(System_Constants.TIMEFORMAT_YMDHMS));
			    systemService.updateUser(loginInfo.getUser());
			    model.addAttribute(System_Constants.USER_LOGININFO, loginInfo);
			}else {
				
				throw new BusinessException(loginInfo.getMessage());
			}
	    	

	    } catch (Exception e) {
			// TODO: handle exception
	    	throw new BusinessException(e.getMessage());
		}
		
	}

	/**
	 * 登录回调
	 * @return
	 */
	@RequestMapping(value="loginCallback")
	@ResponseBody
	@ControllerLog(description = "登陆系统")
	public void loginCallback() {

	}
	
	/**
	 * 注销
	 * @param session
	 */
	@RequestMapping("logout")
	@ResponseBody
	public void logout(HttpSession session){
		
		session.invalidate();
		throw new BusinessException("用户信息已注销！是否重新登录？",Integer.parseInt(System_Constants.EXCEPTION_TYPE_SESSION));
		
	}
	
	
	/**
	 * 根据路径获取字典值
	 * @return
	 */
	@RequestMapping(value="getDictValue")
	@ResponseBody
	public Map<String,Object> getDictValue(HttpServletRequest request){
		
		Map<String,Object> map = new HashMap<String, Object>(); 
		String path = request.getParameter("path");
		try {
			
			if(!VTools.StringIsEmpty(path)){
				
				Dict dict = systemService.getDictByPath(path);
				if(dict == null){
					
					map.put("value", null);
				}else {
					
					map.put("value", systemService.getDictByPath(path).getValue());
				}
				
			}else {
				
				throw new BusinessException("查询的字典路径不能为空！");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new BusinessException(e.getMessage());
		}
		
	    return map;
	}
	
	/**
	 * 根据路径获取字典list
	 * @return
	 */
	@RequestMapping(value="getDictStore")
	@ResponseBody
	public List<Dict> getDictStore(HttpServletRequest request){
		
		String path = request.getParameter("path");
		List<Dict> dicts = new ArrayList<Dict>();
		try {
			
			if(!VTools.StringIsEmpty(path)){
				
				dicts = systemService.getDictListByPath(path);
				if(VTools.ListIsEmpty(dicts)){
					
					throw new BusinessException("字典路径["+path+"]为空！");
				}
				
			}else {
				
				throw new BusinessException("查询的字典路径不能为空！");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new BusinessException(e.getMessage());
		}
		
	    return dicts;
	}
	
	
	/**
	 * 加载子系统菜单
	 * @return
	 */
	@RequestMapping(value="loadSubsystemMenu")
	@ResponseBody
	public List<Menu> loadSubsystemMenu(HttpServletRequest request,HttpSession session)
	  {
		List<Menu> list = new ArrayList<Menu>();
		try {
			
			String pid = request.getParameter("node");
		    String subsystemid = request.getParameter("subsystemId");
		    LoginInfo loginInfo = (LoginInfo) session.getAttribute(System_Constants.USER_LOGININFO);
		    list = systemService.loadSubsystemMenu(pid, subsystemid, loginInfo);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new BusinessException(e.getMessage());
		}
	    
	    return list;
	  }
	
	/**
	 * 修改用户密码
	 * @return
	 */
	//@RequestMapping(value="/modifyPWD", produces = "application/json; charset=utf-8")
	@RequestMapping(value="modifyPWD")
	@ResponseBody
	@ControllerLog(description = "修改用户密码")
	public void modifyPWD(HttpServletRequest request,HttpSession session)
	  {
		
		String loginName = request.getParameter("loginName");
		String oldPwd = request.getParameter("oldPwd");
		String newPwd = request.getParameter("newPwd");
		try {
			systemService.modifyPWD(loginName, oldPwd, newPwd);
			session.invalidate();//注销用户信息
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
	  }
	
	/**
	 * 下载帮助文档
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="download")
	@ControllerLog(description = "下载帮助文档")
	public void download(HttpServletRequest request,HttpServletResponse response){
		
		try {
			String filePath = new String(request.getParameter("filePath").getBytes("ISO-8859-1"),"UTF-8");//文件路径
			String returnFileName = new String(request.getParameter("fileName").getBytes("ISO-8859-1"),"UTF-8");//下载文件名
			String localFilePath = request.getSession().getServletContext().getRealPath(filePath);//文件在服务器中的真实路径
			systemService.downloadLocalFile(localFilePath, returnFileName);//service 处理 并 返回下载文件流
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 验证权限
	 * @param authPath
	 * @return
	 */
	@RequestMapping(value="checkSystemAuth")
	@ResponseBody
	public boolean checkSystemAuth(String authPath,HttpSession session){
		
		try {
			LoginInfo loginInfo = (LoginInfo) session.getAttribute(System_Constants.USER_LOGININFO);
			return systemService.checkSystemAuth(authPath,loginInfo);
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		
	}
}
