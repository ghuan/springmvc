package com.fanfan.system.dao.imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fanfan.system.dao.ISystemDao;
import com.fanfan.system.entity.Dict;
import com.fanfan.system.entity.Menu;
import com.fanfan.system.entity.Org;
import com.fanfan.system.entity.Role;
import com.fanfan.system.entity.User;
import com.fanfan.system.entity.UserExt;
import com.fanfan.system.util.VTools;
import com.fanfan.system.util.constants.Menu_Constants;
import com.fanfan.system.util.constants.User_Constants;
import com.fanfan.system.vo.LoginInfo;

/**
 * 
* Copy right huan.gao 2015
* All right reserved
* QQ:2223486623 
* description：管理Dao
 */
@Repository
public class SystemDaoImpl extends BaseDaoImpl implements ISystemDao{
	
	/**
	 * 保存
	 * @param role
	 */
	public void save(Org org){
		
		super.save(org);
	}
	
	/**
	 * 获取用户菜单 by roles
	 * @param loginInfo
	 * @param pid
	 * @param subsystemid
	 * @param mng
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Menu> queryMenusByRoles(LoginInfo loginInfo, String pid, String subsystemid, String mng)
	  {
	    List menus = null;

	    StringBuffer sql = new StringBuffer("SELECT T FROM Menu T WHERE EXISTS(");
	    sql.append(" SELECT 1 FROM RoleMenu M WHERE T.id = M.menuId AND M.roleId IN( ");
	    sql.append(loginInfo.getRoleString());
	    sql.append("))");

	    if (Menu_Constants.ROOT_DIRECTORY_PID.equals(pid))
	    {
	      if (User_Constants.ADMIN_ID.equals(loginInfo.getUser().getId()))
	      {
	        if (User_Constants.CHECK_TRUE.equals(mng))
	        {
	          String sql1 = "FROM Menu WHERE pid=?0 ORDER BY rank";
	          menus = super.queryList(sql1, new Object[]{pid});
	        }
	        else if (!VTools.StringIsEmpty(subsystemid))
	        {
	          String sql1 = "FROM Menu WHERE id=?0 ORDER BY rank";
	          menus = super.queryList(sql1, new Object[] { subsystemid });
	        }
	        else {
	          String sql1 = "FROM Menu WHERE pid=?0 ORDER BY rank";
	          menus = super.queryList(sql1, new Object[]{pid});
	        }

	      }
	        else if (!VTools.StringIsEmpty(subsystemid))
	      {
	        String sql1 = "FROM Menu WHERE id=?0 ORDER BY rank";
	        menus = super.queryList(sql1, new Object[] { subsystemid });
	      }
	      else
	      {
	        sql.append(" AND pid=?0 ORDER BY rank");
	        menus = super.queryList(sql.toString(), new Object[]{pid});
	      }

	    }
	    else if (User_Constants.ADMIN_ID.equals(loginInfo.getUser().getId()))
	    {
	      menus = queryAdminMenus(pid, mng);
	    }
	    else {
	      sql.append(" AND pid=?0 ORDER BY rank");
	      menus = super.queryList(sql.toString(),  new Object[] { pid });
	    }

	    return menus;
	  }
	
	
	/**
	 * 查询系统管理员菜单
	 * @param pid
	 * @param mng
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Menu> queryAdminMenus(String pid, String mng)
	  {
	    String sql = null;
	    if (User_Constants.CHECK_TRUE.equals(mng))
	    {
	      sql = "SELECT T (SELECT COUNT(N.id) FROM Menu N WHERE N.pid=T.id) SUBNODES FROM Menu T WHERE T.pid=?0 ORDER BY T.rank";
	    }
	    else {
	      sql = "SELECT T FROM Menu T WHERE T.pid=?0 ORDER BY T.rank";
	    }
	    List menus = super.queryList(sql,  new Object[] { pid });

	    return menus;
	  }
	
	/**
	 * 根据userid查询用户菜单信息
	 * @param userid
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Menu> queryUserMenuByUserid(String userid)
	  {
	    StringBuffer hql = new StringBuffer("FROM Menu M");
	    hql.append(" WHERE EXISTS(SELECT 1 FROM RoleMenu R WHERE M.id = R.menuId");
	    hql.append(" AND EXISTS(SELECT 1 FROM UserRole UR WHERE R.roleId = UR.roleId AND UR.userId=?0)) AND M.type=?1 AND M.state=?2 ORDER BY M.rank");
	    List menus = super.queryList(hql.toString(), new Object[] { userid,Integer.parseInt(Menu_Constants.TYPE_SUBSYSTEM),Integer.parseInt(Menu_Constants.STATE_OPEN)});
	    return menus;
	  }
	
	/**
	 * 获取用户组织部门信息
	 * @param user
	 * @return T_SYS_ORG
	 */
	public Org queryUserOrg(User user)
	  {
	    String hql = "FROM Org WHERE id = (SELECT orgId FROM User WHERE id=?0)";
	    return (Org)super.queryObject(hql, new Object[] { user.getId() });
	    
	  }
	
	/**
	 * 获取所有权限
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Role> getRoles()
	  {
	    String sql = "FROM Role ORDER BY rank";
	    List roles = super.queryList(sql, new Object[0]);
	    return roles;
	  }
	
	
	/**
	 * 根据userid查询用户权限
	 * @param userid
	 * @return
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Role> queryUserRoleByUserid(String userid)
	  {
		String hql = "select r from Role r,UserRole ur where ur.roleId = r.id and ur.userId = ?0 order by r.rank";
	    List roles = super.queryList(hql, userid);
	    return roles;
	  }
	 
	 /**
	 * 根据loginname获取user
	 * @param user
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public User getUser(User user){
		
		//登录名=loginname
	    String hql = "FROM User WHERE state=1 AND loginName=?0";
	    List<User> users = super.queryList(hql, new Object[] { user.getLoginName() });
	    if (VTools.ListIsEmpty(users))
	    {
	      //工号=loginname
	      hql = "FROM User WHERE state=1 AND stuempNo=?0";
	      users = super.queryList(hql, new Object[] { user.getLoginName() });
	      if (VTools.ListIsEmpty(users))
	      {
	    	//编号=loginname
	        hql = "FROM User WHERE state=1 AND idCard=?0";
	        users = super.queryList(hql, new Object[] { user.getLoginName() });
	      }
	    }
	    
	    User resultuser = new User();
	    if(!VTools.ListIsEmpty(users)){
	    	
	    	resultuser = users.get(0);
	    }
	    return resultuser;
	}
	
	
	/**
	 * 获取用户扩展信息
	 * @param userid
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<UserExt> queryUserExt(User user)
	  {
	    String hql = "FROM UserExt WHERE userId=?0 ORDER BY rank";
	    List list = super.queryList(hql, new Object[] { user.getId() });
	    return list;
	  }
	
	
	/**
	 * 根据路径查询字典
	 * @param 
	 * @return
	 */
	public Dict getDictByPath(String path){
		
		Object[] dataids = path.split("/");
		String hql = "FROM Dict WHERE dataId = ?"+(dataids.length-1);
		String kh = "";
		for(int i=dataids.length-2;i>=0;i--){
			
			hql+=" AND pid = (SELECT id FROM Dict WHERE dataId = ?"+i;
			kh+=")";
		}
		hql+=kh;
		return (Dict)super.queryObject(hql, dataids);
	}
	
	/**
	 * 根据路径查询字典
	 * @param 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Dict> getDictListByPath(String path){
		
		Object[] dataids = path.split("/");
		String hql = "FROM Dict WHERE 1 = 1 ";
		String kh = "";
		for(int i=dataids.length-1;i>=0;i--){
			
			hql+=" AND pid = (SELECT id FROM Dict WHERE dataId = ?"+i;
			kh+=")";
		}
		hql+=kh;
		return (List<Dict>)super.queryList(hql, dataids);
	}
	
	/**
	 * 修改用户信息
	 * @param user
	 */
	public void updateUser(User user){
		
		super.update(user);
	}
	
	/**
	 * 验证用户权限
	 * @param authPath
	 * @return
	 */
	public boolean checkAuth(String authPath,String userId){
		
		StringBuffer sql = new StringBuffer("SELECT * FROM (SELECT SYS_CONNECT_BY_PATH(T.NAME, '.') PATH FROM (");
	    sql.append("SELECT * FROM T_SYS_MENU WHERE ID IN(");
	    sql.append("SELECT MENUID FROM T_SYS_ROLE_MENU WHERE ROLEID IN(");
	    sql.append("SELECT ROLEID FROM T_SYS_USER_ROLE WHERE USERID=?0");
	    sql.append("))) T START WITH T.PID = '"+Menu_Constants.ROOT_DIRECTORY_PID+"' CONNECT BY PRIOR T.ID = T.PID) AT WHERE AT.PATH=?1");
	    int num = super.countSql(sql.toString(), new Object[]{userId,"."+authPath});
	    return num == 1 ? true : false;
	}
}
