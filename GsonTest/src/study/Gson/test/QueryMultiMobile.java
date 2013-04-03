package study.Gson.test;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class QueryMultiMobile {
	public static void main(String[] args){
		try{  
			Workbook workbook = Workbook.getWorkbook(new File("F:\\terry\\java_code\\ConnectWeb\\numbers.xls"));
			Sheet sheet = workbook.getSheet(0); 		
			Cell[] a = sheet.getColumn(0);
			MyJson myJson = new MyJson();
			myJson.getJsonFirst(a[0].getContents());
			for(int i=1;i<a.length-1;i++){
				Thread.sleep(1000);
				myJson.getJsons(a[i].getContents());			
			}
			myJson.getJsonLast(a[a.length-1].getContents());
			workbook.close();	  			  
			  }  
		catch(Exception   e){
				  e.printStackTrace();
				  System.out.println("Connect Error");				 
			  }   
	}
	
}
