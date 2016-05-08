package com.fanfan.system.service;

import java.util.List;

import com.fanfan.system.core.hibernate.Page;
import com.fanfan.system.entity.Role;
import com.fanfan.system.entity.User;

/**
 * 
* Copy right huan.gao 2015-7-7下午10:31:50
* All right reserved
* QQ:2223486623 
* description：用户service接口
 */
public interface IUserService{

	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(User user);
	
	/**
	 * 保存或更新
	 * @param user
	 */
	public void saveOrUpdate(User user,String roleIds);
	
	/**
	 * 删除
	 * @param ids
	 */
	public void delete(String[] ids);
	
	/**
	 * 获取用户分页数据
	 * @param page
	 * @return
	 */
	public Page getUserPage(Page page,User user);
	
	/**
	 * 获取角色数据
	 * @return
	 */
	public List<Role> getRole(String queryText,String queryValue);
	
}
