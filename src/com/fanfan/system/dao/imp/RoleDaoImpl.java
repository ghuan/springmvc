package com.fanfan.system.dao.imp;

import org.springframework.stereotype.Repository;

import com.fanfan.system.dao.IRoleDao;
import com.fanfan.system.entity.Role;

/**
 * 
* Copy right huan.gao 2015
* All right reserved
* QQ:2223486623 
* description：权限Dao
 */
@Repository
public class RoleDaoImpl extends BaseDaoImpl implements IRoleDao{
	
	/**
	 * 保存
	 * @param role
	 */
	public void save(Role role){
		
		super.save(role);
	}
	
}
