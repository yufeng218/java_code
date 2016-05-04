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
			System.out.println("======== 客户端 =======");
			Socket socket = new Socket("127.0.0.1",9900);
			System.out.println("客户端连接到服务端");
			
			//读一行数据发送给服务器
			BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
			String str = br.readLine();
			
			//写到服务器端 --- 服务器端读操作
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			out.println(str);
			
			// =============== 读取来自服务器端的数据 ================
			BufferedReader br1 = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			String string1 = br1.readLine();
			System.out.println("收到服务端的消息"+string1);
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
