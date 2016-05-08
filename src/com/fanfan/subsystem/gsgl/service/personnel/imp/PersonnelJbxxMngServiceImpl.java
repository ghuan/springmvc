
package com.fanfan.subsystem.gsgl.service.personnel.imp;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fanfan.subsystem.gsgl.dao.personnel.IPersonnelJbxxMngDao;
import com.fanfan.subsystem.gsgl.entity.personnel.Personnel;
import com.fanfan.subsystem.gsgl.service.personnel.IPersonnelJbxxMngService;
import com.fanfan.subsystem.gsgl.vo.personnel.PersonnelVo;
import com.fanfan.system.core.exception.BusinessException;
import com.fanfan.system.core.hibernate.Page;
import com.fanfan.system.core.web.RequestResponseContext;
import com.fanfan.system.dao.IFilesDao;
import com.fanfan.system.dao.ISystemDao;
import com.fanfan.system.entity.Dict;
import com.fanfan.system.entity.Files;
import com.fanfan.system.util.VTools;
import com.fanfan.system.util.constants.Dict_Constants;
import com.fanfan.system.util.constants.System_Constants;
import com.fanfan.system.util.excel.ExcelColumn;
import com.fanfan.system.util.excel.ExcelHead;
import com.fanfan.system.util.excel.ExcelHelper;
import com.fanfan.system.util.excel.JxlsExcelUtil;

/**
 * 
* Copy right huan.gao 2015-7-9下午10:06:50
* All right reserved
* QQ:2223486623 
* description：员工基本信息管理service
 */
@Service
@Transactional//纳入事务管理
public class PersonnelJbxxMngServiceImpl implements IPersonnelJbxxMngService {

	@Autowired
	private IPersonnelJbxxMngDao personnelJbxxMngDao;
	@Autowired
	private ISystemDao systemDao;
	@Autowired
	private IFilesDao filesDao;
	
	/**
	 * 获取员工基本信息分页数据
	 * @return
	 */
	public Page getPersonnelPage(Page page,Personnel personnel){
		
		return personnelJbxxMngDao.queryPersonnelPage(page, personnel);
	}
	
	/**
	 * 获取员工基本信息数据
	 * @return
	 */
	public List<Personnel> getPersonnelPage(Personnel personnel){
		
		return personnelJbxxMngDao.queryPersonnelList(personnel);
	}
	
	/**
	 * 保存或更新员工基本信息
	 * @param personnel
	 */
	public void saveOrUpdate(Personnel personnel){
		
		if(VTools.StringIsEmpty(personnel.getId())){
			
			personnel.setId(null);
		}
		personnelJbxxMngDao.saveOrUpdate(personnel);
	}
	
	/**
	 * 删除员工基本信息
	 * @param ids
	 */
	public void delete(String[] ids){
		
		for(String id : ids){
			
			personnelJbxxMngDao.deleteById(id);
		}
	}
	
	/**
	 * 批量保存或更新员工基本信息
	 * @param personnels
	 */
	public void saveOrUpdateBatch(List<Personnel> personnels){
		
		for(Personnel personnel : personnels){
			
			this.saveOrUpdate(personnel);
		}
	}
	
	/**
	 * 更新导入模板
	 * @param file
	 */
	public void updateTemplate(CommonsMultipartFile file){
		
		try {
			
			Files template = personnelJbxxMngDao.queryTemplate();
			template.setTitle(file.getFileItem().getName());
			template.setBlobContent(file.getBytes());
			//template.setClobContent("这是一个超长字段测试这是一个超长字段测试这是一个超长字段测试这是一个超长字段测试这是一个超长字段测试这是一个超长字段测试这是一个超长字段测试这是一个超长字段测试这是一个超长字段测试");
			template.setUpdateTime(VTools.getTimeNow(System_Constants.TIMEFORMAT_YMDHMS));
			filesDao.saveOrUpdateFile(template);
		} catch (Exception e) {
			// TODO: handle exception
			throw new BusinessException(e.getMessage());
		}
	}
	
	/**
	 * 获取导入模板
	 * @param file
	 */
	public Files getTemplate(){
		
		return personnelJbxxMngDao.queryTemplate();
	}
	
	/**
	 * 导入excel数据
	 * @param excel
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String importTemplate(CommonsMultipartFile cmfile){
		
		//CommonsMultipartFile转File
		DiskFileItem fi = (DiskFileItem)cmfile.getFileItem(); 
	    File excel = fi.getStoreLocation(); 
		 // excel列结构
        List<ExcelColumn> excelColumns = new ArrayList<ExcelColumn>();
		excelColumns.add(new ExcelColumn(0, "name", "姓名"));
		excelColumns.add(new ExcelColumn(1, "sex", "性别"));
		excelColumns.add(new ExcelColumn(2, "idCard", "身份证号"));
		excelColumns.add(new ExcelColumn(3, "birthday", "生日"));
		excelColumns.add(new ExcelColumn(4, "address", "地址"));
		excelColumns.add(new ExcelColumn(5, "phone", "电话"));
		
		/*列的转换*/
		//性别
		Map<String, Map> excelColumnsConvertMap = new HashMap<String, Map>();
		List<Dict> listDict = systemDao.getDictListByPath(Dict_Constants.USER_SEXDATAID);
		Map<String, Integer> isReceive = new HashMap<String,Integer>();
		for(Dict dict : listDict){
			
			isReceive.put(dict.getValue(), Integer.parseInt(dict.getDataId()));
		}
		excelColumnsConvertMap.put("sex", isReceive);
		
		ExcelHead head = new ExcelHead();
        head.setRowCount(1); // 头所占行数
        head.setColumns(excelColumns);  // 列的定义
        head.setColumnsConvertMap(excelColumnsConvertMap); // 列的转换

        List<PersonnelVo> personnelVos = null;
		try {
			personnelVos = ExcelHelper.getInstanse().importToObjectList(head, excel, PersonnelVo.class);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			throw new BusinessException(e2.getMessage());
		}
		

		
		Personnel t=null;//实体，用于存放数据存入数据库
        FileInputStream fs = null;
        XSSFWorkbook wb = null;//用于写数据到excel
        try {
			
			fs = new FileInputStream(excel);
			wb =new XSSFWorkbook(fs); 
		} catch (Exception e){
			
			throw new BusinessException(e.getMessage());
		}
        XSSFSheet sheet = wb.getSheetAt(0);  //获取到第一个工作表  
        XSSFRow row;  
		
		/*第一行第6列添加数据*/
        row=sheet.getRow((short)(0)); //第一行 
        row.createCell(6).setCellValue("导入状态"); //第6列

        
        int i =0;//计算行数
        int okinsert=0;//成功导入条数
        int noinsert=0;//导入失败条数

        /*循环操作excel中解析到的每行数据*/
        for (PersonnelVo personnelVo : personnelVos) {
        	
        	int tag=0;//0导入，1不导入
        	try {
        		
        		i++;
        		row=sheet.getRow((short)(i)); 
        		t=new Personnel();
        		
        		t.setAddress(personnelVo.getAddress());
        		String birthday = personnelVo.getBirthday();
        		if(birthday.length() > 10){
        			
        			birthday = birthday.substring(0,10);
        		}
        		t.setBirthday(birthday);
        		t.setIdCard(personnelVo.getIdCard());
        		t.setName(personnelVo.getName());
        		t.setPhone(personnelVo.getPhone());
        		t.setSex(personnelVo.getSex());
        		
        		if(tag==0){
        			
        			personnelJbxxMngDao.saveOrUpdate(t);
     		    	okinsert++;
     		    	row.createCell(6).setCellValue("导入成功！");

        		}
    		} catch (Exception e) {
    			
    			e.printStackTrace();
    			noinsert++;
    			row.createCell(6).setCellValue("导入失败！");
    		}    
        }
        /*最终导入结果输出到excel并更新到导入模板*/ 
        try {
        	
        	ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
			wb.write(arrayOutputStream); 
			arrayOutputStream.flush();
			arrayOutputStream.close();
			
			fs.close();
			
			Files template = personnelJbxxMngDao.queryTemplate();
			template.setBlobContent(arrayOutputStream.toByteArray());
			template.setUpdateTime(VTools.getTimeNow(System_Constants.TIMEFORMAT_YMDHMS));
			filesDao.saveOrUpdateFile(template);
			
		}catch (Exception e) {
			
			// TODO Auto-generated catch block
			throw new BusinessException(e.getMessage());
		}
        
        return "导入成功[<font color=green>"+okinsert+"</font>]条，失败[<font color=red>"+noinsert+"</font>]条,是否下载导入结果文件？";
		
	}
	
	/**
	 * 导出excel数据
	 * @param excel
	 * @return
	 */
	public void exportTemplate(Personnel personnel){
		
		HttpServletRequest request = RequestResponseContext.getRequest();
		String modelFilePath = request.getSession().getServletContext().getRealPath("exportTemplate/exportTemplate.xlsx");
		String outputFilePath = request.getSession().getServletContext().getRealPath("download/exportResult.xlsx");
		Map<String,Object> map = new HashMap<String,Object>();
		List<Personnel> personnels = personnelJbxxMngDao.queryPersonnelList(personnel);
		map.put("dataList", personnels);
		String success = JxlsExcelUtil.map2excel(modelFilePath, map, outputFilePath);
		if(!"success".equals(success)){
			
			throw new BusinessException("导出失败!");
		}
	}
	
}
