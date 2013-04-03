import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server extends ServerSocket{
	
	private static final int port=7777;
	public Server() throws IOException {
		super(port);
		try{
			while(true){
				Socket fromClient = accept();
				new createThreadSocket(fromClient);
			}
		}catch(Exception e){
			
		}finally{
			close();
		}
	}
	
	class createThreadSocket extends Thread{
		private DataInputStream inFromClient;
		private DataOutputStream outToClient;
		public createThreadSocket(Socket s)throws IOException{
			inFromClient = new DataInputStream(s.getInputStream());
			outToClient = new DataOutputStream(s.getOutputStream());
			start();
		}
		public void run(){
			try{
				boolean goon = true;
				
				while(goon){
					String inStr = inFromClient.readUTF();
					System.out.println("接收到的数据为:"+inStr);
					if(inStr.equals("bye")){
					goon = false;
					}else{
					double r=Double.valueOf(inStr);
					double area = r*r*Math.PI;
					String outStr = Double.toString(area);
					outToClient.writeUTF(outStr);
					outToClient.flush();
					}
				}
				outToClient.close();
				inFromClient.close();
			}catch(Exception e){
				
			}
		}
	}
	
	public static void main(String[] args)throws IOException{
		
		new Server();
	}
}
