package com.fanfan.system.service;

import java.util.List;

import com.fanfan.system.entity.Menu;

/**
 * 
* Copy right huan.gao 2015-7-7下午10:31:50
* All right reserved
* QQ:2223486623 
* description：菜单service接口
 */
public interface IMenuService{

	
	/**
	 * 保存或修改
	 * @param menu
	 */
	public void saveOrUpdate(Menu menu);
	
	/**
	 * 删除
	 * @param ids[]
	 */
	public void delete(String[] ids);
	
	
	/**
	 * 加载菜单树数据
	 * @param pid
	 * @return
	 */
	public List<Menu> loadMenu(String pid);
	
}
