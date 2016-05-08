
package com.fanfan.system.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fanfan.system.core.hibernate.Page;
import com.fanfan.system.dao.IBaseDao;
import com.fanfan.system.service.IBaseService;

/**
 * 
* Copy right huan.gao 2015-7-9下午10:06:50
* All right reserved
* QQ:2223486623 
* description：通用数据操作service
 */
@Service
@Transactional//纳入事务管理
public class BaseServiceImpl implements IBaseService {

	//@Autowired //这里dao层如果被继承，就不能被注入，具体原因还不了解
	private IBaseDao baseDao;
	

	public IBaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}

	/**
	 * 保存
	 * @param entity
	 */
	public void save(Object entity){
		
		baseDao.save(entity);
	}
	
	
	/**
	 * 保存或更新
	 * @param entity
	 */
	public void saveOrUpdate(Object entity){
		
		baseDao.saveOrUpdate(entity);
	}
	
	
	/**
	 * 删除
	 * @param entity
	 */
	public void delete(Object entity){
		
		baseDao.delete(entity);
	}
	
	
	/**
	 * 更新
	 * @param entity
	 */
	public void update(Object entity){
		
		baseDao.update(entity);
	}
	
	
	/**
	 * 查询
	 * @param hql
	 * @param params
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List queryList(String hql,Object... params){
		
		return baseDao.queryList(hql, params);
	}
	
	/**
	 * 查询
	 * @param hql
	 * @param params
	 * @return Object
	 */
	public Object queryObject(String hql,Object... params){
		
		return baseDao.queryObject(hql, params);
	}
	
	/**
	 * 查询
	 * @param sql
	 * @param params
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List queryListObjectBySql(String sql,Object... params){
		
		return baseDao.queryListObjectBySql(sql, params);
	}
	
	/**
	 * 查询
	 * @param sql
	 * @param params
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List queryListBeanBySql(Class c,String sql,Object... params){
		
		return baseDao.queryListBeanBySql(c, sql, params);
	}
	
	/**
	 * 查询
	 * @param sql
	 * @param params
	 * @return Object
	 */
	public Object queryObjectBySql(String sql,Object... params){
		
		return baseDao.queryObjectBySql(sql, params);
	}
	
	/**
	 * 查询一个bean，如果查询到多条，则默认取最后一条
	 * @param sql
	 * @param params
	 * @return Object
	 */
	@SuppressWarnings("rawtypes")
	public Object queryBeanBySql(Class clazz,String sql,Object... params){
		
		return baseDao.queryBeanBySql(clazz, sql, params);
	}
	
	/**
	 * 执行普通sql 返回执行条数
	 * @param sql
	 * @param values
	 */
	public int executeSql(String sql, Object... params){
		
		return baseDao.executeSql(sql, params);
	}
	
	/**
	 * 执行hql 返回执行条数
	 * @param hql
	 * @param params
	 * @return
	 */
	public int executeHql(String hql,Object... params){
		
		return baseDao.executeHql(hql, params);
	}
	
	/**
	 * 查询普通sql，返回List<Map<String,Object>>
	 * @param sql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List queryListMapBySql(String sql,Object ...params){
		
		return baseDao.queryListMapBySql(sql, params);
	}
	
	/**
	 * 查询普通sql，返回List<Map<String,Object>>
	 * @param sql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List queryListMapBySql2(String sql,Object ...params){
		
		return baseDao.queryListMapBySql2(sql, params);
	}
	
	/**
	 * 统计查询结果条数
	 * @param hql
	 * @param params
	 * @return
	 */
	public int count(String hql,Object ...params){
		
		return baseDao.count(hql, params);
	}
	
	/**
	 * 查询分页数据
	 * @param page
	 * @param hql
	 * @param params
	 * @return
	 */
	public Page queryPage(Page page,String hql,Object... params){
		
		return baseDao.queryPage(page, hql, params);
	}
	
	/**
	 * 统计查询结果条数
	 * @param sql
	 * @param params
	 * @return
	 */
	public int countSql(String sql,Object ...params){
		
		return baseDao.countSql(sql, params);
	}
	
	/**
	 * 查询分页数据
	 * @param page
	 * @param sql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Page queryPageBySql(Page page,Class clazz,String sql,Object... params){
		
		return baseDao.queryPageBySql(page, clazz, sql, params);
	}
}
