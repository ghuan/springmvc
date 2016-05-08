package com.fanfan.system.service;

import java.util.List;

import com.fanfan.system.core.hibernate.Page;
import com.fanfan.system.entity.Role;
import com.fanfan.system.entity.User;
import com.fanfan.system.vo.MenuChecked;

/**
 * 
* Copy right huan.gao 2015-7-7下午10:31:50
* All right reserved
* QQ:2223486623 
* description：角色权限管理service接口
 */
public interface IAuthService{

	
	/**
	 * 获取角色分页数据
	 * @return
	 */
	public Page getRole(Page page,Role role,String roleIds);
	
	/**
	 * 获取菜单权限数据
	 * @param pid
	 * @param roleId
	 * @return
	 */
	public List<MenuChecked> getAuth(String pid,String roleId);
	
	/**
	 * 保存角色菜单权限
	 * @param auths
	 * @param roleId
	 */
	public void saveAuth(String auths,String roleId);
	
	/**
	 * 保存或更新系统角色
	 * @param role
	 */
	public void saveOrUpdateRole(Role role);
	
	/**
	 * 删除角色
	 * @param roleIds
	 */
	public void delRole(String[] roleIds);
	
	/**
	 * 获取某个角色下的用户数据
	 * @param roleId
	 * @return
	 */
	public List<User> getUserRole(String roleId);
	
	/**
	 * 保存用户与角色的关联
	 * @param roleId
	 * @param userIds
	 */
	public void saveUserRole(String roleId,String[] userIds);
	
}
