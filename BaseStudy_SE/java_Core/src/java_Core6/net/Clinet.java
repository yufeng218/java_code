package java_Core6.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Clinet {

	public static void main(String[] args) {
		try {
			System.out.println("======== �ͻ��� =======");
			Socket socket = new Socket("127.0.0.1",9900);
			System.out.println("�ͻ������ӵ������");
			
			//��һ�����ݷ��͸�������
			BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
			String str = br.readLine();
			
			//д���������� --- �������˶�����
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			out.println(str);
			
			// =============== ��ȡ���Է������˵����� ================
			BufferedReader br1 = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			String string1 = br1.readLine();
			System.out.println("�յ�����˵���Ϣ"+string1);
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
