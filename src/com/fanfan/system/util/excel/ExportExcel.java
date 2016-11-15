package com.fanfan.system.util.excel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.ClientAnchor;

/**
 * <p> ExportExcel.java </p>
 * <p> {功能说明} </p>
 */
/**
 * 利用开源组件POI3.0.2动态导出EXCEL文档 转载时请保留以下信息，注明出处！
 * 
 * @author jijun.liu
 * @version v1.0
 * @param <T>应用泛型，代表任意一个符合javabean风格的类
 *        注意这里为了简单起见，boolean型的属性xxx的get器方式为getXxx(),而不是isXxx() byte[]表jpg格式的图片数据
 */
public class ExportExcel<T> {

	// 行号
	private int index = 0;

	/**
	 * 无sheet名，无标题栏.
	 * 
	 * @param dataset
	 * @param out
	 */
	public void exportExcel(Collection<T> dataset, OutputStream out) {
		exportExcel("sheet1", null, dataset, out, "yyyy-MM-dd");
	}

	/**
	 * 无sheet名，有标题栏.
	 * 
	 * @param headers
	 * @param dataset
	 * @param out
	 */
	public void exportExcel(String[] headers, Collection<T> dataset,
			OutputStream out) {
		exportExcel("sheet1", headers, dataset, out, "yyyy-MM-dd");
	}

	/**
	 * 有sheet名，有标题栏.
	 * 
	 * @param sheetTitle
	 *            工作表名称
	 * @param headers
	 *            第一行表头
	 * @param dataset
	 *            数据集合
	 * @param out
	 *            输出流
	 * @param keyStrings
	 *            对应的T的参数名或者KEY
	 */
	public void exportExcel(String sheetTitle, String[] headers,
			Collection<T> dataset, OutputStream out, Object... keyStrings) {
		exportExcel(sheetTitle, headers, dataset, out, "yyyy-MM-dd", keyStrings);
	}

	/**
	 * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上
	 * 
	 * 增加了JAVABEAN 导出的列的设置
	 * 
	 * @param title
	 *            表格标题名
	 * @param headers
	 *            表格属性列名数组
	 * @param dataset
	 *            需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
	 *            javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
	 * @param out
	 *            与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
	 * @param pattern
	 *            如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
	 */
	private void exportExcel(String title, String[] headers,
			Collection<T> dataset, OutputStream out, String pattern,
			Object... keyStrings) {
		index = 0;
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth(15);

		// 声明一个画图的顶级管理器
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();

		// 定义注释的大小和位置,详见文档
		// HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
		// 0, 0, 0, (short) 4, 2, (short) 6, 5));
		// 设置注释内容
		// comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
		// 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
		// comment.setAuthor("leno");

		// 产生表格标题行
		if (headers != null && headers.length > 0) {

			// 生成一个样式
			HSSFCellStyle style = workbook.createCellStyle();
			// 设置这些样式
			style.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			// 生成一个字体
			HSSFFont font = workbook.createFont();
			font.setColor((short) 20);
			font.setFontHeightInPoints((short) 12);
			style.setWrapText(true);
			// font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			// 把字体应用到当前的样式
			style.setFont(font);

			HSSFRow row = sheet.createRow(index);
			for (int i = 0; i < headers.length; i++) {
				HSSFCell cell = row.createCell(i);
				cell.setCellStyle(style);
				HSSFRichTextString text = new HSSFRichTextString(headers[i]);
				cell.setCellValue(text);
			}
			index++;
		}
		// 遍历集合数据，产生数据行
		putDateset2Rows(dataset, pattern, workbook, sheet, patriarch,
				keyStrings);

		try {
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 遍历集合数据，产生数据行.
	 * 
	 * @param dataset
	 * @param pattern
	 * @param workbook
	 * @param sheet
	 * @param style2
	 * @param patriarch
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void putDateset2Rows(Collection<T> dataset, String pattern,
			HSSFWorkbook workbook, HSSFSheet sheet, HSSFPatriarch patriarch,
			Object... keyStrings) {
		HSSFRow row;
		if (dataset != null && dataset.size() > 0) {

			// 生成并设置一个样式
			HSSFCellStyle style2 = workbook.createCellStyle();
			// style2.setFillForegroundColor(HSSFColor.BLACK.index);
			// style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			// 生成另一个字体
			HSSFFont font2 = workbook.createFont();
			font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
			// 把字体应用到当前的样式
			style2.setFont(font2);

			Iterator<T> it = dataset.iterator();

			boolean typeFlag = true;// 集合类型,如果是map则执行相关方法
			boolean mapType = false;// Collection内的集合类型,多种类型后用 case

			String[] keyArray = null;
			while (it.hasNext()) {
				row = sheet.createRow(index);

				// 第一次判断Collection内数据类型，有且仅执行一次判断
				T t = (T) it.next();
				if (typeFlag) {
					if (t instanceof Map) {
						mapType = true;
					} else {
						typeFlag = false;
					}
				}

				if (mapType) {
					// 集合为map类型,执行map所用的方法

					if (typeFlag) {
						typeFlag = false;

						if (keyStrings != null) {
							keyArray = (String[]) keyStrings;
						} else {
							Set<String> s = ((Map) t).keySet();
							keyArray = s.toArray(new String[s.size()]);
						}
					}

					for (int i = 0; i < keyArray.length; i++) {
						Object value = ((Map) t).get(keyArray[i]);
						HSSFCell cell = row.createCell(i);
						// HSSFCell cell = row.createCell(i,
						// HSSFCell.CELL_TYPE_STRING);
						cell.setCellStyle(style2);
						putOneRow(pattern, workbook, sheet, patriarch, row, i,
								cell, value);
					}

				} else {
					// 其它类型(Bean)操作继续,用 反射执行写入
					// 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
					Field[] fields = t.getClass().getDeclaredFields();
					if (keyStrings != null) {
						keyArray = (String[]) keyStrings;
						if (keyArray != null && keyArray.length > 0) {
							try {
								String getMethodName = "";
								for (int i = 0; i < keyArray.length; i++) {
									HSSFCell cell = row.createCell(i);
									cell.setCellStyle(style2);
									String[] ks = StringUtils.split(
											keyArray[i], '.');
									Class tCls = t.getClass();
									Object value = null;
									for (String k : ks) {
										getMethodName = "get"
												+ k.substring(0, 1)
														.toUpperCase()
												+ k.substring(1);
										Method getMethod = tCls.getMethod(
												getMethodName, new Class[] {});
										value = getMethod.invoke(
												value == null ? t : value,
												new Object[] {});

										// 找不到数据或者数据为空
										if (value == null) {
											value = "";
											break;
										}
										tCls = value.getClass();
									}
									putOneRow(pattern, workbook, sheet,
											patriarch, row, i, cell, value);
								}
							} catch (SecurityException e) {
								e.printStackTrace();
							} catch (NoSuchMethodException e) {
								e.printStackTrace();
								continue;
							} catch (IllegalArgumentException e) {
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								e.printStackTrace();
							} finally {
							}
						}
					} else {
						for (int i = 0; i < fields.length; i++) {
							HSSFCell cell = row.createCell(i);
							// HSSFCell cell = row.createCell(i,
							// HSSFCell.CELL_TYPE_STRING);
							cell.setCellStyle(style2);
							Field field = fields[i];
							String fieldName = field.getName();
							String getMethodName = "get"
									+ fieldName.substring(0, 1).toUpperCase()
									+ fieldName.substring(1);

							try {
								Class tCls = t.getClass();
								Method getMethod = tCls.getMethod(
										getMethodName, new Class[] {});
								Object value = getMethod.invoke(t,
										new Object[] {});

								putOneRow(pattern, workbook, sheet, patriarch,
										row, i, cell, value);
							} catch (SecurityException e) {
								e.printStackTrace();
							} catch (NoSuchMethodException e) {
								e.printStackTrace();
								continue;
							} catch (IllegalArgumentException e) {
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								e.printStackTrace();
							} finally {
							}

						}
					}
				}

				index++;
			}
		}
	}

	/**
	 * 设置一行记录.
	 * 
	 * @param pattern
	 * @param workbook
	 * @param sheet
	 * @param patriarch
	 * @param row
	 * @param i
	 * @param cell
	 * @param value
	 */
	private void putOneRow(String pattern, HSSFWorkbook workbook,
			HSSFSheet sheet, HSSFPatriarch patriarch, HSSFRow row, int i,
			HSSFCell cell, Object value) {
		String textValue = null;
		// if (value instanceof Integer) {
		// int intValue = (Integer) value;
		// cell.setCellValue(intValue);
		// } else if (value instanceof Float) {
		// float fValue = (Float) value;
		//
		// cell.setCellValue(new HSSFRichTextString(String.valueOf(fValue)));
		// // textValue = new HSSFRichTextString(String
		// // .valueOf(fValue));
		// // cell.setCellValue(textValue);
		// } else if (value instanceof Double) {
		// double dValue = (Double) value;
		// cell.setCellValue(new HSSFRichTextString(String.valueOf(dValue)));
		// // textValue = new HSSFRichTextString(String
		// // .valueOf(dValue));
		// // cell.setCellValue(textValue);
		// } else if (value instanceof Long) {
		// long longValue = (Long) value;
		// cell.setCellValue(longValue);
		// }

		// if (value instanceof Boolean) {
		// boolean bValue = (Boolean) value;
		// textValue = "true";
		// if (!bValue) {
		// textValue = "false";
		// }
		// } else
		if (value instanceof Date) {
			Date date = (Date) value;
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			textValue = sdf.format(date);
		} else if (value instanceof byte[]) {
			// 有图片时，设置行高为60px;
			row.setHeightInPoints(60);
			// 设置图片所在列宽度为80px,注意这里单位的一个换算
			sheet.setColumnWidth(i, (short) (35.7 * 80));
			// sheet.autoSizeColumn(i);
			byte[] bsValue = (byte[]) value;
			HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 1023, 255,
					(short) 6, index, (short) 6, index);
			anchor.setAnchorType(ClientAnchor.AnchorType.MOVE_DONT_RESIZE);
			patriarch.createPicture(anchor, workbook.addPicture(bsValue,
					HSSFWorkbook.PICTURE_TYPE_JPEG));
		} else {
			// 其它数据类型都当作字符串简单处理
			textValue = value != null ? value.toString() : "";

		}
		// 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
		if (textValue != null) {
			// Pattern p = Pattern.compile("^\\d+(\\.\\d+)?$");
			// Matcher matcher = p.matcher(textValue);
			// if (matcher.matches()) {
			// // 是数字当作double处理
			// cell.setCellValue(Double.parseDouble(textValue));
			// } else {
			HSSFRichTextString richString = new HSSFRichTextString(textValue);
			// HSSFFont font3 = workbook.createFont();
			// font3.setColor(HSSFColor.BLUE.index);
			// richString.applyFont(font3);
			cell.setCellValue(richString);
			// }
		}
	}

	public static void main(String[] args) {
		// 测试学生
		// ExportExcel<SqrJbxx> ex = new ExportExcel<SqrJbxx>();
		// String[] headers = { "学号", "姓名", "年龄", "性别", "出生日期" };
		// List<SqrJbxx> dataset = new ArrayList<SqrJbxx>();
		// dataset.add(new SqrJbxx(1L));
		// dataset.add(new SqrJbxx(2L));
		// 测试图书
		// ExportExcel<Book> ex2 = new ExportExcel<Book>();
		// String[] headers2 = { "图书编号", "图书名称" };
		// List<Book> dataset2 = new ArrayList<Book>();
		// try {
		// BufferedInputStream bis = new BufferedInputStream(
		// new FileInputStream("d:\\book.jpg"));
		// byte[] buf = new byte[bis.available()];
		// while ((bis.read(buf)) != -1) {
		//
		// }
		// dataset2.add(new Book(1, "jsp", "leno", 300.33f, "1234567",
		// "清华出版社", buf));
		// OutputStream out = new FileOutputStream("D:\\a2.xls");
		// ex.exportExcel("", headers, null, out);
		// // ex.exportExcel(headers, dataset, out);
		// out.close();

		// JOptionPane.showMessageDialog(null, "导出成功!");
		// System.out.println("excel导出成功！");
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}

	/**
	 * 导出到Excel方法
	 * 
	 * @param title
	 *            String[] 标题数组
	 * @param list
	 *            需要导出的数据
	 * @param model
	 */
	public InputStream execute(String[] title, List<T> list, Object model) {
		HSSFWorkbook wk = new HSSFWorkbook();
		HSSFSheet sheet = wk.createSheet("sheet1");

		HSSFRow row = sheet.createRow(0);

		HSSFCell cell;

		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(new HSSFRichTextString(title[i]));
		}

		for (int i = 0; i < list.size(); ++i) {
			model = list.get(i);
			row = sheet.createRow(i + 1);
			Method[] method = model.getClass().getMethods();
			int num = 0;
			for (int j = 0; j < method.length; j++) {
				if (method[j].getName().substring(0, 3).equals("get")
						&& method[j].getName() != "getClass") {
					Method m;
					try {
						m = model.getClass().getMethod(method[j].getName());
						Object result = m.invoke(model);
						cell = row.createCell(num++);
						if (result != null) {
							cell.setCellValue(new HSSFRichTextString(result
									.toString()));
						} else {
							cell.setCellValue(new HSSFRichTextString("-"));
						}
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}

				}
			}

		}
		ByteArrayOutputStream os = new ByteArrayOutputStream();

		try {
			wk.write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}

		byte[] content = os.toByteArray();

		InputStream is = new ByteArrayInputStream(content);
		try {
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return is;

	}
	
	/**
	 * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上
	 * 
	 * 增加了JAVABEAN 导出的列的设置
	 * 
	 * @param title
	 *            表格标题名
	 * @param headers
	 *            表格属性列名数组
	 * @param dataset
	 *            需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
	 *            javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
	 * @param out
	 *            与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
	 * @param pattern
	 *            如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
	 */
	public void writeExcel(String title, String[] headers,
			Collection<T> dataset, String pattern,String fileName,
			Object... keyStrings) {
		index = 0;
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度为20个字节
		sheet.setDefaultColumnWidth(20);

		// 声明一个画图的顶级管理器
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();

		// 定义注释的大小和位置,详见文档
		// HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
		// 0, 0, 0, (short) 4, 2, (short) 6, 5));
		// 设置注释内容
		// comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
		// 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
		// comment.setAuthor("leno");

		// 产生表格标题行
		if (headers != null && headers.length > 0) {

			// 生成一个样式
			HSSFCellStyle style = workbook.createCellStyle();
			// 设置这些样式
			style.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中

			// 生成一个字体
			HSSFFont font = workbook.createFont();
			font.setColor((short) 20);
			font.setFontHeightInPoints((short) 12);
			style.setWrapText(true);
			// font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			// 把字体应用到当前的样式
			style.setFont(font);

			HSSFRow row = sheet.createRow(index);
			for (int i = 0; i < headers.length; i++) {
				HSSFCell cell = row.createCell(i);
				cell.setCellStyle(style);
				HSSFRichTextString text = new HSSFRichTextString(headers[i]);
				cell.setCellValue(text);
			}
			index++;
		}
		// 遍历集合数据，产生数据行
		putDateset2Rows(dataset, pattern, workbook, sheet, patriarch,
				keyStrings);
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File(fileName));
			workbook.write(fos);
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 输入EXCEL文件
	 * 
	 * @param fileName
	 *            文件名
	 */
	public void outputExcel(String fileName, HSSFWorkbook wb)throws Exception {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File(fileName));
			wb.write(fos);
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
	

}
