package com.fanfan.system.dao;

import java.util.List;

import com.fanfan.system.core.hibernate.Page;
import com.fanfan.system.entity.OrgRole;
import com.fanfan.system.entity.Role;
import com.fanfan.system.entity.RoleMenu;
import com.fanfan.system.entity.User;
import com.fanfan.system.entity.UserRole;
import com.fanfan.system.vo.MenuChecked;

public interface IAuthDao {
	
	/**
	 * 查询角色分页数据
	 * @return
	 */
	public Page queryRole(Page page,Role role,String[] ids);
	
	/**
	 * 查询菜单权限数据
	 * @param pid
	 * @param roleId
	 * @return
	 */
	public List<MenuChecked> queryAuth(String pid,String roleId);
	
	/**
	 * 保存角色菜单权限
	 * @param roleMenu
	 */
	public void saveAuth(RoleMenu roleMenu);
	
	/**
	 * 统计角色菜单权限数
	 * @param id
	 * @param roleId
	 * @return
	 */
	public int queryAuthCount(String menuId,String roleId);
	
	/**
	 * 删除角色菜单权限
	 * @param menuId
	 * @param roleId
	 */
	public void deleteAuth(String menuId,String roleId);
	
	/**
	 * 保存或更新系统角色
	 * @param role
	 */
	public void saveOrUpdateRole(Role role);
	
	/**
	 * 保存角色组织关系
	 * @param role
	 */
	public void saveOrgRole(OrgRole orgRole);
	
	/**
	 * 删除角色组织关系
	 * @param orgRole
	 */
	public void delOrgRoleByRoleId(String roleId);
	
	/**
	 * 删除系统角色
	 * @param roleId
	 */
	public void delRole(String roleId);
	
	/**
	 * 删除系统角色与用户关系
	 * @param roleId
	 */
	public void delUserRoleByRoleId(String roleId);
	
	/**
	 * 查询某个角色下的用户数据
	 * @param roleId
	 * @return
	 */
	public List<User> queryUserRole(String roleId);
	
	/**
	 * 保存用户与角色的关联
	 * @param userRole
	 */
	public void saveUserRole(UserRole userRole);
}
