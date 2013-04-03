package study.openUrl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenUrl {
	public static void main(String[] args){
		try{  
			  	  URL   url   =   new   URL("http://vip.showji.com/locating/?m=13800138000&outfmt=json"); 
				  HttpURLConnection   httpConnection   =   (HttpURLConnection)url.openConnection();   
				  int   responseCode=httpConnection.getResponseCode();  
				  if(responseCode==200){
					  DataInputStream inFromServer=new DataInputStream(httpConnection.getInputStream());
					  BufferedReader reader =new BufferedReader(new InputStreamReader(inFromServer,"UTF8"));
					  //String data = reader.readLine();
					  //System.out.println("Return:"+data);
					  int testdata;
					  System.out.println("Hello:");
					  char[] wbuffer = new char[4096];
					  byte[] rBuffer = new byte[2];
					  //FileOutputStream out = new FileOutputStream("PhoneNumber.txt");
					  FileOutputStream out1 = new FileOutputStream(FileDescriptor.out);
					  //BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out,"UTF8"));
					  BufferedWriter writer1 = new BufferedWriter(new OutputStreamWriter(out1,"UTF8"));
					  /*while((testdata=reader.read())!=-1){
						  System.out.print("{");
						  writer1.write(testdata);
						  writer1.flush();
						  System.out.print(" = "+testdata);
						  System.out.print("}");

						  //Thread.sleep(1000);
					  }*/
					  while((testdata=inFromServer.read())!=-1){
						  System.out.print("{");
						  //writer1.write(testdata);
						  out1.write(testdata);
						  //writer1.flush();
						  out1.flush();
						  System.out.print(" = "+testdata);
						  System.out.print("}");

						  //Thread.sleep(1000);
					  }
					  
					  reader.close();
					  writer1.close();

				  }		
				  httpConnection.disconnect();
			  }  
		catch(Exception   e){
				  e.printStackTrace();
				  System.out.println("Connect Error");
				 
			  }   

	}
	
}
