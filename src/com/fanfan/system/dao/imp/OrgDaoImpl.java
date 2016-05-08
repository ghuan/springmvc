package com.fanfan.system.dao.imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fanfan.system.dao.IOrgDao;
import com.fanfan.system.entity.Org;
import com.fanfan.system.util.VTools;

/**
 * 
* Copy right huan.gao 2015
* All right reserved
* QQ:2223486623 
* description：组织部门Dao
 */
@Repository
public class OrgDaoImpl extends BaseDaoImpl implements IOrgDao{
	
	/**
	 * 保存
	 * @param role
	 */
	public void saveOrUpdate(Org org){
		
		super.saveOrUpdate(org);
	}
	
	/**
	 * 删除
	 * @param id
	 */
	public void delete(String id){
		
		super.executeHql("delete from Org where id = ?0", id);
	}
	
	/**
	 * 查询组织部门数据
	 * @param pid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Org> queryOrgByPid(String pid){
		
	    String hql = "select o from Org o where o.pid = ?0 order by o.rank";
	    return super.queryList(hql, pid);
	    
	}
	
	/**
	 * 查询组织部门数据
	 * @param id
	 * @return
	 */
	public Org queryOrgById(String id){
		
		String hql = "select o from Org o where o.id = ?0 order by o.rank";
		return (Org) super.queryObject(hql, id);
	}
	
	/**
	 * 根据name查询组织部门路径
	 * @param name
	 * @return list
	 */
	@SuppressWarnings("rawtypes")
	public List queryOrgPathByName(String name){
		
		StringBuffer sql = new StringBuffer("SELECT * FROM (");
		sql.append("SELECT T.*, SYS_CONNECT_BY_PATH(T.ID, '/') PATH, SYS_CONNECT_BY_PATH(T.NAME, '/') PATHNAME FROM T_SYS_ORG T");
		sql.append(" START WITH T.PID = 'root'");
		sql.append(" CONNECT BY PRIOR T.ID = T.PID");
		sql.append(") ORG WHERE 1=1 ");
		sql.append(" AND ORG.NAME LIKE '%");
		sql.append(name);
		sql.append("%'");
		sql.append(" ORDER BY ORG.TYPE, ORG.RANK");

		return super.queryListBeanBySql(Org.class,sql.toString(), new Object[0]);
	}
	
	/**
	 * 根据ids查询组织部门路径
	 * @param ids
	 * @return list
	 */
	@SuppressWarnings("rawtypes")
	public List queryOrgPathByIds(String[] ids){
		
		StringBuffer sql = new StringBuffer("SELECT * FROM (");
		sql.append("SELECT T.*, SYS_CONNECT_BY_PATH(T.ID, '/') PATH, SYS_CONNECT_BY_PATH(T.NAME, '/') PATHNAME FROM T_SYS_ORG T");
		sql.append(" START WITH T.PID = 'root'");
		sql.append(" CONNECT BY PRIOR T.ID = T.PID");
		sql.append(") ORG WHERE 1=1 ");
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

		sql.append(" AND ORG.ID IN(");
		sql.append(sb);
		sql.append(")");
		sql.append(" ORDER BY ORG.TYPE, ORG.RANK");

		return super.queryListBeanBySql(Org.class,sql.toString(), new Object[0]);
	}
}
