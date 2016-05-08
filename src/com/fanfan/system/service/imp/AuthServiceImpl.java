package com.fanfan.system.service.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fanfan.system.core.exception.BusinessException;
import com.fanfan.system.core.hibernate.Page;
import com.fanfan.system.dao.IAuthDao;
import com.fanfan.system.entity.OrgRole;
import com.fanfan.system.entity.Role;
import com.fanfan.system.entity.RoleMenu;
import com.fanfan.system.entity.User;
import com.fanfan.system.entity.UserRole;
import com.fanfan.system.service.IAuthService;
import com.fanfan.system.util.VTools;
import com.fanfan.system.util.constants.Menu_Constants;
import com.fanfan.system.util.constants.System_Constants;
import com.fanfan.system.vo.MenuChecked;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
* Copy right huan.gao 2015
* All right reserved
* QQ:2223486623 
* description：	角色权限管理service
 */
@Service
@Transactional //异常回滚
public class AuthServiceImpl implements IAuthService{

	protected static final Log _log = LogFactory.getLog(AuthServiceImpl.class);
	
	@Autowired
	private IAuthDao authDao;
	
	/**
	 * 获取角色分页数据
	 * @return
	 */
	public Page getRole(Page page,Role role,String roleIds){
		
		if(VTools.StringIsEmpty(roleIds)){
			
			return authDao.queryRole(page,role,null);
		}else {
			
			String[] ids = roleIds.split(",");
			return authDao.queryRole(page,role,ids);
		}
	}
	
	/**
	 * 获取菜单权限数据
	 * @param pid
	 * @param roleId
	 * @return
	 */
	public List<MenuChecked> getAuth(String pid,String roleId){
		
		if (VTools.StringIsEmpty(roleId))
	    {
			_log.error("权限查询必须指定角色。");
			throw new BusinessException("权限查询必须指定角色。");
	    }

	    if (VTools.StringIsEmpty(pid))
	    {
	    	pid = Menu_Constants.ROOT_DIRECTORY_PID;
	    }
	    return authDao.queryAuth(pid, roleId);
	}
	
	/**
	 * 保存角色菜单权限
	 * @param auths
	 * @param roleId
	 */
	public void saveAuth(String auths,String roleId){
		
		_log.info("开始保存角色权限。");
		if(VTools.StringIsEmpty(roleId)){
			
			_log.error("保存系统权限时，角色不能为空。");
			throw new BusinessException("保存系统权限时，角色不能为空。");
		}
		if(VTools.StringIsEmpty(auths)){
			
			_log.error("保存系统权限时，权限菜单不能为空。");
			throw new BusinessException("保存系统权限时，权限菜单不能为空。");
		}
		JSONArray ja = JSONArray.fromObject(auths);
		String updateTime = VTools.getTimeNow(System_Constants.TIMEFORMAT_YMDHMS);
		for(int i=0;i<ja.size();i++){
			
			JSONObject jo = ja.getJSONObject(i);
	        String id = jo.getString("id");
	        boolean check = jo.getBoolean("check");
	        if(check){
	        	
	        	int num = authDao.queryAuthCount(id, roleId);
	        	if(num > 0){
	        		
	        		continue;
	        	}
	        	RoleMenu roleMenu = new RoleMenu();
	        	roleMenu.setMenuId(id);
	        	roleMenu.setRoleId(roleId);
	        	roleMenu.setUpdateTime(updateTime);
	        	authDao.saveAuth(roleMenu);
	        }else {
	        	
	        	authDao.deleteAuth(id, roleId);
	        }
		}
	}
	
	/**
	 * 保存或更新系统角色
	 * @param role
	 */
	public void saveOrUpdateRole(Role role){
		
		//后台获取前台空字段是空字符串，所以这里需要转为null
		if(VTools.StringIsEmpty(role.getId())){
			
			role.setId(null);
		}
		authDao.saveOrUpdateRole(role);
		if(!VTools.StringIsEmpty(role.getOrgIds())){
			
			if(!VTools.StringIsEmpty(role.getId())){
				
				authDao.delOrgRoleByRoleId(role.getId());
			}
			String[] orgIds = role.getOrgIds().split(",");
			String updateTime = VTools.getTimeNow(System_Constants.TIMEFORMAT_YMDHMS);
			for(String orgId : orgIds){
				
				OrgRole orgRole = new OrgRole();
				orgRole.setOrgId(orgId);
				orgRole.setRoleId(role.getId());
				orgRole.setUpdateTime(updateTime);
				authDao.saveOrgRole(orgRole);
			}
		}
	}
	
	/**
	 * 删除角色
	 * @param roleIds
	 */
	public void delRole(String[] roleIds){
		
		for(String roleId:roleIds){
			
			authDao.delRole(roleId);//删除系统角色
			authDao.deleteAuth(null, roleId);//删除角色菜单权限
			authDao.delOrgRoleByRoleId(roleId);//删除组织角色关系
			authDao.delUserRoleByRoleId(roleId);//删除用户角色关系
		}
	}
	
	/**
	 * 获取某个角色下的用户数据
	 * @param roleId
	 * @return
	 */
	public List<User> getUserRole(String roleId){
		
		return authDao.queryUserRole(roleId);
	}
	
	/**
	 * 保存用户与角色的关联
	 * @param roleId
	 * @param userIds
	 */
	public void saveUserRole(String roleId,String[] userIds){
		
		if(!VTools.ArrayIsNullOrEmpty(userIds)){
			String updateTime = VTools.getTimeNow(System_Constants.TIMEFORMAT_YMDHMS);
			authDao.delUserRoleByRoleId(roleId);//先删除原有的用户角色关联
			for(String userId : userIds){
				
				UserRole userRole = new UserRole();
				userRole.setRoleId(roleId);
				userRole.setUserId(userId);
				userRole.setUpdateTime(updateTime);
				authDao.saveUserRole(userRole);
			}
		}
		
	}
	
}
