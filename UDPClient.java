import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient {
public static void main(String[] args) {
	try {
		DatagramSocket dsocket=null;
		String message="Hello UDP Server...Greetings from UDP client";
		
		
		byte [] buffer=message.getBytes();
		InetAddress aHost=InetAddress.getByName("127.0.0.1");
		int port=9000;
		
		//let us make a packet
		dsocket=new DatagramSocket();//no port number
		DatagramPacket reqest=new DatagramPacket(buffer, buffer.length,aHost,port);// yes, ý hava a packet
		
		//send this packet to server
		dsocket.send(reqest); //I am sending...
		
		//get data from the UDP server...
		
		byte [] messageServer=new byte[1000];
		DatagramPacket reply= new DatagramPacket(messageServer, messageServer.length);
		dsocket.receive(reply); // get the data...
		String data=new String(reply.getData());
		System.out.println("Client the data from server is:" + data);
		 dsocket.close();
		 
		
	}
	catch (SocketException e) {
		// TODO: handle exception
	}
	catch (IOException e) {
		// TODO: handle exception
	}
	
}
}
