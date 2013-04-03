package study.openUrl;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.stream.JsonReader;

public class TestJson {

		public String[] query(String mobile){ 
		try{  	  
			  	  URL   url   =   new   URL("http://vip.showji.com/locating/?m="+mobile+"&outfmt=json"); 
				  HttpURLConnection   httpConnection   =   (HttpURLConnection)url.openConnection();   
				  int   responseCode=httpConnection.getResponseCode();  
				  if(responseCode==200){
					  DataInputStream inFromServer=new DataInputStream(httpConnection.getInputStream());	  
					  JsonReader reader = new JsonReader(new InputStreamReader(inFromServer, "UTF-8"));
					  FileOutputStream out = new FileOutputStream("GsonText.txt",true);
					  BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out,"UTF8"));
					  String phoneNumber = "no";
					  String province = "no";	
					  String city="no";
					  String temp="";
					    	 reader.beginObject();
					    	 while (reader.hasNext()) {
					    		 String name = reader.nextName();
					    		 if (name.equals("Mobile")) {
					    			 phoneNumber = reader.nextString();
					    	       } else if (name.equals("Province")) {
					    	    	   province = reader.nextString();
					    	       }else if (name.equals("City")) {
					    	    	   city = reader.nextString();
					    	       }else {
					    	           reader.skipValue();
					    	       }
					    	 }
					     System.out.println(phoneNumber+": "+province+" "+city);
					     String[] values ={phoneNumber+"",province,city};
					     String lineSeparator = ""+System.getProperty("line.separator");   
					     writer.write(phoneNumber);
					     writer.write(province);
					     writer.write(city+lineSeparator);				    		 
					     writer.flush();
					     writer.close();
					     reader.close();
					     inFromServer.close();
					     return values;
				  }
			  }  
		catch(Exception   e){
				  e.printStackTrace();				 
			  }
		return null;   

	}
}
