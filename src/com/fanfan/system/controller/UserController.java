package com.fanfan.system.controller;

import java.util.List;

import com.fanfan.system.core.annotation.ControllerLog;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fanfan.system.core.exception.BusinessException;
import com.fanfan.system.core.hibernate.Page;
import com.fanfan.system.entity.Role;
import com.fanfan.system.entity.User;
import com.fanfan.system.service.IUserService;

/**
 * 
* Copy right huan.gao 2015-6-17下午11:21:45
* All right reserved
* QQ:2223486623 
* description：用户管理Action
 */
@Controller
@RequestMapping(value="user")
public class UserController{

	protected static final Log log = LogFactory.getLog(UserController.class);
	
	@Autowired
	private IUserService userService;
	
	/**
	 * 跳转到数据字典管理页面
	 * @return
	 */
	@RequestMapping(value="viewUser")
	public String viewUser() {
		
		log.info("正在载入用户管理界面...");
		return "system/user";
	}
	
	/**
	 * 查询用户列表
	 * @param page
	 * @param user
	 * @return
	 */
	@RequestMapping(value="getUser")
	@ResponseBody
	public Page getUser(Page page,User user){
		
		try {
			return userService.getUserPage(page,user);
		} catch (Exception e) {
			// TODO: handle exception
			throw new BusinessException(e.getMessage());
		}
		//return null;
	}
	
	/**
	 * 保存或更新用户信息
	 * @param user
	 */
	@RequestMapping(value="saveOrUpdate")
	@ResponseBody
	@ControllerLog(description = "保存或更新用户信息")
	public void saveOrUpdate(User user,String roleIds){
		
		try {
			userService.saveOrUpdate(user,roleIds);
		} catch (Exception e) {
			// TODO: handle exception
			throw new BusinessException(e.getMessage());
		}
	}
	
	/**
	 * 删除用户
	 * @param ids
	 */
	@RequestMapping(value="delete")
	@ResponseBody
	@ControllerLog(description = "删除用户")
	public void delete(String[] ids){
		
		try {
			userService.delete(ids);;
		} catch (Exception e) {
			// TODO: handle exception
			throw new BusinessException(e.getMessage());
		}
	}
	
	/**
	 * 获取所有角色数据
	 */
	@RequestMapping(value="getRole")
	@ResponseBody
	public List<Role> getRole(String queryText,String queryValue){
		
		try {
			return userService.getRole(queryText,queryValue);
		} catch (Exception e) {
			// TODO: handle exception
			throw new BusinessException(e.getMessage());
		}
	}
	
	
}
