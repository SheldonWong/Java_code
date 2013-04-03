package study.openUrl;

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
			TestJson getData = new TestJson();
			for(int i=0;i<a.length;i++){
				Thread.sleep(5000);
				String[] datas=getData.query(a[i].getContents());			
			}
			workbook.close();	  			  
			  }  
		catch(Exception   e){
				  e.printStackTrace();
				  System.out.println("Connect Error");				 
			  }   

	}
	
}
