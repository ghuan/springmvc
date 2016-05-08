package com.fanfan.system.controller;

import java.util.List;

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
import com.fanfan.system.service.IAuthService;
import com.fanfan.system.vo.MenuChecked;

/**
 * 
* Copy right huan.gao 2015-6-17下午11:21:45
* All right reserved
* QQ:2223486623 
* description：角色权限管理Action
 */
@Controller
@RequestMapping(value="auth")
public class AuthController{

	protected static final Log log = LogFactory.getLog(AuthController.class);
	
	@Autowired
	private IAuthService authService;
	
	/**
	 * 跳转到角色权限管理页面
	 * @param
	 * @return
	 */
	@RequestMapping(value="viewAuth")
	public String viewAuth() {
		
		log.info("正在载入角色权限管理页面...");
		return "system/auth";
	}
	
	/**
	 * 获取角色分页数据
	 * @param
	 * @return
	 */
	@RequestMapping(value="getRole")
	@ResponseBody
	public Page getRole(Page page,Role role,String roleIds) {
		
		try {
			return authService.getRole(page,role,roleIds);
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}
	
	/**
	 * 获取菜单权限数据
	 * @param
	 * @return
	 */
	@RequestMapping(value="getAuth")
	@ResponseBody
	public List<MenuChecked> getAuth(String node,String roleId) {
		
		try {
			return authService.getAuth(node, roleId);
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}
	
	/**
	 * 保存角色菜单权限
	 * @param
	 * @return
	 */
	@RequestMapping(value="saveAuth")
	@ResponseBody
	public void saveAuth(String auths,String roleId) {
		
		try {
			authService.saveAuth(auths, roleId);
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}
	
	/**
	 * 保存或更新系统角色
	 * @param
	 * @return
	 */
	@RequestMapping(value="saveOrUpdateRole")
	@ResponseBody
	public void saveOrUpdateRole(Role role) {
		
		try {
			authService.saveOrUpdateRole(role);
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}
	
	/**
	 * 删除系统角色
	 * @param
	 * @return
	 */
	@RequestMapping(value="delRole")
	@ResponseBody
	public void delRole(String[] roleIds) {
		
		try {
			authService.delRole(roleIds);
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}
	
	/**
	 * 获取某个角色下的用户数据
	 * @param
	 * @return
	 */
	@RequestMapping(value="getUserRole")
	@ResponseBody
	public List<User> getUserRole(String roleId) {
		
		try {
			return authService.getUserRole(roleId);
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}
	
	/**
	 * 保存用户与角色的关联
	 * @param roleId
	 * @param userIds
	 */
	@RequestMapping(value="saveUserRole")
	@ResponseBody
	public void saveUserRole(String roleId,String[] userIds) {
		
		try {
			authService.saveUserRole(roleId, userIds);
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}
	
}
