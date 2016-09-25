package java_Core6.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

public class Oserver {

	public static void main(String[] args) {
		
		try {
			
			ServerSocket s = new ServerSocket(9009);
			System.out.println("服务端已经开启...");
			Socket socket = s.accept(); //接收客户端访问
			
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			User user = (User) ois.readObject(); //读客户端发送的对象
			System.out.println(user);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
