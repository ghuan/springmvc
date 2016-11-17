package com.fanfan.system.service;

import com.fanfan.system.core.hibernate.Page;
import com.fanfan.system.entity.Log;
import com.fanfan.system.entity.Org;

import java.util.List;

/**
 * 
* Copy right huan.gao 2015-7-7下午10:31:50
* All right reserved
* QQ:2223486623 
* description：系统日志service接口
 */
public interface ILogService {

	
	/**
	 * 保存或更新
	 * @param log
	 */
	public void saveOrUpdate(Log log);
	
	/**
	 * 删除
	 * @param ids
	 */
	public void delete(String[] ids);

	/**
	 * 获取日志分页数据
	 * @param page
	 * @param startTime
	 * @param endTime
	 * @param type
	 * @param userId
	 * @return
	 */
	public Page getLogPage(Page page,String startTime, String endTime, int type, String userId);

	/**
	 * 获取异常具体描述
	 * @param id
	 * @return
	 */
	public String getExceptionDetail(String id);
	
}
