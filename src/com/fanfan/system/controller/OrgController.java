package com.fanfan.system.controller;

import java.util.List;

import com.fanfan.system.core.annotation.ControllerLog;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fanfan.system.core.exception.BusinessException;
import com.fanfan.system.entity.Org;
import com.fanfan.system.service.IOrgService;

/**
 * 
* Copy right huan.gao 2015-6-17下午11:21:45
* All right reserved
* QQ:2223486623 
* description：组织机构Action
 */
@Controller
@RequestMapping(value="org")
public class OrgController{

	protected static final Log log = LogFactory.getLog(OrgController.class);
	
	@Autowired
	private IOrgService orgService;
	
	/**
	 * 跳转到组织机构管理页面
	 * @return
	 */
	@RequestMapping(value="viewOrg")
	public String viewOrg() {
		
		log.info("正在载入组织机构管理界面...");
		return "system/org";
	}
	
	/**
	 * 保存或更新组织机构
	 * @param org
	 * @return
	 */
	@RequestMapping(value="saveOrUpdate")
	@ResponseBody
	@ControllerLog(description = "保存或更新组织机构")
	public void saveOrUpdate(Org org){
		
		try {
			
			orgService.saveOrUpdate(org);
		} catch (Exception e) {
			// TODO: handle exception
			throw new BusinessException(e.getMessage());
		}
	}
	
	/**
	 * 删除组织机构
	 * @param ids
	 */
	@RequestMapping(value="delete")
	@ResponseBody
	@ControllerLog(description = "删除组织机构")
	public void delete(String[] ids){
		
		try {
			orgService.delete(ids);
		} catch (Exception e) {
			// TODO: handle exception
			throw new BusinessException(e.getMessage());
		}
	}
	

	/**
	 * 获取组织机构数据
	 * @param node
	 * @param id
	 * @return
	 */
	@RequestMapping(value="getOrg")
	@ResponseBody
	public List<Org> getOrg(String node,String id,String queryText,String queryValue){
		
		return orgService.getOrg(node, id,queryText,queryValue);
	}
	
	/**
	 * 获取组织路径
	 * @param name
	 * @return
	 */
	@RequestMapping(value="getOrgByPath")
	@ResponseBody
	public List<Org> getOrgByPath(String name){
		
		return orgService.getOrgByPath(name, null);
	}
	
}
