package com.fanfan.system.core.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fanfan.system.core.exception.BusinessException;

/**
 * 
 * Copy right huan.gao 下午9:29:36 All right reserved QQ:2223486623
 * description：自定义文件上传控制类
 */

public class CustomCommonsMultipartResolver extends CommonsMultipartResolver {

	@SuppressWarnings("unchecked")
	@Override
	protected MultipartParsingResult parseRequest(HttpServletRequest request) throws MultipartException {
		String encoding = determineEncoding(request);
		FileUpload fileUpload = prepareFileUpload(encoding);

		try {
			List<FileItem> fileItems = ((ServletFileUpload) fileUpload).parseRequest(request);
			return parseFileItems(fileItems, encoding);
		} catch (FileUploadBase.SizeLimitExceededException ex) {
			throw new BusinessException("最大上传文件不能超过"+fileUpload.getSizeMax() + "bytes");
		} catch (FileUploadException ex) {
			throw new BusinessException("Could not parse multipart servlet request");
		}
	}
}
