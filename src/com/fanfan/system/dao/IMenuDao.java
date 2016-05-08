package com.fanfan.system.dao;

import java.util.List;

import com.fanfan.system.entity.Menu;

/**
 * 
* Copy right huan.gao 2015-7-8下午09:12:10
* All right reserved
* QQ:2223486623 
* description：菜单接口
 */
public interface IMenuDao {

	/**
	 * 保存或修改
	 * @param menu
	 */
	public void saveOrUpdate(Menu menu);
	
	/**
	 * 删除
	 * @param id
	 */
	public void delete(String id);
	
	
	/**
	 * 获取用户菜单 
	 * @param pid
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List queryMenusByPid(String pid);
}
