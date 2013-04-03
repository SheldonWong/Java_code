import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;


public class Client {
	public static void main(String[] args){
		try{
			Socket connectToServer = new Socket("localhost",7777);
			DataInputStream inFromServer = new DataInputStream(connectToServer.getInputStream());
			DataOutputStream outToServer = new DataOutputStream(connectToServer.getOutputStream());
			System.out.println("Please enter radius of circle:(Enter \"bye\" to exit)");
			BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
			boolean goon =true;
			while(goon){
				String outStr=bufReader.readLine();
				outToServer.writeUTF(outStr);
				outToServer.flush();
				if(outStr.equals("bye")){
					goon=false;
				}else{
					String inStr=inFromServer.readUTF();
					System.out.println("The area of circle is:"+inStr);
				}							
			}
			connectToServer.close();
			inFromServer.close();
			outToServer.close();
		}catch(ConnectException e1){
			System.out.println("服务器未启动！");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	

}
