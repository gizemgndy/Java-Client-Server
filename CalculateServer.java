import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculateServer {
	
	private Calculate calculate=new Calculate();
	
	public static void main(String[] args) {
		
		Calculate calculate=new Calculate();
		int result=0;
		try {
			
			ServerSocket serverSocket=new ServerSocket(8000); //don't use port less than 1023
			System.out.println("server is waiting...");
			Socket socket=new ServerSocket().accept();//waiting for a connection from a client
	
			
			//to sent data...
			//OutputStream out= socket.getOutputStream();//get output stream for the channel
			//DataOutputStream dataOut=new DataOutputStream(out);
			
			InputStream input=socket.getInputStream();
			DataInputStream dataInput=new DataInputStream(input);
			
			//send a message to the client...
			String data =dataInput.readUTF();//we have "add:10:20"
			
			System.out.println("Server get the message:" +data);
			String [] message=data.split(":");//we have message[0]="add", message[1]="10", message[2]="30",
			if(message[0].equals("add")){
					result=calculate.add(Integer.parseInt(message[1]), Integer.parseInt(message[2]));
			}
					else if (message[0].equals("sub")) {
					//call the "sub" method...
				}
			//System.out.println("S");
			OutputStream out= socket.getOutputStream();//get output stream for the channel
			DataOutputStream dataOut=new DataOutputStream(out);
			dataOut.writeUTF(result+"");
			
			
		        dataOut.close();
			 	out.close();
				socket.close();

		
		}
		catch (IOException e) {
			System.out.println("Server" +e.getMessage());
		}
		
	}

}
