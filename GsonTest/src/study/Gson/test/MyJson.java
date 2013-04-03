package study.Gson.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.stream.JsonReader;

public class MyJson {

		public void getJsonFirst(String mobile){ 
		try{  	  
			  	  URL   url   =   new   URL("http://vip.showji.com/locating/?m="+mobile+"&outfmt=json"); 
				  HttpURLConnection   httpConnection   =   (HttpURLConnection)url.openConnection();   
				  int   responseCode=httpConnection.getResponseCode();  
				  if(responseCode==200){
					  DataInputStream inFromServer=new DataInputStream(httpConnection.getInputStream());	  
					  BufferedReader reader =new BufferedReader(new InputStreamReader(inFromServer,"UTF8"));
					  FileOutputStream out = new FileOutputStream("GsonText.txt");
					  BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out,"UTF8"));
					  int jsonData =0;
					  writer.write("[");		  
					  	while((jsonData=reader.read())!=-1){
					  		writer.write(jsonData);
					  	}
				  		 writer.flush();
					     writer.close();
					     reader.close();
					     inFromServer.close();
				  }
			  }  
		catch(Exception   e){
				  e.printStackTrace();				 
			  }
	}
		public void getJsons(String mobile){ 
			try{  	  
				  	  URL   url   =   new   URL("http://vip.showji.com/locating/?m="+mobile+"&outfmt=json"); 
					  HttpURLConnection   httpConnection   =   (HttpURLConnection)url.openConnection();   
					  int   responseCode=httpConnection.getResponseCode();  
					  if(responseCode==200){
						  DataInputStream inFromServer=new DataInputStream(httpConnection.getInputStream());	  
						  BufferedReader reader =new BufferedReader(new InputStreamReader(inFromServer,"UTF8"));
						  FileOutputStream out = new FileOutputStream("GsonText.txt",true);
						  BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out,"UTF8"));
						  int jsonData =0;
						  	while((jsonData=reader.read())!=-1){
						  		writer.write(jsonData);
						  	}
						  	 writer.write(",");
						     writer.flush();
						     writer.close();
						     reader.close();
						     inFromServer.close();
					  }
				  }  
			catch(Exception   e){
					  e.printStackTrace();				 
				  }
		}
		public void getJsonLast(String mobile){
			try{  	  
				  	  URL   url   =   new   URL("http://vip.showji.com/locating/?m="+mobile+"&outfmt=json"); 
					  HttpURLConnection   httpConnection   =   (HttpURLConnection)url.openConnection();   
					  int   responseCode=httpConnection.getResponseCode();  
					  if(responseCode==200){
						  DataInputStream inFromServer=new DataInputStream(httpConnection.getInputStream());	  
						  BufferedReader reader =new BufferedReader(new InputStreamReader(inFromServer,"UTF8"));
						  FileOutputStream out = new FileOutputStream("GsonText.txt",true);
						  BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out,"UTF8"));
						  int jsonData =0;
						  	while((jsonData=reader.read())!=-1){
						  		writer.write(jsonData);
						  	}
						  	 writer.write("]");
						     writer.flush();
						     writer.close();
						     reader.close();
						     inFromServer.close();
					  }
				  }  
			catch(Exception   e){
					  e.printStackTrace();				 
				  }
		}
}
