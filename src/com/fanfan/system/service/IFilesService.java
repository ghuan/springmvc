package com.fanfan.system.service;

import com.fanfan.system.entity.Files;

/**
 * 
* Copy right huan.gao 2015-7-7下午10:31:50
* All right reserved
* QQ:2223486623 
* description：文件service接口
 */
public interface IFilesService{

	/**
	 * 保存或更新文件
	 * @param file
	 */
	public void saveOrUpdateFile(Files file);
	
	/**
	 * 删除文件
	 * @param id
	 */
	public void deleteFileById(String id);
}
