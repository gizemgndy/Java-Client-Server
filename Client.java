import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		//calculate sum of two integer numbers
		
		try {
		Socket mySocket=new Socket("localhost", 4000);
		InputStream input=mySocket.getInputStream();
		DataInputStream dataInput=new DataInputStream(input);
		
		String getMessage=dataInput.readUTF();//read the message from the channel
		
		OutputStream out=mySocket.getOutputStream();
		DataOutputStream dataOut=new DataOutputStream(out);
		
		
		System.out.println("Client I got the message:" +getMessage);
		dataOut.writeUTF("Client: Thanks server...");
		dataInput.close();
		input.close();
		mySocket.close();
		
		}catch (IOException e) {
			System.out.println("Client:"+e.getMessage());
		}
	}
}
