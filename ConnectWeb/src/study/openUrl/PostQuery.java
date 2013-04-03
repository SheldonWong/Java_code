package study.openUrl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


class PostQuery{
	public static void genTXT(InputStream is) {                    
        String line = null;    
        try {  
        	BufferedReader reader = new BufferedReader(new InputStreamReader(is,"UTF-8")); 
        	FileOutputStream out = new FileOutputStream("D:/posttest.txt",true);
    		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out,"UTF-8"));
            while ((line = reader.readLine()) != null) {
                writer.write(StringEscapeUtils.unescapeHtml(line + "\n"));
                writer.flush();
            }
            reader.close();
        } catch (IOException e) {    
            e.printStackTrace();    
        } finally {    
            try {    
                is.close();    
            } catch (IOException e) {    
               e.printStackTrace();    
            }    
        }       
    }
	public static void main(String[] args) throws Exception{
	DefaultHttpClient httpclient = new DefaultHttpClient();
	HttpHost target = new HttpHost("183.60.52.75", 80, "http");
	HttpPost httpPost = new HttpPost("/login.php");
	List <NameValuePair> nvps = new ArrayList <NameValuePair>();
    nvps.add(new BasicNameValuePair("username", "content_checker"));
    nvps.add(new BasicNameValuePair("password", "sup#n860"));
    nvps.add(new BasicNameValuePair("x","40"));
    nvps.add(new BasicNameValuePair("y","10"));
    httpPost.setEntity(new UrlEncodedFormEntity(nvps));
    HttpResponse response1 = httpclient.execute(target,httpPost);
    httpPost.releaseConnection();
    HttpResponse response2;
    for(int i=0;i<=390;i+=30){
    httpPost = new HttpPost("//articleQuery.php?category=311&start="+i);
    List <NameValuePair> nvps_content = new ArrayList <NameValuePair>();
    nvps_content.add(new BasicNameValuePair("start_time", "2012-04-08"));
    nvps_content.add(new BasicNameValuePair("end_time", "2012-04-30"));
    nvps_content.add(new BasicNameValuePair("status", "4")); 
    httpPost.setEntity(new UrlEncodedFormEntity(nvps_content));
    response2 = httpclient.execute(target,httpPost);
    try {
        System.out.println(response1.getStatusLine());
        HttpEntity entity = response2.getEntity();
        // do something useful with the response body
        // and ensure it is fully consumed
        if (entity != null) {     
           InputStream instreams = entity.getContent();     
           genTXT(instreams);   
            System.out.println("Do something");  
          // Do not need the rest         
       } 
        EntityUtils.consume(entity);
        System.out.println(response1);
        System.out.println(response2);
        httpPost.releaseConnection();
    }catch(Exception e){
    	e.printStackTrace();
    }
	}
    httpclient.getConnectionManager().shutdown();   
}
}