package com.fanfan.system.util.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import jodd.bean.BeanUtil;
import jodd.datetime.JDateTime;
import jodd.util.StringUtil;

/**
 * Excel助手类
 *
 * @version: 0.1
 * @lastVersion: 0.1
 * @updateTime: 
 * @changesSum: 
 * 
 */
public class ExcelHelper {
    private static ExcelHelper helper = null;

    private ExcelHelper() {

    }

    public static synchronized ExcelHelper getInstanse() {
        if(helper == null) {
            helper = new ExcelHelper();
        }
        return helper;
    }

    /**
     * 将Excel文件导入到list对象
     * @param head  文件头信息
     * @param file  导入的数据源
     * @param cls   保存当前数据的对象
     * @return
     * @return List
     * @throws Exception 
     */
    @SuppressWarnings("rawtypes")
	public List importToObjectList(ExcelHead head, File file, Class cls) throws Exception {
        List contents = null;
        FileInputStream fis;
        // 根据excel生成list类型的数据
        List<List> rows;
        try {
            fis = new FileInputStream(file);
            rows = excelFileConvertToList(fis);

            // 删除头信息
            for (int i = 0; i < head.getRowCount(); i++) {
                rows.remove(0);
            }

            // 将表结构转换成Map
            Map<Integer, String> excelHeadMap = convertExcelHeadToMap(head.getColumns());
            // 构建为对象
            contents = buildDataObject(excelHeadMap,head.getColumnsConvertMap(), rows, cls);
        } catch (FileNotFoundException ex) {
        	 throw ex;
        } catch (Exception ex) {
        	 throw ex;
        }
        return contents;
    }

    /**
     * 导出数据至Excel文件
     * @param excelColumns  报表头信息
     * @param excelHeadConvertMap   需要对数据进行特殊转换的列
     * @param modelFile  模板Excel文件
     * @param outputFile 导出文件
     * @param dataList  导入excel报表的数据来源
     * @return void
     * @throws FileNotFoundException 
     */
    public void exportExcelFile(ExcelHead head, File modelFile, File outputFile, List<?> dataList) throws Exception {
        // 读取导出excel模板
        InputStream inp = null;
        Workbook wb = null;
        try {
            inp = new FileInputStream(modelFile);
            wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
           
            //新添加备注列头
            Row row = sheet.getRow(0);
            Cell cell = row.createCell(head.getColumns().size()-1);
            cell.setCellValue("处理结果");
            cell.setCellStyle(row.getCell(1).getCellStyle());
            
            // 生成导出数据
            buildExcelData(sheet, head, dataList);

            // 导出到文件中
            FileOutputStream fileOut = new FileOutputStream(outputFile);
            wb.write(fileOut);
            fileOut.close();
        } catch (FileNotFoundException ex) {
            throw ex;
        } catch (InvalidFormatException ex) {
        	 throw ex;
        } catch (IOException ex) {
        	 throw ex;
        }
    }

    /**
     * 将报表结构转换成Map
     * @param excelColumns
     * @return void
     */
    private Map<Integer, String> convertExcelHeadToMap(List<ExcelColumn> excelColumns) {
        Map<Integer, String> excelHeadMap = new HashMap<Integer, String>();
        for (ExcelColumn excelColumn : excelColumns) {
            if(StringUtil.isEmpty(excelColumn.getFieldName())) {
                continue;
            } else {
                excelHeadMap.put(excelColumn.getIndex(), excelColumn.getFieldName());
            }
        }
        return excelHeadMap;
    }

    /**
     * 生成导出至Excel文件的数据
     * @param sheet 工作区间
     * @param excelColumns  excel表头
     * @param excelHeadMap  excel表头对应实体属性
     * @param excelHeadConvertMap   需要对数据进行特殊转换的列
     * @param dataList      导入excel报表的数据来源
     * @return void
     */
    @SuppressWarnings("rawtypes")
	private void buildExcelData(Sheet sheet, ExcelHead head, List<?> dataList) {
        List<ExcelColumn> excelColumns = head.getColumns(); 
        Map<String, Map> excelHeadConvertMap = head.getColumnsConvertMap();

        // 将表结构转换成Map
        Map<Integer, String> excelHeadMap = convertExcelHeadToMap(excelColumns);
        
        // 从第几行开始插入数据
        int startRow = head.getRowCount();
        int order = 1;
        for (Object obj : dataList) {
            Row row = sheet.createRow(startRow++);
            for (int j = 0; j < excelColumns.size(); j++) {
                Cell cell = row.createCell(j);
                cell.setCellType(excelColumns.get(j).getType());
                String fieldName = excelHeadMap.get(j);
                if(fieldName != null) {
                    Object valueObject = BeanUtil.getProperty(obj, fieldName);

                    // 如果存在需要转换的字段信息，则进行转换
                    if(excelHeadConvertMap != null && excelHeadConvertMap.get(fieldName) != null) {
                        valueObject = excelHeadConvertMap.get(fieldName).get(valueObject);
                    }

                    if(valueObject == null) {
                        cell.setCellValue("");
                    } else if (valueObject instanceof Integer) {
                        cell.setCellValue((Integer)valueObject);
                    } else if (valueObject instanceof String) {
                        cell.setCellValue((String)valueObject);
                    } else if (valueObject instanceof Date) {
                        cell.setCellValue(new JDateTime((Date)valueObject).toString("YYYY-MM-DD"));
                    } else {
                        cell.setCellValue(valueObject.toString());
                    }
                } else {
                    cell.setCellValue(order++);
                }
            }
        }
    }

    private String getCellValue(Cell cell){
    	
    	if(cell == null){
    		
    		return "";
    	}
    	String value = "";
		
		try{
	    
			switch (cell.getCellType()) {
	            case Cell.CELL_TYPE_NUMERIC:	               
	            	value = cell.getNumericCellValue() + "";
                  if (DateUtil.isCellDateFormatted(cell)) {
                	  value = new JDateTime(cell.getDateCellValue()).toString();
              } else {
              	   DecimalFormat df = new DecimalFormat("0");
                	value = df.format(cell.getNumericCellValue());
              }
	            	
	                break;
	            case Cell.CELL_TYPE_STRING:
	            	
	            	value = cell.getStringCellValue();
	            	break;
	        }
		}catch(Exception e){}
		
        return value;
    }
    /**
     * 将Excel文件内容转换为List对象
     * @param fis   excel文件
     * @return  List<List> list存放形式的内容
     * @throws IOException
     * @return List<List>
     */
    @SuppressWarnings("rawtypes")
	public List<List> excelFileConvertToList(FileInputStream fis) throws Exception {
        Workbook wb = WorkbookFactory.create(fis);

        Sheet sheet = wb.getSheetAt(0);
        
        int lastRowNum = sheet.getLastRowNum();
        int coloumNum=sheet.getRow(0).getPhysicalNumberOfCells();//获得总列数
        List<List> rows = new ArrayList<List>();
        for(int i = 0; i <= lastRowNum; i++){
            List<Object> cells = new ArrayList<Object>();
        	Row row = sheet.getRow(i);
        	for(int j=0;j<coloumNum;j++){
            	Cell cell = row.getCell(j);//
            	String cellstr=getCellValue(cell);
            	 cells.add(cellstr);
        	}
        	  rows.add(cells);        	
        }

//        List<List> rows = new ArrayList<List>();
//        for (Row row : sheet) {
//            List<Object> cells = new ArrayList<Object>();
//            for (Cell cell : row) {
//                Object obj = null;
//
//                CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
//                if(row.getRowNum()==2&&cell.getColumnIndex()==14){
//                	System.out.println("===================");
//                }
//                if(row.getRowNum()==2&&cell.getColumnIndex()==15){
//                	System.out.println("-----------------");
//                }
//                switch (cell.getCellType()) {
//                case Cell.CELL_TYPE_BLANK:
//                	obj = "";
//                	break;
//                    case Cell.CELL_TYPE_STRING:
//                        obj = cell.getRichStringCellValue().getString();
//                        break;
//                    case Cell.CELL_TYPE_NUMERIC:
//                        if (DateUtil.isCellDateFormatted(cell)) {
//                            obj = new JDateTime(cell.getDateCellValue());
//                        } else {
//                        	DecimalFormat df = new DecimalFormat("0");
//                            obj = df.format(cell.getNumericCellValue());
//                        }
//                        break;
//                    case Cell.CELL_TYPE_BOOLEAN:
//                        obj = cell.getBooleanCellValue();
//                        break;
//                    case Cell.CELL_TYPE_FORMULA:
//                        obj = cell.getNumericCellValue();
//                        break;
//                    default:
//                        obj = null;
//                }
//                cells.add(obj);
//            }
//            rows.add(cells);
//        }
        return rows;
    }

    /**
     * 根据Excel生成数据对象
     * @param excelHeadMap 表头信息
     * @param excelHeadConvertMap 需要特殊转换的单元
     * @param rows
     * @param cls 
     * @return void
     * @throws Exception 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private List buildDataObject(Map<Integer, String> excelHeadMap, Map<String, Map> excelHeadConvertMap, List<List> rows, Class cls) throws Exception {
        List contents = new ArrayList();
        for (List list : rows) {
            // 如果当前第一列中无数据,则忽略当前行的数据
        	  if(list != null && list.size()>0) {
		            if(list == null || list.get(0) == null) {
		                break;
		            }
		            // 当前行的数据放入map中,生成<fieldName, value>的形式
		            Map<String, Object> rowMap = rowListToMap(excelHeadMap, excelHeadConvertMap, list);
		
		            // 将当前行转换成对应的对象
		            Object obj = null;
		            try {
		                obj = cls.newInstance();
		            } catch (InstantiationException ex) {
		            	 throw ex;
		            } catch (IllegalAccessException ex) {
		            	 throw ex;
		            }
		            BeanUtil.populateBean(obj, rowMap);
		
		            contents.add(obj);
        	  }
        }
        return contents;
    }

    /**
     * 将行转行成map,生成<fieldName, value>的形式
     * @param excelHeadMap 表头信息
     * @param excelHeadConvertMap excelHeadConvertMap
     * @param list
     * @return
     * @return Map<String,Object>
     */
    @SuppressWarnings("rawtypes")
	private Map<String, Object> rowListToMap(Map<Integer, String> excelHeadMap, Map<String, Map> excelHeadConvertMap, List list) {
        Map<String, Object> rowMap = new HashMap<String, Object>();
        for(int i = 0; i < list.size(); i++) {
            String fieldName =  excelHeadMap.get(i);
            // 存在所定义的列
            if(fieldName != null) {
                Object value = list.get(i);
                if(excelHeadConvertMap != null && excelHeadConvertMap.get(fieldName) != null) {
                    value = excelHeadConvertMap.get(fieldName).get(value);
                }
                if(value!=null&&!"NULL".equals(value)&&!"null".equals(value)){
                	 rowMap.put(fieldName, value.toString().trim());
                }else{
                	rowMap.put(fieldName,"");
                }
               
            }
        }
        return rowMap;
    }
}