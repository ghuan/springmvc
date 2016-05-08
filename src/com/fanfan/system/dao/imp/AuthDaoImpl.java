package com.fanfan.system.dao.imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fanfan.system.core.hibernate.Page;
import com.fanfan.system.dao.IAuthDao;
import com.fanfan.system.entity.OrgRole;
import com.fanfan.system.entity.Role;
import com.fanfan.system.entity.RoleMenu;
import com.fanfan.system.entity.User;
import com.fanfan.system.entity.UserRole;
import com.fanfan.system.util.VTools;
import com.fanfan.system.vo.MenuChecked;

/**
 * 
* Copy right huan.gao 2015
* All right reserved
* QQ:2223486623 
* description：角色权限管理Dao
 */
@Repository
public class AuthDaoImpl extends BaseDaoImpl implements IAuthDao{
	
	/**
	 * 查询角色
	 * @return
	 */
	public Page queryRole(Page page,Role role,String[] ids){
		String sql = "select * from (";
		sql += "select id,name,rank,remark,listagg(orgId,',') within GROUP (order by orgId) orgIds,listagg(orgName,',') within GROUP (order by orgName) orgNames from ";
		sql += " (select t.name,t.id,t.rank,t.remark,o.id orgId,o.name orgName from t_sys_role t left join t_sys_org_role orl on orl.roleid = t.id left join t_sys_org o on o.id = orl.orgid order by t.rank)  ";
		sql += " group by id,name,rank,remark";
		sql += " ) where 1 = 1 ";
		if(!VTools.StringIsEmpty(role.getOrgIds())){
			
			sql += " and instr(orgIds,'"+role.getOrgIds()+"') > 0 ";
		}
		if(!VTools.StringIsEmpty(role.getName())){
			
			sql += " and name like '%"+role.getName().trim()+"%' ";
		}
		if(!VTools.ArrayIsNullOrEmpty(ids)){
			
			StringBuffer sb = new StringBuffer();
			for (String id : ids) {
				if (VTools.StringIsEmpty(id)) {
					continue;
				}
				sb.append("'");
				sb.append(id);
				sb.append("',");
			}

			if (sb.length() > 0) {
				sb.deleteCharAt(sb.length() - 1);
			}
			sql += " and id in(" + sb + ")";
		}
		sql += " order by rank";
		return super.queryPageBySql(page, Role.class, sql, new Object[0]);
	}
	
	/**
	 * 查询菜单权限数据
	 * @param pid
	 * @param roleId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<MenuChecked> queryAuth(String pid,String roleId){
		
		StringBuffer sql = new StringBuffer("SELECT M.*,RM.ID AS CHECKS,(SELECT COUNT(N.ID) FROM T_SYS_MENU N WHERE N.PID=M.ID) AS SUBNODES FROM T_SYS_MENU M LEFT JOIN T_SYS_ROLE_MENU RM ON M.ID = RM.MENUID AND RM.ROLEID ='");
	    sql.append(roleId);
	    sql.append("'");
	    sql.append(" WHERE M.PID ='");
	    sql.append(pid);
	    sql.append("'");
	    sql.append(" ORDER BY M.RANK");
	    return super.queryListBeanBySql(MenuChecked.class, sql.toString(), new Object[0]);
	}
	
	/**
	 * 保存角色菜单权限
	 * @param roleMenu
	 */
	public void saveAuth(RoleMenu roleMenu){
		
		super.save(roleMenu);
	}
	
	/**
	 * 统计角色菜单权限数
	 * @param id
	 * @param roleId
	 * @return
	 */
	public int queryAuthCount(String menuId,String roleId){
		
		return super.count("from RoleMenu where menuId = ?0 and roleId = ?1", new Object[]{menuId,roleId});
	}
	
	/**
	 * 删除角色菜单权限
	 * @param menuId
	 * @param roleId
	 */
	public void deleteAuth(String menuId,String roleId){
		
		if(VTools.StringIsEmpty(menuId)){
			
			super.executeHql("delete from RoleMenu where roleId = ?0", new Object[]{roleId});
		}else {
			
			super.executeHql("delete from RoleMenu where menuId = ?0 and roleId = ?1", new Object[]{menuId,roleId});
		}
	}
	
	/**
	 * 保存或更新系统角色
	 * @param role
	 */
	public void saveOrUpdateRole(Role role){
		
		super.saveOrUpdate(role);
	}
	
	/**
	 * 保存角色组织关系
	 * @param role
	 */
	public void saveOrgRole(OrgRole orgRole){
		
		super.save(orgRole);
	}
	
	/**
	 * 删除角色组织关系
	 * @param orgRole
	 */
	public void delOrgRoleByRoleId(String roleId){
		
		super.executeHql("delete from OrgRole where roleId = ?0", new Object[]{roleId});
	}
	
	/**
	 * 删除系统角色
	 * @param roleId
	 */
	public void delRole(String roleId){
		
		super.executeHql("delete from Role where id = ?0", new Object[]{roleId});
	}
	
	/**
	 * 删除系统角色与用户关系
	 * @param roleId
	 */
	public void delUserRoleByRoleId(String roleId){
		
		super.executeHql("delete from UserRole where roleId = ?0", new Object[]{roleId});
	}
	
	/**
	 * 查询某个角色下的用户数据
	 * @param roleId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<User> queryUserRole(String roleId){
		
		String sql = "SELECT U.*,ORG.NAME orgName FROM T_SYS_USER U LEFT JOIN T_SYS_USER_ROLE UR ON U.ID = UR.USERID LEFT JOIN T_SYS_ORG ORG ON ORG.ID = U.ORGID WHERE UR.ROLEID =?0 ORDER BY U.RANK";
		return super.queryListBeanBySql(User.class, sql, new Object[]{roleId});
	}
	
	/**
	 * 保存用户与角色的关联
	 * @param userRole
	 */
	public void saveUserRole(UserRole userRole){
		
		super.save(userRole);
	}
}
