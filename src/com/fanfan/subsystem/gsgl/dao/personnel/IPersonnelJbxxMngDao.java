package com.fanfan.subsystem.gsgl.dao.personnel;

import java.util.List;

import com.fanfan.subsystem.gsgl.entity.personnel.Personnel;
import com.fanfan.system.core.hibernate.Page;
import com.fanfan.system.entity.Files;

/**
 * 
* Copy right huan.gao 下午8:05:56
* All right reserved
* QQ:2223486623 
* description：员工基本信息管理dao接口
 */
public interface IPersonnelJbxxMngDao {

	/**
	 * 查询员工基本信息分页数据
	 * @param page
	 * @param personnel
	 * @return
	 */
	public Page queryPersonnelPage(Page page,Personnel personnel);
	
	/**
	 * 查询员工基本信息数据
	 * @param personnel
	 * @return
	 */
	public List<Personnel> queryPersonnelList(Personnel personnel);
	
	/**
	 * 保存或更新员工基本信息
	 * @param personnel
	 */
	public void saveOrUpdate(Personnel personnel);
	
	/**
	 * 删除员工基本信息
	 * @param id
	 */
	public void deleteById(String id);
	
	/**
	 * 更新导入模板
	 * @param file
	 */
	public void updateTemplate(Files template);
	
	/**
	 * 查询导入模板
	 * @return
	 */
	public Files queryTemplate();
	
}
