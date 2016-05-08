package com.fanfan.system.dao.imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fanfan.system.dao.IDictDao;
import com.fanfan.system.entity.Dict;

/**
 * 
* Copy right huan.gao 2015
* All right reserved
* QQ:2223486623 
* description：数据字典Dao
 */
@Repository
public class DictDaoImpl extends BaseDaoImpl implements IDictDao{

	
	/**
	 * 保存或修改
	 * @param dict
	 */
	public void saveOrUpdate(Dict dict){
		
		super.saveOrUpdate(dict);
	}
	
	/**
	 * 删除
	 * @param id
	 */
	public void delele(String id){
		
		super.executeHql("delete from Dict where id = ?0", id);
	}
	
	/**
	 * 查询数据字典
	 */
	@SuppressWarnings("unchecked")
	public List<Dict> getDictByPid(String pid) {
		// TODO Auto-generated method stub
		
		String hql = "from Dict where pid = ?0 order by rank";
		return super.queryList(hql, pid);
	}
	
}
