package com.fanfan.subsystem.gsgl.controller.personnel;

import com.fanfan.subsystem.gsgl.entity.personnel.Personnel;
import com.fanfan.system.core.annotation.ControllerLog;
import com.fanfan.subsystem.gsgl.service.personnel.IPersonnelJbxxMngService;
import com.fanfan.system.core.exception.BusinessException;
import com.fanfan.system.core.hibernate.Page;
import com.fanfan.system.entity.Files;
import com.fanfan.system.service.ISystemService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 
* Copy right huan.gao 2015-6-17下午11:21:45
* All right reserved
* QQ:2223486623 
* description：员工基本信息管理Action
 */
@Controller
@RequestMapping(value="personnelJbxxMng")
public class PersonnelJbxxMngController{

	protected static final Log log = LogFactory.getLog(PersonnelJbxxMngController.class);

	@Autowired
	private IPersonnelJbxxMngService personnelJbxxService;
	@Autowired
	private ISystemService systemService;
	
	/**
	 * 跳转到员工基本信息管理页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="viewPersonnelJbxxMng")
	public String viewPersonnelJbxxMng() {

		log.info("正在载入员工基本信息管理页面...");
		return "subsystem/gsgl/personnel/jbxx/personnelJbxxMng";
	}
	
	/**
	 * 获取员工基本信息分页数据
	 * @param page
	 * @param personnel
	 * @return
	 */
	@RequestMapping(value="getPersonnelPage")
	@ResponseBody
	@ControllerLog(description = "获取员工基本信息分页数据")
	public Page getPersonnelPage(Page page,Personnel personnel){
		
		try {
			return personnelJbxxService.getPersonnelPage(page, personnel);
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}
	
	/**
	 * 保存或更新员工基本信息
	 * @param personnel
	 */
	@RequestMapping(value="saveOrUpdate")
	@ResponseBody
	public void saveOrUpdate(Personnel personnel){
		
		try {
			personnelJbxxService.saveOrUpdate(personnel);
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}
	
	/**
	 * 删除员工基本信息
	 * @param ids
	 */
	@RequestMapping(value="delete")
	@ResponseBody
	public void delete(String[] ids){
		
		try {
			personnelJbxxService.delete(ids);
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}
	
	/**
	 * 批量保存或更新员工基本信息
	 * @param personnels
	 */
	@RequestMapping(value="saveOrUpdateBatch")
	@ResponseBody
	public void saveOrUpdateBatch(@RequestBody List<Personnel> personnels){
		
		try {
			personnelJbxxService.saveOrUpdateBatch(personnels);
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}
	
	/**
	 * 更新导入模板
	 * @param personnels
	 */
	@RequestMapping(value="updateTemplate")
	@ResponseBody
	public void updateTemplate(@RequestParam("file") CommonsMultipartFile file){
		
		try {
			
			personnelJbxxService.updateTemplate(file);
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}
	
	/**
	 * 下载导入模板
	 * @param response
	 */
	@RequestMapping(value="downloadTemplate")
	public void downloadTemplate(HttpServletResponse response){
		
		try {
			Files template = personnelJbxxService.getTemplate();
			systemService.downloadBinaryFile(template.getBlobContent(), template.getTitle());
		} catch (Exception e) {
			// TODO: handle exception
			throw new BusinessException(e.getMessage());
		}
	}
	
	/**
	 * 导入excel数据
	 * @param response
	 */
	@RequestMapping(value="importTemplate")
	@ResponseBody
	public String importTemplate(@RequestParam("file") CommonsMultipartFile file,HttpServletResponse response){
		
		try {
			return personnelJbxxService.importTemplate(file);
		} catch (Exception e) {
			// TODO: handle exception
			throw new BusinessException(e.getMessage());
		}
	}
	
	/**
	 * 导出excel数据
	 * @param response
	 */
	@RequestMapping(value="exportTemplate")
	@ResponseBody
	public void exportTemplate(Personnel personnel,HttpServletResponse response){
		
		try {
			personnelJbxxService.exportTemplate(personnel);
		} catch (Exception e) {
			// TODO: handle exception
			throw new BusinessException(e.getMessage());
		}
	}
}
