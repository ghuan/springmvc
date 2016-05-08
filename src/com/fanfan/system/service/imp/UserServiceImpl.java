package com.fanfan.system.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fanfan.system.core.exception.BusinessException;
import com.fanfan.system.core.hibernate.Page;
import com.fanfan.system.dao.IUserDao;
import com.fanfan.system.entity.Role;
import com.fanfan.system.entity.User;
import com.fanfan.system.entity.UserRole;
import com.fanfan.system.service.IUserService;
import com.fanfan.system.util.VTools;
import com.fanfan.system.util.constants.System_Constants;

/**
 * 
* Copy right huan.gao 2015
* All right reserved
* QQ:2223486623 
* description：用户service
 */
@Service
@Transactional //异常回滚
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(User user){
		
		userDao.save(user);
	}
	
	/**
	 * 保存或更新
	 * @param user
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void saveOrUpdate(User user,String roleIds){
		
		List<Map> list = userDao.checkSaveOrUpdateUser(user);
		if(!VTools.ListIsEmpty(list)){
			String msg = "";
			for(Map map : list){
				
				msg += map.get("msg")+"<br></br>";
			}
			msg = msg.substring(0,msg.lastIndexOf("<br></br>"));
			throw new BusinessException(msg);
		}
		
		if(VTools.StringIsEmpty(user.getId())){
			
			user.setId(null);
			user.setPassword(VTools.getMD5("111111"));//默认新增的用户名密码
		}
		
		userDao.saveOrUpdate(user);
		userDao.deleteUserRoleByUserId(user.getId());//先删除用户角色关联，后添加关联
		if(!VTools.StringIsEmpty(roleIds)){
			
			String[] rIds = roleIds.split(",");
			UserRole userRole;
			for(int i = 0;i<rIds.length;i++){
				
				userRole = new UserRole();
				userRole.setRoleId(rIds[i]);
				userRole.setUserId(user.getId());
				userRole.setUpdateTime(VTools.getTimeNow(System_Constants.TIMEFORMAT_YMDHMS));
				userDao.saveUserRole(userRole);
			}
		}
	}
	
	/**
	 * 删除
	 * @param ids
	 */
	public void delete(String[] ids){
		
		for(String id:ids){
			
			userDao.delete(id);
		}
	}
	
	/**
	 * 获取用户分页数据
	 * @param page
	 * @return
	 */
	public Page getUserPage(Page page,User user){
		
		return userDao.queryUserPage(page,user);
	}
	
	/**
	 * 获取角色数据
	 * @return
	 */
	public List<Role> getRole(String queryText,String queryValue){
		
		if(!VTools.StringIsEmpty(queryValue)){
			
			String[] ids = queryValue.split(",");
			return userDao.queryRolePathByIds(ids);
		}
		if(!VTools.StringIsEmpty(queryText)&&!VTools.StringIsEmpty(queryText.trim())){
			
			String[] names = queryText.trim().split(",");
			return userDao.queryRolePathByNames(names);
		}
		 
		return userDao.queryRole();
	}
}
