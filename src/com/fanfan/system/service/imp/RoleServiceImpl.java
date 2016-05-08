package com.fanfan.system.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fanfan.system.dao.IRoleDao;
import com.fanfan.system.entity.Role;
import com.fanfan.system.service.IRoleService;

/**
 * 
* Copy right huan.gao 2015
* All right reserved
* QQ:2223486623 
* description：	权限service
 */
@Service
@Transactional //异常回滚
public class RoleServiceImpl implements IRoleService{

	@Autowired
	private IRoleDao roleDao;
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(Role role){
		
		roleDao.save(role);
	}
	
}
