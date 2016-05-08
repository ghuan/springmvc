package com.fanfan.system.dao.imp;

import org.springframework.stereotype.Repository;

import com.fanfan.system.dao.IFilesDao;
import com.fanfan.system.entity.Files;

/**
 * 
* Copy right huan.gao 2015
* All right reserved
* QQ:2223486623 
* description：文件Dao
 */
@Repository
public class FilesDaoImpl extends BaseDaoImpl implements IFilesDao{
	
	/**
	 * 保存或更新文件
	 * @param file
	 */
	public void saveOrUpdateFile(Files file){
		
		super.saveOrUpdate(file);
	}
	
	/**
	 * 删除文件
	 * @param id
	 */
	public void deleteFileById(String id){
		
		super.executeHql("delete from Files where id = ?0", id);
	}
}
