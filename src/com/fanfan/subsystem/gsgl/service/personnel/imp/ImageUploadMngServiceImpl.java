
package com.fanfan.subsystem.gsgl.service.personnel.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fanfan.subsystem.gsgl.dao.personnel.IImageUploadMngDao;
import com.fanfan.subsystem.gsgl.service.personnel.IImageUploadMngService;
import com.fanfan.system.core.hibernate.Page;
import com.fanfan.system.dao.IFilesDao;
import com.fanfan.system.entity.Files;
import com.fanfan.system.util.VTools;
import com.fanfan.system.util.constants.System_Constants;

/**
 * 
* Copy right huan.gao 2015-7-9下午10:06:50
* All right reserved
* QQ:2223486623 
* description：图片上传管理service
 */
@Service
@Transactional//纳入事务管理
public class ImageUploadMngServiceImpl implements IImageUploadMngService {

	@Autowired
	private IFilesDao filesDao;
	@Autowired
	private IImageUploadMngDao imageUploadMngDao;
	
	/**
	 * 上传图片
	 * @param file
	 */
	public void uploadImage(CommonsMultipartFile cmfile,String name){
		
		Files image = new Files();
		image.setBlobContent(cmfile.getBytes());
		image.setTitle(name);
		image.setType("1");//图片类型
		image.setUpdateTime(VTools.getTimeNow(System_Constants.TIMEFORMAT_YMDHMS));
		filesDao.saveOrUpdateFile(image);
	}
	
	/**
	 * 获取图片列表分页数据
	 * @param page
	 * @param file
	 * @return
	 */
	public Page getImages(Page page,Files file){
		
		return imageUploadMngDao.queryImages(page, file);
	}
	
	/**
	 * 获取图片
	 * @param id
	 */
	public Files getImageById(String id){
		
		return imageUploadMngDao.queryImageById(id);
	}
	
	/**
	 * 删除图片
	 * @param ids
	 */
	public void delete(String[] ids){
		
		for(String id : ids){
			
			imageUploadMngDao.deleteById(id);
		}
	}
}
