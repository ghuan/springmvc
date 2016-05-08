package com.fanfan.system.dao;

import java.util.List;

import com.fanfan.system.entity.Dict;
import com.fanfan.system.entity.Menu;
import com.fanfan.system.entity.Org;
import com.fanfan.system.entity.Role;
import com.fanfan.system.entity.User;
import com.fanfan.system.entity.UserExt;
import com.fanfan.system.vo.LoginInfo;


public interface ISystemDao {

	/**
	 * 获取用户菜单 by roles
	 */
	public List<Menu> queryMenusByRoles(LoginInfo loginInfo, String pid, String subsystemid, String mng);
	
	/**
	 * 查询系统管理员菜单
	 * @param pid
	 * @param mng
	 * @return
	 */
	public List<Menu> queryAdminMenus(String pid, String mng);
	
	/**
	 * 根据userid查询用户菜单信息
	 * @param userid
	 * @return
	 */
	public List<Menu> queryUserMenuByUserid(String userid);
	
	/**
	 * 获取用户组织部门信息
	 * @param user
	 * @return
	 */
	public Org queryUserOrg(User user);
	
	/**
	 * 获取所有权限
	 * @param 
	 */
	public List<Role> getRoles();
	
	/**
	 * 根据userid查询用户权限
	 * @param userid
	 * @return
	 */
	public List<Role> queryUserRoleByUserid(String userid);
	
	/**
	 * 根据loginname获取user
	 * @param user
	 * @return
	 */
	public User getUser(User user);
	
	/**
	 * 获取用户扩展信息
	 * @param userid
	 * @return
	 */
	public List<UserExt> queryUserExt(User user);
	
	/**
	 * 根据路径查询字典
	 * @param 
	 * @return
	 */
	public Dict getDictByPath(String path);
	
	/**
	 * 根据路径查询字典
	 * @param 
	 * @return
	 */
	public List<Dict> getDictListByPath(String path);
	
	/**
	 * 修改用户信息
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * 验证用户权限
	 * @param authPath
	 * @return
	 */
	public boolean checkAuth(String authPath,String userId);
	
}
