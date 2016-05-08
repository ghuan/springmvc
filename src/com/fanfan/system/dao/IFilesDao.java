package com.fanfan.system.dao;

import com.fanfan.system.entity.Files;

public interface IFilesDao {
	
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
