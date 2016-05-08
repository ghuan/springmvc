package com.fanfan.subsystem.gsgl.service.personnel;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fanfan.system.core.hibernate.Page;
import com.fanfan.system.entity.Files;

/**
 * 
* Copy right huan.gao 下午7:59:22
* All right reserved
* QQ:2223486623 
* description：图片上传管理service接口
 */
public interface IImageUploadMngService {
	
	/**
	 * 上传图片
	 * @param file
	 */
	public void uploadImage(CommonsMultipartFile cmfile,String name);
	
	/**
	 * 获取图片列表分页数据
	 * @param page
	 * @param file
	 * @return
	 */
	public Page getImages(Page page,Files file);
	
	/**
	 * 获取图片
	 * @param id
	 */
	public Files getImageById(String id);
	
	/**
	 * 删除图片
	 * @param ids
	 */
	public void delete(String[] ids);
	
}
