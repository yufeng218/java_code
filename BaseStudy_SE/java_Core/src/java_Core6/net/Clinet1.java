package java_Core6.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Clinet1 {

	public static void main(String[] args) {
		try {
			System.out.println("======== �ͻ��� =======");
			Socket socket = new Socket("127.0.0.1",9900);
			//System.out.println("�ͻ������ӵ������");
			BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader br1 = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			
			while(true){
				//��һ������,���͵��������� --- �������˶�����
				String str = br.readLine();
				out.println(str);
				if("exit".equals(str))break;
				// =============== ��ȡ���Է������˵����� ================
				String string1 = br1.readLine();
				System.out.println("�ͻ����յ�����˵���Ϣ"+string1);
			}
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
