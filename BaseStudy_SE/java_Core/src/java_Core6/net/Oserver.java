package java_Core6.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

public class Oserver {

	public static void main(String[] args) {
		
		try {
			
			ServerSocket s = new ServerSocket(9009);
			System.out.println("������Ѿ�����...");
			Socket socket = s.accept(); //���տͻ��˷���
			
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			User user = (User) ois.readObject(); //���ͻ��˷��͵Ķ���
			System.out.println(user);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
