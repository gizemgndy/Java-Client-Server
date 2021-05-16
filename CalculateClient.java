import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class CalculateClient {

	public static void main(String[] args) {
		//calculate sum of two integer numbers
		
		try {
		Socket mySocket=new Socket("localhost", 8000);
		
		
		OutputStream out=mySocket.getOutputStream();
		DataOutputStream dataOut=new DataOutputStream(out);
		dataOut.writeUTF("add:10:20");//send this message to server
		System.out.println("Client is writing...");
		//get the result 
		InputStream input=mySocket.getInputStream();
		DataInputStream dataInput=new DataInputStream(input);
		
		String result=dataInput.readUTF();
		System.out.println("Client: the result is:" +result);

		
		dataInput.close();
		input.close();
		mySocket.close();
		
		}catch (IOException e) {
			System.out.println("Client:"+e.getMessage());
		}
	}
}
