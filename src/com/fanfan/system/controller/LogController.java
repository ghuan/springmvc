package com.fanfan.system.controller;

import com.fanfan.system.core.exception.BusinessException;
import com.fanfan.system.core.hibernate.Page;
import com.fanfan.system.entity.Role;
import com.fanfan.system.entity.User;
import com.fanfan.system.service.ILogService;
import com.fanfan.system.service.IUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 
* Copy right huan.gao 2015-6-17下午11:21:45
* All right reserved
* QQ:2223486623 
* description：系统日志管理Action
 */
@Controller
@RequestMapping(value="log")
public class LogController {

	protected static final Log log = LogFactory.getLog(LogController.class);
	
	@Autowired
	private ILogService logService;
	
	/**
	 * 跳转到系统日志管理页面
	 * @return
	 */
	@RequestMapping(value="viewLog")
	public String viewLog() {
		
		log.info("正在载入系统日志管理界面...");
		return "system/log";
	}

	/**
	 * 获取日志分页数据
	 * @param startTime
	 * @param endTime
	 * @param type
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="getLogPage")
	@ResponseBody
	public Page getLogPage(Page page,String startTime, String endTime, int type,String userId){
		return logService.getLogPage(page,startTime,endTime,type,userId);
	}

	/**
	 * 删除
	 * @param ids
	 */
	@RequestMapping(value="delete")
	@ResponseBody
	public void delete(String[] ids){

		try {
			logService.delete(ids);
		} catch (Exception e) {
			// TODO: handle exception
			throw new BusinessException(e.getMessage());
		}
	}

	/**
	 * 获取异常具体描述
	 * @param id
	 */
	@RequestMapping(value="getExceptionDetail")
	@ResponseBody
	public String getExceptionDetail(String id){

		try {
			return logService.getExceptionDetail(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new BusinessException(e.getMessage());
		}
	}
}
