package com.fanfan.subsystem.gsgl.dao.personnel.imp;

import org.springframework.stereotype.Repository;

import com.fanfan.subsystem.gsgl.dao.personnel.IImageUploadMngDao;
import com.fanfan.system.core.hibernate.Page;
import com.fanfan.system.dao.imp.BaseDaoImpl;
import com.fanfan.system.entity.Files;
import com.fanfan.system.util.VTools;
import com.fanfan.system.util.constants.Files_Constants;

/**
 * 
* Copy right huan.gao 2015
* All right reserved
* QQ:2223486623 
* description：员工基本信息管理Dao
 */
@Repository
public class ImageUploadMngDaoImpl extends BaseDaoImpl implements IImageUploadMngDao{

	/**
	 * 保存图片
	 * @param image
	 */
	public void saveImage(Files image){
		
		super.save(image);
	}
	
	/**
	 * 查询图片列表分页数据
	 * @param page
	 * @param file
	 * @return
	 */
	public Page queryImages(Page page,Files file){
		
		String hql = "select new Files(id,title,updateTime,type) from Files where type = ?0";
		if(!VTools.StringIsEmpty(file.getTitle())){
			
			hql += " and title like '%"+file.getTitle().trim()+"%'";
		}
		return super.queryPage(page, hql,Files_Constants.IMAGE_TYPE);
	}
	
	/**
	 * 查询图片by id
	 * @param id
	 * @return
	 */
	public Files queryImageById(String id){
		
		String hql = "from Files where type = ?0 and id = ?1";
		return (Files) super.queryObject(hql, Files_Constants.IMAGE_TYPE,id);
	}
	
	/**
	 * 删除图片
	 * @param id
	 */
	public void deleteById(String id){
		
		super.executeHql("delete from Files where id = ?0", id);
	}
}
