package com.fanfan.system.util.excel;

import java.util.Map;

import org.apache.log4j.Logger;

import net.sf.jxls.transformer.XLSTransformer;

public class JxlsExcelUtil {

	private static Logger logger = Logger.getLogger(JxlsExcelUtil.class);
	private static XLSTransformer transformer = null;
	
	static{
		transformer = new XLSTransformer();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	@SuppressWarnings("rawtypes")
	public static String map2excel(String templatePath, Map map, String outputFilePath){
		
		try {
			transformer.transformXLS(templatePath, map, outputFilePath);
			logger.info(">>>>map生成excel成功!");
			return "success";
		} catch (Exception e) {
			logger.info(">>>>map生成excel发生错误:" + e.getMessage());
			e.printStackTrace();
			return "生成excel时发生错误："+e.getMessage();
		}
	}
}
