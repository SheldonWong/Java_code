package com.study.jxl;


import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.*;

public class ReadExcel {
	
	public static void main(String args[]){
		try{
			Workbook workbook = Workbook.getWorkbook(new File("F:\\code_android\\ExcelApi\\myfile.xls"));
			Sheet sheet = workbook.getSheet(0); 
			
			Cell a1 = sheet.getCell(0,0); 
			Cell b2 = sheet.getCell(1,1); 
			Cell c2 = sheet.getCell(2,1); 

			String stringa1 = a1.getContents(); 
			String stringb2 = b2.getContents(); 
			String stringc2 = c2.getContents(); 
			
			System.out.println(stringa1);
			System.out.println(stringb2);
			System.out.println(stringc2);
			
			workbook.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Hello world!!");
	}

}
