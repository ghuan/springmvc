package com.fanfan.subsystem.gsgl.controller.personnel;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fanfan.subsystem.gsgl.service.personnel.IImageUploadMngService;
import com.fanfan.system.core.exception.BusinessException;
import com.fanfan.system.core.hibernate.Page;
import com.fanfan.system.entity.Files;
import com.fanfan.system.service.ISystemService;

/**
 * 
* Copy right huan.gao 2015-6-17下午11:21:45
* All right reserved
* QQ:2223486623 
* description：图片上传管理测试Action
 */
@Controller
@RequestMapping(value="imageUploadMng")
public class ImageUploadMngController{

	protected static final Log log = LogFactory.getLog(ImageUploadMngController.class);
	
	@Autowired
	private IImageUploadMngService imageUploadMngService;
	@Autowired
	private ISystemService systemService;
	
	/**
	 * 跳转到图片上传管理页面
	 * @return
	 */
	@RequestMapping(value="viewImageUploadMng")
	public String viewImageUploadMng() {
		
		log.info("正在载入图片上传管理页面...");
		return "subsystem/gsgl/personnel/uploadimage/imageUploadMng";
	}
	
	/**
	 * 图片上传
	 * @param file
	 * @param name
	 */
	@RequestMapping(value="imageUpload")
	@ResponseBody
	public void imageUpload(@RequestParam("file") CommonsMultipartFile file,String name){
		
		try {
			imageUploadMngService.uploadImage(file, name);
		} catch (Exception e) {
			// TODO: handle exception
			throw new BusinessException(e.getMessage());
		}
	}
	
	/**
	 * 获取图片列表分页数据
	 * @param file
	 * @return
	 */
	@RequestMapping(value="getImages")
	@ResponseBody
	public Page getImages(Page page,Files file){
		
		try {
			return imageUploadMngService.getImages(page, file);
		} catch (Exception e) {
			// TODO: handle exception
			throw new BusinessException(e.getMessage());
		}
	}
	
	/**
	 * 显示图片
	 * @param id
	 */
	@RequestMapping(value="showImageById")
	public void showImageById(String id,HttpServletResponse response){
		
		try {
			Files image = imageUploadMngService.getImageById(id);
			systemService.showBinaryImage(image.getBlobContent());
		} catch (Exception e) {
			// TODO: handle exception
			throw new BusinessException(e.getMessage());
		}
	}
	
	/**
	 * 删除图片
	 * @param ids
	 */
	@RequestMapping(value="delete")
	@ResponseBody
	public void delete(String[] ids){
		
		try {
			imageUploadMngService.delete(ids);
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}
	
}
