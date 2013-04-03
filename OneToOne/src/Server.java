import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	public static void main(String[] args){
		try{
			ServerSocket connectToClient = new ServerSocket(1234);
			Socket clientSocket = connectToClient.accept();
			DataInputStream inFromClient = new DataInputStream(clientSocket.getInputStream());
			DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());
			boolean goon = true;
			
			while(goon){
				String inStr = inFromClient.readUTF();
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
			connectToClient.close();
			inFromClient.close();
			outToClient.close();
			}catch(Exception e){
			e.printStackTrace();
		}
	}

}
