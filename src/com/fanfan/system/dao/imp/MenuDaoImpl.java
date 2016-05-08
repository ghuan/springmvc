package com.fanfan.system.dao.imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fanfan.system.dao.IMenuDao;
import com.fanfan.system.entity.Menu;

/**
 * 
* Copy right huan.gao 2015
* All right reserved
* QQ:2223486623 
* description：菜单Dao
 */
@Repository
public class MenuDaoImpl extends BaseDaoImpl implements IMenuDao{
	
	/**
	 * 保存或修改
	 * @param menu
	 */
	public void saveOrUpdate(Menu menu){
		
		super.saveOrUpdate(menu);
	}
	
	/**
	 * 删除
	 * @param id
	 */
	public void delete(String id){
		super.executeHql("delete from Menu where id = ?0", id);
	}
	
	/**
	 * 获取用户菜单
	 * @param pid
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List queryMenusByPid(String pid)
	  {
	    String sql = "SELECT T.*, (SELECT COUNT(N.ID) FROM T_SYS_MENU N WHERE N.PID=T.ID) subNodes FROM T_SYS_MENU T WHERE T.PID=?0 ORDER BY T.RANK";
	    return super.queryListBeanBySql(Menu.class, sql, pid);
        
	  }
	
}
