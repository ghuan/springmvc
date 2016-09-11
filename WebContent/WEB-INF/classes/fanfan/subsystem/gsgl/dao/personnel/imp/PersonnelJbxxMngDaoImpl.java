package com.fanfan.subsystem.gsgl.dao.personnel.imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fanfan.subsystem.gsgl.dao.personnel.IPersonnelJbxxMngDao;
import com.fanfan.subsystem.gsgl.entity.personnel.Personnel;
import com.fanfan.system.core.hibernate.Page;
import com.fanfan.system.dao.imp.BaseDaoImpl;
import com.fanfan.system.entity.Files;
import com.fanfan.system.util.VTools;
import com.fanfan.system.util.constants.Files_Constants;

/**
 * 
* Copy right huan.gao 2015
* All right reserved
* QQ:2223486623 
* description：员工基本信息管理Dao
 */
@Repository
public class PersonnelJbxxMngDaoImpl extends BaseDaoImpl implements IPersonnelJbxxMngDao{

	/**
	 * 查询员工基本信息分页数据
	 * @param page
	 * @param personnel
	 * @return
	 */
	public Page queryPersonnelPage(Page page,Personnel personnel){
		
		String hql = "from Personnel where 1 = 1";
		if(!VTools.StringIsEmpty(personnel.getName())){
			
			hql += " and name like '%"+personnel.getName().trim()+"%'";
		}
		return super.queryPage(page, hql, new Object[0]);
	}
	
	/**
	 * 查询员工基本信息数据
	 * @param personnel
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Personnel> queryPersonnelList(Personnel personnel){
		
		String hql = "from Personnel where 1 = 1";
		if(!VTools.StringIsEmpty(personnel.getName())){
			
			hql += " and name like '%"+personnel.getName().trim()+"%'";
		}
		return super.queryList(hql);
	}
	
	/**
	 * 保存或更新员工基本信息
	 * @param personnel
	 */
	public void saveOrUpdate(Personnel personnel){
		
		super.saveOrUpdate(personnel);
	}
	
	/**
	 * 删除员工基本信息
	 * @param id
	 */
	public void deleteById(String id){
		
		super.executeHql("delete from Personnel where id = ?0", id);
	}
	
	/**
	 * 更新导入模板
	 * @param file
	 */
	public void updateTemplate(Files template){
		
		super.update(template);
	}
	
	/**
	 * 查询导入模板
	 * @return
	 */
	public Files queryTemplate(){
		
		return (Files)super.queryObject("from Files where id = ?0 and type = ?1", "1",Files_Constants.EXCEL_TYPE);
	}
	
}
