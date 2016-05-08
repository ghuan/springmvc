package com.fanfan.system.service.imp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fanfan.system.dao.IFilesDao;
import com.fanfan.system.entity.Files;
import com.fanfan.system.service.IFilesService;

/**
 * 
* Copy right huan.gao 2015
* All right reserved
* QQ:2223486623 
* description：	文件service
 */
@Service
@Transactional //异常回滚
public class FilesServiceImpl implements IFilesService{

	protected static final Log _log = LogFactory.getLog(FilesServiceImpl.class);
	
	@Autowired
	private IFilesDao filesDao;
	
	/**
	 * 保存或更新文件
	 * @param file
	 */
	public void saveOrUpdateFile(Files file){
		
		filesDao.saveOrUpdateFile(file);
	}
	
	/**
	 * 删除文件
	 * @param id
	 */
	public void deleteFileById(String id){
		
		filesDao.deleteFileById(id);
	}
	
}
