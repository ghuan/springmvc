package com.fanfan.system.service;

import java.util.List;

import com.fanfan.system.entity.Org;

/**
 * 
* Copy right huan.gao 2015-7-7下午10:31:50
* All right reserved
* QQ:2223486623 
* description：组织部门service接口
 */
public interface IOrgService{

	
	/**
	 * 保存或更新
	 * @param role
	 */
	public void saveOrUpdate(Org org);
	
	/**
	 * 删除
	 * @param ids
	 */
	public void delete(String[] ids);
	
	/**
	 * 获取组织机构数据
	 * @param pid
	 * @param id
	 * @return
	 */
	public List<Org> getOrg(String pid,String id,String queryText,String queryValue);
	
	/**
	 * 获取组织机构路径
	 * @param fromOrgid
	 * @param name
	 * @param initData
	 * @return
	 */
	public List<Org> getOrgByPath(String queryText,String queryValue);
	
}
