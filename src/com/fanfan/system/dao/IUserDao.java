package com.fanfan.system.dao;

import java.util.List;

import com.fanfan.system.core.hibernate.Page;
import com.fanfan.system.entity.Role;
import com.fanfan.system.entity.User;
import com.fanfan.system.entity.UserRole;


public interface IUserDao {

	/**
	 * 保存User实体
	 * @param entity
	 */
	public void save(User user);
	
	/**
	 * 保存或更新
	 * @param user
	 */
	public void saveOrUpdate(User user);
	
	/**
	 * 删除
	 * @param user
	 */
	public void delete(String id);
	
	/**
	 * 分页查询用户数据
	 * @param page
	 * @return
	 */
	public Page queryUserPage(Page page,User user);
	
	/**
	 * 查询用户(用于保存用户信息时检验学工号stuempno，登陆名loginname,身份证号IDcard是否已存在)
	 * @param user(保存的用户信息)
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List checkSaveOrUpdateUser(User user);
	
	/**
	 * 查询角色
	 * @return
	 */
	public List<Role> queryRole();
	
	/**
	 * 根据name查询角色路径
	 * @param name
	 * @return List<Org>
	 */
	public List<Role> queryRolePathByNames(String[] names);
	
	/**
	 * 根据ids查询角色路径
	 * @param ids
	 * @return List<Org>
	 */
	public List<Role> queryRolePathByIds(String[] ids);
	
	/**
	 * 删除用户角色关联
	 * @param userId
	 */
	public void deleteUserRoleByUserId(String userId);
	
	/**
	 * 保存用户角色关联
	 * @param userRole
	 */
	public void saveUserRole(UserRole userRole);
	
}
