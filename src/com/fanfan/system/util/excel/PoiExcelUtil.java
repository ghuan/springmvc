package com.fanfan.system.util.excel;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class PoiExcelUtil {
	@SuppressWarnings("deprecation")
	public void readXlsx() throws IOException{   
   String fileName = "D:\\excel\\test.xlsx";   
   XSSFWorkbook xssfWorkbook = new XSSFWorkbook( fileName);   
      
   // 循环工作表Sheet   
   for(int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++){   
     XSSFSheet xssfSheet = xssfWorkbook.getSheetAt( numSheet);   
     if(xssfSheet == null){   
       continue;   
     }   
        
     // 循环行Row    
     for(int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++ ){   
       XSSFRow xssfRow = xssfSheet.getRow( rowNum);   
       if(xssfRow == null){   
         continue;   
       }   
          
       // 循环列Cell      
       for(int cellNum = 0; cellNum <= xssfRow.getLastCellNum(); cellNum++){   
         XSSFCell xssfCell = xssfRow.getCell( cellNum);
         if(xssfCell == null){   
           continue;   
         }   
         System.out.print("   "+getValue(xssfCell));   
       }   
       System.out.println();   
     }   
   }   
 }
@SuppressWarnings("static-access")   
	 private String getValue(XSSFCell xssfCell){  
	   if(xssfCell.getCellType() == xssfCell.CELL_TYPE_BOOLEAN){   
	     return String.valueOf( xssfCell.getBooleanCellValue()+"------"+xssfCell.getRowIndex()+"行 "+xssfCell.getColumnIndex()+"列  ;;");     
	   }else if(xssfCell.getCellType() == xssfCell.CELL_TYPE_NUMERIC){   
		   if (HSSFDateUtil.isCellDateFormatted(xssfCell)) {   
		        double d = xssfCell.getNumericCellValue();   
		        Date date = HSSFDateUtil.getJavaDate(d);  
		        SimpleDateFormat sf=new SimpleDateFormat("yyyyMMdd");System.out.println(sf.format(date));
		        return sf.format(date).toString();
		    } 
		   else
		   {
			   xssfCell.setCellType(xssfCell.CELL_TYPE_STRING);//数字型全部转为字符型
			     return String.valueOf( xssfCell.getStringCellValue()+"------"+xssfCell.getRowIndex()+"行 "+xssfCell.getColumnIndex()+"列  ;;");  
		   }
	   }else{   
	     return String.valueOf( xssfCell.getStringCellValue()+"------"+xssfCell.getRowIndex()+"行 "+xssfCell.getColumnIndex()+"列  ;;");   
	   }   
	 }
	
}
