
package com.fanfan.system.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.internal.BasicFormatterImpl;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.jdbc.Work;
import org.hibernate.service.jdbc.connections.spi.ConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fanfan.system.core.exception.BusinessException;
import com.fanfan.system.core.hibernate.Page;
import com.fanfan.system.dao.IBaseDao;
import com.fanfan.system.util.VTools;

import net.sf.json.JSONArray;

/**
 * 
* Copy right huan.gao 2015-7-9下午10:07:25
* All right reserved
* QQ:2223486623 
* description：通用数据操作dao
 */
@Repository
public class BaseDaoImpl implements IBaseDao {
	
	protected static final Log _log = LogFactory.getLog(BaseDaoImpl.class);
	@Autowired
	protected SessionFactory sessionFactory;	
	/**
	 * 取得当前Session.
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(Object entity){
		
		getSession().save(entity);
	}
	
	
	/**
	 * 保存或更新
	 * @param entity
	 */
	public void saveOrUpdate(Object entity){
		
		getSession().saveOrUpdate(entity);
	}
	
	
	
	/**
	 * 删除
	 * @param entity
	 */
	public void delete(Object entity){
		
		getSession().delete(entity);
	}
	
	
	/**
	 * 更新
	 * @param entity
	 */
	public void update(Object entity){
		
		getSession().update(entity);
	}
	
	
	/**
	 * 查询
	 * Query是由Hibernate封装好的session中得到的，所以不能按JPA的那种来写占位符
	 * (如：xxx.createQuery("from User u where u.name =?").setParamter(0,"line");是不建议的)
	 * @param hql
	 * @param params
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List queryList(String hql,Object... params){
		
		Query query = getSession().createQuery(hql);
		if(params!=null && params.length!=0){
			//System.out.println("参数："+JSONArray.fromObject(params));
			for(int i=0;i<params.length;i++){
				
				query.setParameter(""+i, params[i]);
			}
			//System.out.flush();
		}
		return query.list();
	}
	
	/**
	 * 查询
	 * @param hql
	 * @param params
	 * @return Object
	 */
	public Object queryObject(String hql,Object... params){
		
		Query query = getSession().createQuery(hql);
		if(params!=null && params.length!=0){
//			System.out.println("参数："+JSONArray.fromObject(params));
			for(int i=0;i<params.length;i++){
				
				query.setParameter(""+i, params[i]);
			}
//			System.out.flush();
		}
		return query.uniqueResult();
	}
	
	/**
	 * 查询
	 * @param sql
	 * @param params
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List queryListObjectBySql(String sql,Object... params){
		
		Query query = getSession().createSQLQuery(sql);
		if(params!=null && params.length!=0){
//			System.out.println("参数："+JSONArray.fromObject(params));
			for(int i=0;i<params.length;i++){
				
				query.setParameter(""+i, params[i]);
			}
//			System.out.flush();
		}
		return query.list();
	}
	
	/**
	 * 查询 
	 * @param sql
	 * @param params
	 * @return List<entity>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List queryListBeanBySql(Class c,String sql,Object... params){
		
		List list = queryListMapBySql(sql,params);
		return VTools.getListBeanFromSqlListMap(c, list, true);
	}
	
	/**
	 * 查询
	 * @param sql
	 * @param params
	 * @return Object
	 */
	public Object queryObjectBySql(String sql,Object... params){
		
		Query query = getSession().createSQLQuery(sql);
		if(params!=null && params.length!=0){
//			System.out.println("参数："+JSONArray.fromObject(params));
			for(int i=0;i<params.length;i++){
				
				query.setParameter(""+i, params[i]);
			}
//			System.out.flush();
		}
		return query.uniqueResult();
	}
	
	/**
	 * 查询一个bean，如果查询到多条，则默认取最后一条
	 * @param sql
	 * @param params
	 * @return Object
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object queryBeanBySql(Class clazz,String sql,Object... params){
		
		List list = VTools.getListBeanFromSqlListMap(clazz, queryListMapBySql(sql,params), true);
		return list.get(list.size()-1);
	}
	
	
	/**
	 * 执行普通sql 返回执行条数
	 * @param sql
	 * @param values
	 * @return
	 */
	public int executeSql(String sql, Object... params) {
		Query query = getSession().createSQLQuery(sql);
		if (params != null) {
//			System.out.println("参数："+JSONArray.fromObject(params));
			for (int i = 0; i < params.length; i++) {
				query.setParameter(""+i, params[i]);
			}
//			System.out.flush();
		}
		return query.executeUpdate();
	}
	
	/**
	 * 执行hql 返回执行条数
	 * @param hql
	 * @param params
	 * @return
	 */
	public int executeHql(String hql,Object... params){
		
		Query query = getSession().createQuery(hql);
		if(params!=null && params.length!=0){
//			System.out.println("参数："+JSONArray.fromObject(params));
			for(int i=0;i<params.length;i++){
				
				query.setParameter(""+i, params[i]);
			}
//			System.out.flush();
		}
		return query.executeUpdate();
	}
	
	/**
	 * 查询普通sql，返回List<Map<String,Object>>
	 * @param sql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List queryListMapBySql(final String sql,final Object ...params){
		
		final List list = new ArrayList();
		
		try {
			Work work = new Work() {
				@SuppressWarnings("unchecked")
				public void execute(Connection con) throws SQLException {
					
					String querySql = sql;
					//将?0这种占位符替换为传统占位符
					for(int i=0;i<10000;i++){
						
						if(sql.indexOf("?"+i)==-1){
							
							break;
						}
						querySql = sql.replace("?"+i, "?");
					}
					PreparedStatement ps = con.prepareStatement(querySql);
					if(params!=null && params.length!=0){
						
						//System.out.println("参数："+JSONArray.fromObject(params));
						for(int i=0;i<params.length;i++){
							
							ps.setObject(i+1, params[i]);
						}
						//System.out.flush();
					}
//					System.out.println("hibernate:");
//					System.out.println(new BasicFormatterImpl().format(sql));
//					System.out.flush();
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						Map<String,Object> map = new HashMap<String,Object>();
						ResultSetMetaData data = rs.getMetaData();
						for(int i = 1; i < (data.getColumnCount()+1); i++) {
							String name = data.getColumnName(i);
							Object o = rs.getObject(name);
							map.put(name.toLowerCase(), o);
						}
						list.add(map);
					}
					rs.close();
					ps.close();
						
				}
			};
			getSession().doWork(work);
		} catch(Exception e) {
			throw new BusinessException(e.getMessage());
		}
		return list;
	}
	
	/**
	 * 查询普通sql，返回List<Map<String,Object>>
	 * 由数据库限制连接数，在频繁操作数据库的情况下尽量少用，比如导入
	 * @param sql
	 * @param params
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public List queryListMapBySql2(String sql,Object ...params){
		
		List list = new ArrayList();
		ConnectionProvider cp = ((SessionFactoryImplementor)sessionFactory).getConnectionProvider();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection connection = cp.getConnection();
			
			//将?0这种占位符替换为传统占位符
			for(int i=0;i<10000;i++){
				
				if(sql.indexOf("?"+i)==-1){
					
					break;
				}
				sql = sql.replace("?"+i, "?");
			}
			ps = connection.prepareStatement(sql);
			if(params!=null && params.length!=0){
				//System.out.println("参数："+JSONArray.fromObject(params));
				for(int i=0;i<params.length;i++){
					
					ps.setObject(i+1, params[i]);
				}
				//System.out.flush();
			}
//			System.out.println("hibernate:");
//			System.out.println(new BasicFormatterImpl().format(sql));
//			System.out.flush();
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,Object> map = new HashMap<String,Object>();
				ResultSetMetaData data = rs.getMetaData();
				for(int i = 1; i < (data.getColumnCount()+1); i++) {
					String name = data.getColumnName(i);
					Object o = rs.getObject(name);
					map.put(name.toLowerCase(), o);
				}
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BusinessException(e.getMessage());
		}finally {
			try {
				rs.close();
				ps.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;

	}
	
	/**
	 * 统计查询结果条数
	 * @param hql
	 * @param params
	 * @return
	 */
	public int count(String hql,Object ...params){	    
		
		int fromIndex = hql.toLowerCase().indexOf("from");  
        hql = "select count(*) " + hql.substring(fromIndex); 
		Query query = getSession().createQuery(hql);
		if(params!=null && params.length!=0){
//			System.out.println("参数："+JSONArray.fromObject(params));
			for(int i=0;i<params.length;i++){
				
				query.setParameter(""+i, params[i]);
			}
//			System.out.flush();
		}
		Long uniqueResult = (Long)query.uniqueResult();
		int count = (uniqueResult==null)? 0:uniqueResult.intValue();
		return count;
  }
	
	/**
	 * 查询分页数据
	 * @param page
	 * @param hql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Page queryPage(Page page,String hql,Object... params){
		
		int count = count(hql,params);
		Query query = getSession().createQuery(hql);
		if(params!=null && params.length!=0){
//			System.out.println("参数："+JSONArray.fromObject(params));
			for(int i=0;i<params.length;i++){
				
				query.setParameter(""+i, params[i]);
			}
//			System.out.flush();
		}
		List list = query.setFirstResult(page.getStart()).setMaxResults(page.getLimit()).list();
		page.setTotalProperty(count);
		page.setData(list);
		return page;
	}
	
	/**
	 * 统计查询结果条数
	 * @param sql
	 * @param params
	 * @return
	 */
	public int countSql(String sql,Object ...params){	    
		
		sql = "select count(*) from (" + sql + ")";
		int count = Integer.parseInt(queryObjectBySql(sql,params).toString());
		return count;
	}
	
	/**
	 * 查询分页数据
	 * @param page
	 * @param sql
	 * @param params
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Page queryPageBySql(Page page,Class clazz,String sql,Object... params){
		
		int count = countSql(sql,params);
		sql = "select * from"
				+ " (select tag.*,rownum as nm from (" + sql + ")tag)"
				+ " where nm > " + page.getStart() + ""
				+ " and nm <= " + (page.getStart()+page.getLimit());
		List list = queryListMapBySql(sql,params);
		page.setTotalProperty(count);
		page.setData(VTools.getListBeanFromSqlListMap(clazz, list, true));
		return page;
	}
	
}