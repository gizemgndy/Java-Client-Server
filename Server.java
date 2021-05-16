import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) {
		
		
		try {
			
			ServerSocket serverSocket=new ServerSocket(4000); //don't use port less than 1023
			System.out.println("Server: I am waiting fo a client...");
			Socket socket=new ServerSocket().accept();//waiting for a connection from a client
			System.out.println("Server . Hi I have client");
			
			
			//to sent data...
			OutputStream out= socket.getOutputStream();//get output stream for the channel
			DataOutputStream dataOut=new DataOutputStream(out);
			InputStream input=socket.getInputStream();
			DataInputStream dataInput=new DataInputStream(input);
			
			//send a message to the client...
			dataOut.writeUTF("Server: Hi client,welcome...");//write to 
			System.out.println(dataInput.readUTF());
			dataOut.close();
			out.close();
			socket.close();
			
		}
		catch (IOException e) {
			System.out.println("Server" +e.getMessage());
		}
		
	}

}
