package com.fanfan.system.dao;

import java.util.List;

import com.fanfan.system.entity.Org;


public interface IOrgDao {

	/**
	 * 保存
	 * @param role
	 */
	public void saveOrUpdate(Org org);
	
	/**
	 * 删除
	 * @param id
	 */
	public void delete(String id);
	
	/**
	 * 查询组织部门数据
	 * @param pid
	 * @return
	 */
	public List<Org> queryOrgByPid(String pid);
	
	/**
	 * 查询组织部门数据
	 * @param id
	 * @return
	 */
	public Org queryOrgById(String id);
	
	/**
	 * 根据name查询组织部门路径
	 * @param name
	 * @return list
	 */
	@SuppressWarnings("rawtypes")
	public List queryOrgPathByName(String name);
	
	/**
	 * 根据ids查询组织部门路径
	 * @param ids
	 * @return list
	 */
	@SuppressWarnings("rawtypes")
	public List queryOrgPathByIds(String[] ids);
	
}
