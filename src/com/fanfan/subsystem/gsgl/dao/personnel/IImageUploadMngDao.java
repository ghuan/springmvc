package com.fanfan.subsystem.gsgl.dao.personnel;

import com.fanfan.system.core.hibernate.Page;
import com.fanfan.system.entity.Files;

/**
 * 
* Copy right huan.gao 下午8:05:56
* All right reserved
* QQ:2223486623 
* description：图片上传dao接口
 */
public interface IImageUploadMngDao {

	/**
	 * 保存图片
	 * @param image
	 */
	public void saveImage(Files image);
	
	/**
	 * 查询图片列表分页数据
	 * @param page
	 * @param file
	 * @return
	 */
	public Page queryImages(Page page,Files file);
	
	/**
	 * 查询图片by id
	 * @param id
	 * @return
	 */
	public Files queryImageById(String id);
	
	/**
	 * 删除图片
	 * @param id
	 */
	public void deleteById(String id);
}
