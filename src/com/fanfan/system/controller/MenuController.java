package com.fanfan.system.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fanfan.system.core.exception.BusinessException;
import com.fanfan.system.entity.Menu;
import com.fanfan.system.service.IMenuService;
import com.fanfan.system.util.constants.Menu_Constants;
import com.fanfan.system.util.constants.System_Constants;
import com.fanfan.system.vo.LoginInfo;

/**
 * 
* Copy right huan.gao 2015-6-17下午11:21:45
* All right reserved
* QQ:2223486623 
* description：菜单管理Action
 */
@Controller
@RequestMapping(value="menu")
@SessionAttributes(System_Constants.USER_LOGININFO)//定义loginInfo 存入 session'
public class MenuController{

	protected static final Log log = LogFactory.getLog(MenuController.class);
	
	@Autowired
	private IMenuService menuService;
	
	/**
	 * 跳转到菜单管理页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="viewMenu")
	public String viewMenu() {
		
		log.info("正在载入菜单管理界面...");
		return "system/menu";
	}
	
	/**
	 * 加载菜单
	 * @return
	 */
	@RequestMapping(value="loadMenu")
	@ResponseBody
	public List<Menu> loadMenu(HttpServletRequest request)
	  {
		List<Menu> list = new ArrayList<Menu>();
		try {
			
			String pid = request.getParameter("node");
		    list = menuService.loadMenu(pid);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new BusinessException(e.getMessage());
		}
	    
	    return list;
	  }
	
	/**
	 * 保存菜单
	 * @param menu
	 * @return
	 */
	@RequestMapping(value="saveOrUpdate")
	@ResponseBody
	public void saveOrUpdate(Menu menu){
		
		try {
			menuService.saveOrUpdate(menu);
		} catch (Exception e) {
			// TODO: handle exception
			throw new BusinessException(e.getMessage());
		}
	}
	
	/**
	 * 删除菜单
	 * @param id
	 */
	@RequestMapping(value="delete")
	@ResponseBody
	public void delete(String[] ids){
		
		try {
			menuService.delete(ids);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new BusinessException(e.getMessage());
		}
		
	}
	
	/**
	 * 刷新菜单缓存
	 * @param request
	 * @return
	 */
	@RequestMapping(value="rfMenuSession")
	@ResponseBody
	public void rfMenuSession(Model model,HttpSession session) {
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute(System_Constants.USER_LOGININFO);
		loginInfo.setSubsystem(menuService.loadMenu(Menu_Constants.ROOT_DIRECTORY_PID));
    	model.addAttribute(System_Constants.USER_LOGININFO, loginInfo);
		
	}
	
}
