package com.fanfan.system.dao;

import java.util.List;

import com.fanfan.system.entity.Dict;

public interface IDictDao {

	/**
	 * 保存或修改
	 * @param dict
	 */
	public void saveOrUpdate(Dict dict);
	
	/**
	 * 删除
	 * @param id
	 */
	public void delele(String id);
	
	/**
	 * 查询数据字典
	 * @param pid
	 * @return
	 */
	public List<Dict> getDictByPid(String pid);
	
}
