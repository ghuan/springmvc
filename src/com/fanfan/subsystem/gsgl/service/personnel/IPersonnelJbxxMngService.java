package com.fanfan.subsystem.gsgl.service.personnel;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fanfan.subsystem.gsgl.entity.personnel.Personnel;
import com.fanfan.system.core.hibernate.Page;
import com.fanfan.system.entity.Files;

/**
 * 
* Copy right huan.gao 下午7:59:22
* All right reserved
* QQ:2223486623 
* description：员工基本信息管理service接口
 */
public interface IPersonnelJbxxMngService {
	
	/**
	 * 获取员工基本信息分页数据
	 * @return
	 */
	public Page getPersonnelPage(Page page,Personnel personnel);
	
	/**
	 * 获取员工基本信息数据
	 * @return
	 */
	public List<Personnel> getPersonnelPage(Personnel personnel);
	
	/**
	 * 保存或更新员工基本信息
	 * @param personnel
	 */
	public void saveOrUpdate(Personnel personnel);
	
	/**
	 * 删除员工基本信息
	 * @param ids
	 */
	public void delete(String[] ids);
	
	/**
	 * 批量保存或更新员工基本信息
	 * @param personnels
	 */
	public void saveOrUpdateBatch(List<Personnel> personnels);
	
	/**
	 * 更新导入模板
	 * @param file
	 */
	public void updateTemplate(CommonsMultipartFile file);
	
	/**
	 * 获取导入模板
	 * @param file
	 */
	public Files getTemplate();
	
	/**
	 * 导入excel数据
	 * @param excel
	 * @return
	 */
	public String importTemplate(CommonsMultipartFile cmfile);
	
	/**
	 * 导出excel数据
	 * @param excel
	 * @return
	 */
	public void exportTemplate(Personnel personnel);
	
}
