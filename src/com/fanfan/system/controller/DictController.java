package com.fanfan.system.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.fanfan.system.core.annotation.ControllerLog;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fanfan.system.core.exception.BusinessException;
import com.fanfan.system.entity.Dict;
import com.fanfan.system.service.IDictService;

/**
 * 
* Copy right huan.gao 2015-6-17下午11:21:45
* All right reserved
* QQ:2223486623 
* description：数据字典Action
 */
@Controller
@RequestMapping(value="dict")
public class DictController{

	protected static final Log log = LogFactory.getLog(DictController.class);
	
	@Autowired
	private IDictService dictService;
	
	/**
	 * 跳转到数据字典管理页面
	 * @return
	 */
	@RequestMapping(value="viewDict")
	public String viewDict() {
		
		log.info("正在载入数据字典管理界面...");
		return "system/dict";
	}
	
	/**
	 * 保存字典
	 * @param dict
	 * @return
	 */
	@RequestMapping(value="saveOrUpdate")
	@ResponseBody
	@ControllerLog(description = "保存字典")
	public void saveOrUpdate(Dict dict){
		
		try {
			
			dictService.saveOrUpdate(dict);
		} catch (Exception e) {
			// TODO: handle exception
			throw new BusinessException(e.getMessage());
		}
	}
	
	/**
	 * 删除数据字典
	 * @param ids
	 */
	@RequestMapping(value="delete")
	@ResponseBody
	@ControllerLog(description = "删除数据字典")
	public void delete(String[] ids){
		
		try {
			dictService.delete(ids);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new BusinessException(e.getMessage());
		}
		
	}
	
	/**
	 * 加载数据字典
	 * @return
	 */
	@RequestMapping(value="loadSystemDicts")
	@ResponseBody
	public List<Dict> loadSystemDicts(HttpServletRequest request)
	  {
		List<Dict> list = new ArrayList<Dict>();
		try {
			
			String pid = request.getParameter("node");
		    list = dictService.loadSystemDicts(pid);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new BusinessException(e.getMessage());
		}
	    
	    return list;
	  }
	
	
}
