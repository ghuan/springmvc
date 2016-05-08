package com.fanfan.system.service;

import java.util.List;

import com.fanfan.system.entity.Dict;

/**
 * 
* Copy right huan.gao 2015-7-7下午10:31:50
* All right reserved
* QQ:2223486623 
* description：数据字典service接口
 */
public interface IDictService{

	/**
	 * 保存或修改
	 * @param menu
	 */
	public void saveOrUpdate(Dict dict);
	
	/**
	 * 删除
	 * @param ids[]
	 */
	public void delete(String[] ids);
	
	/**
	 * 加载数据字典数据
	 * @param pid
	 * @return
	 */
	public List<Dict> loadSystemDicts(String pid);
	
}
