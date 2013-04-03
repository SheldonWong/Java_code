package com.study.jxl;


import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelToXml {
	public static void main(String args[]){
		try{
			Workbook workbook = Workbook.getWorkbook(new File("F:\\terry\\java_code\\ExcelApi\\myfile.xls"));
			Sheet sheet = workbook.getSheet(0); 	//获得第一个sheet
			
			GenEduXml gen = new GenEduXml();	//创建生成xml文件的实例
			gen.init();
			
			Cell[] a = sheet.getColumn(0); 	//获得第一列
			Cell[] b = sheet.getColumn(1);
			Cell[] c = sheet.getColumn(2); 
			Cell[] d = sheet.getColumn(3); 
			Cell[] e = sheet.getColumn(4); 
			
			for(int i=0;i<a.length;i++){
				gen.addOneItem(a[i].getContents(), b[i].getContents(), c[i].getContents(), d[i].getContents(), e[i].getContents());
			}
			workbook.close();
			gen.toXml();	
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Hello world!!");
	}
}
