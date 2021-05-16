import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


public class UDPServer {
	public static void main(String[] args) {
		try {
			DatagramSocket dsocket=new DatagramSocket(9000);//we have a port 
			byte [] buffer=new byte[1000];
			while(true) {
				DatagramPacket request=new DatagramPacket(buffer, buffer.length);//packet
				
				System.out.println("UDP server is waiting for a request");
				
				dsocket.receive(request); //waiting for a request
				
				DatagramPacket reply =new DatagramPacket(request.getData(),request.getLength(),request.getAddress(),request.getPort());
				dsocket.send(reply); //send data to client 
				
				dsocket.close();
				
			}
		}catch (SocketException e) {
			System.out.println("UDP server socket:"+e.getMessage());
		}
		catch (IOException e) {
			System.out.println("UDP server socket:"+e.getMessage());
		}
	}
	
}
