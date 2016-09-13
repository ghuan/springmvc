package com.fanfan.system.controller;

import com.fanfan.system.core.exception.BusinessException;
import com.fanfan.system.core.hibernate.Page;
import com.fanfan.system.entity.Role;
import com.fanfan.system.entity.User;
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
	private IUserService userService;
	
	/**
	 * 跳转到系统日志管理页面
	 * @return
	 */
	@RequestMapping(value="viewLog")
	public String viewLog() {
		
		log.info("正在载入系统日志管理界面...");
		return "system/log";
	}
}
