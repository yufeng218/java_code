package java_Core6.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {

	public static void main(String[] args) {
		
		try {
			//��������ռ��9000�˿�
			System.out.println("======== �������� =======");
			ServerSocket s = new ServerSocket(9900);
			System.out.println("������Ѿ��������ȴ��ͻ��˷���");
			
			//�ȴ��ͻ������� ----> ���û�пͻ��˷��ʣ��÷�������
			Socket socket = s.accept();
			System.out.println("�������˽��յ�"+socket.getInetAddress().getHostAddress()+"�ͻ�����Ϣ");
			BufferedReader br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			BufferedReader br1 = new BufferedReader(
					new InputStreamReader(System.in));
			PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
			
			while(true){
				
				//�����socket.getInputStream()���������ֽڣ���Ҫһ��һ�еĶ�
				String str = br.readLine();
				System.out.println("������յ��ͻ��˵���Ϣ��:"+str);
				
				//�������˴Ӽ������룬���͵��ͻ���
				String string1 = br1.readLine();
				pw.println(string1);
				System.out.println("�������˷�������:"+string1);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}