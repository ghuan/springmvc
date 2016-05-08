package com.fanfan.system.dao.imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fanfan.system.core.hibernate.Page;
import com.fanfan.system.dao.IUserDao;
import com.fanfan.system.entity.Role;
import com.fanfan.system.entity.User;
import com.fanfan.system.entity.UserRole;
import com.fanfan.system.util.VTools;
import com.fanfan.system.util.constants.Org_Constants;

/**
 * 
* Copy right huan.gao 2015
* All right reserved
* QQ:2223486623 
* description：用户Dao
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl implements IUserDao{
	
	/**
	 * 保存
	 * @param user
	 */
	public void save(User user){
		
		super.save(user);
	}
	
	/**
	 * 保存或更新
	 * @param user
	 */
	public void saveOrUpdate(User user){
		
		super.saveOrUpdate(user);
	}
	
	/**
	 * 删除
	 * @param user
	 */
	public void delete(String id){
		
		super.executeHql("delete from User where id = ?0", id);
	}
	
	/**
	 * 分页查询用户数据
	 * @param page
	 * @return
	 */
	public Page queryUserPage(Page page,User user){
		String sql = "select * from (";
		sql += " select t.id,t.name,t.stuempno,t.idcard,t.loginname"
				+ " ,t.password,t.sex,t.orgid,t.mobile,t.home_phone,t.office_phone"
				+ " ,t.home_address,t.professional,t.email,t.image,t.state"
				+ " ,t.createtime,t.rank,t.lastip,t.lasttime,t2.name creator,o.name orgName"
				+ " ,listagg(r.name,',') within GROUP (order by t.rank) roleNames"
				+ " ,listagg(r.id,',') within GROUP (order by t.rank) roleIds"
				+ " from t_sys_user t"
				+ " left join t_sys_user t2 on t2.id = t.creator"
				+ " left join t_sys_org o on o.id = t.orgid"
				+ " left join t_sys_user_role ur on ur.userid = t.id"
				+ " left join t_sys_role r on r.id = ur.roleid"
				+ " where 1 = 1";
		//查询条件组装sql
		if(!VTools.StringIsEmpty(user.getName())){
			
			sql += " and t.name like '%"+user.getName().trim()+"%'";
		}
		if(!VTools.StringIsEmpty(user.getOrgId()) && !Org_Constants.ROOT_DIRECTORY_PID.equals(user.getOrgId())){
			
			sql += " and t.orgid = '"+user.getOrgId()+"'";
		}
		if(!VTools.StringIsEmpty(user.getStuempNo())){
			
			sql += " and t.stuempno = '"+user.getStuempNo().trim()+"'";
		}
		if(!(user.getSex() == null)){
			
			sql += " and t.sex = "+user.getSex();
		}
		sql += " group by t.id,t.name,t.stuempno,t.idcard,t.loginname"
				+ ",t.password,t.sex,t.orgid,t.mobile,t.home_phone"
				+ ",t.office_phone,t.home_address,t.professional,t.email"
				+ ",t.image,t.state,t.createtime,t.rank,t.lastip,t.lasttime,t2.name,o.name";
		sql += ") order by rank";
		return super.queryPageBySql(page, User.class, sql, new Object[0]);
	}
	
	/**
	 * 查询用户(用于保存用户信息时检验学工号stuempno，登陆名loginname,身份证号IDcard是否已存在)
	 * @param user(保存的用户信息)
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List checkSaveOrUpdateUser(User user){
		
		String sql = "";
		
		if(!VTools.StringIsEmpty(user.getId())){//如果是修改用户
			
			if(!VTools.StringIsEmpty(user.getStuempNo())){
				
				sql += " select '学工号["+user.getStuempNo().trim()+"]已存在！' msg from t_sys_user where id <> '"+user.getId()+"'";
				sql += " and stuempNo = '"+user.getStuempNo().trim()+"'";
				sql += " union all";
				
			}
			if(!VTools.StringIsEmpty(user.getLoginName())){
				
				sql += " select '登陆名["+user.getLoginName().trim()+"]已存在！' msg from t_sys_user where id <> '"+user.getId()+"'";
				sql += " and loginname = '"+user.getLoginName().trim()+"'";
				sql += " union all";
			}
			if(!VTools.StringIsEmpty(user.getIdCard())){
				
				sql += " select '身份证号["+user.getIdCard().trim()+"]已存在！' msg from t_sys_user where id <> '"+user.getId()+"'";
				sql += " and idcard = '"+user.getIdCard().trim()+"'";
				sql += " union all";
			}
			
		}else {
			
			if(!VTools.StringIsEmpty(user.getStuempNo())){
				
				sql += " select '学工号["+user.getStuempNo().trim()+"]已存在！' msg from t_sys_user where 1 = 1";
				sql += " and stuempNo = '"+user.getStuempNo().trim()+"'";
				sql += " union all";
				
			}
			if(!VTools.StringIsEmpty(user.getLoginName())){
				
				sql += " select '登陆名["+user.getLoginName().trim()+"]已存在！' msg from t_sys_user where 1 = 1";
				sql += " and loginname = '"+user.getLoginName().trim()+"'";
				sql += " union all";
			}
			if(!VTools.StringIsEmpty(user.getIdCard())){
				
				sql += " select '身份证号["+user.getIdCard().trim()+"]已存在！' msg from t_sys_user where 1 = 1";
				sql += " and idcard = '"+user.getIdCard().trim()+"'";
				sql += " union all";
			}
		}
		
		sql = sql.substring(0,sql.lastIndexOf("union all"));
		return super.queryListMapBySql(sql, new Object[0]);
	}
	
	/**
	 * 查询角色
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Role> queryRole(){
		
		String sql = "select id,name,rank,listagg(orgName,',') within GROUP (order by orgName) orgNames from ";
		sql += " (select t.name,t.id,t.rank,o.name orgName from t_sys_role t left join t_sys_org_role orl on orl.roleid = t.id left join t_sys_org o on o.id = orl.orgid order by t.rank)  ";
		sql += " group by id,name,rank order by rank";
		return super.queryListBeanBySql(Role.class, sql, new Object[0]);
	}
	
	/**
	 * 根据name查询角色路径
	 * @param name
	 * @return List<Org>
	 */
	@SuppressWarnings("unchecked")
	public List<Role> queryRolePathByNames(String[] names){
		
		String sql = "select t.*,'/' || t.name pathName,'/' || t.id path from t_sys_role t where 1 = 1";
		sql += " and (";
		String sb = "";
		for(String name :names){
			
			sb += " t.name like '%"+name+"%' or";
		}
		sb = sb.substring(0,sb.lastIndexOf("or"));
		sql += sb + ")";
		sql += " order by t.rank";
		return super.queryListBeanBySql(Role.class, sql, new Object[0]);
	}
	
	/**
	 * 根据ids查询角色路径
	 * @param ids
	 * @return List<Org>
	 */
	@SuppressWarnings("unchecked")
	public List<Role> queryRolePathByIds(String[] ids){
		
		String sql = "select t.*,'/' || t.name pathName,'/' || t.id path from t_sys_role t where 1 = 1";
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
		sql += " and t.id in(" + sb + ")";
		sql += " order by t.rank";
		return super.queryListBeanBySql(Role.class, sql, new Object[0]);
	}
	
	/**
	 * 删除用户角色关联
	 * @param userId
	 */
	public void deleteUserRoleByUserId(String userId){
		
		String hql = "delete from UserRole where userId = ?0";
		super.executeHql(hql, userId);
	}
	
	/**
	 * 保存用户角色关联
	 * @param userRole
	 */
	public void saveUserRole(UserRole userRole){
		
		super.save(userRole);
	}
	
}
