package com.fanfan.system.dao;

import java.util.List;

import com.fanfan.system.core.hibernate.Page;


public interface IBaseDao {
	/**
	 * 保存
	 * @param entity
	 */
	public void save(Object entity);
	
	
	/**
	 * 保存或更新
	 * @param entity
	 */
	public void saveOrUpdate(Object entity);
	
	
	/**
	 * 删除
	 * @param entity
	 */
	public void delete(Object entity);
	
	
	/**
	 * 更新
	 * @param entity
	 */
	public void update(Object entity);
	
	
	/**
	 * 查询
	 * @param hql
	 * @param params
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List queryList(String hql,Object... params);
	
	/**
	 * 查询
	 * @param hql
	 * @param params
	 * @return Object
	 */
	public Object queryObject(String hql,Object... params);
	
	/**
	 * 查询
	 * @param sql
	 * @param params
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List queryListObjectBySql(String sql,Object... params);
	
	/**
	 * 查询
	 * @param sql
	 * @param params
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List queryListBeanBySql(Class c,String sql,Object... params);
	
	/**
	 * 查询
	 * @param sql
	 * @param params
	 * @return Object
	 */
	public Object queryObjectBySql(String sql,Object... params);
	
	/**
	 * 查询一个bean，如果查询到多条，则默认取最后一条
	 * @param sql
	 * @param params
	 * @return Object
	 */
	@SuppressWarnings("rawtypes")
	public Object queryBeanBySql(Class clazz,String sql,Object... params);
	
	/**
	 * 执行普通sql 返回执行条数
	 * @param sql
	 * @param values
	 */
	public int executeSql(String sql, Object... params);
	
	/**
	 * 执行hql 返回执行条数
	 * @param hql
	 * @param params
	 * @return
	 */
	public int executeHql(String hql,Object... params);	
	
	/**
	 * 查询普通sql，返回List<Map<String,Object>>
	 * @param sql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List queryListMapBySql(String sql,Object ...params);
	
	/**
	 * 查询普通sql，返回List<Map<String,Object>>
	 * @param sql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List queryListMapBySql2(String sql,Object ...params);
	
	/**
	 * 统计查询结果条数
	 * @param hql
	 * @param params
	 * @return
	 */
	public int count(String hql,Object ...params);
	
	/**
	 * 查询分页数据
	 * @param page
	 * @param hql
	 * @param params
	 * @return
	 */
	public Page queryPage(Page page,String hql,Object... params);
	
	/**
	 * 统计查询结果条数
	 * @param sql
	 * @param params
	 * @return
	 */
	public int countSql(String sql,Object ...params);
	
	/**
	 * 查询分页数据
	 * @param page
	 * @param sql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Page queryPageBySql(Page page,Class clazz,String sql,Object... params);
	
}
