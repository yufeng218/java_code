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
			System.out.println("======== 客户端 =======");
			Socket socket = new Socket("127.0.0.1",9900);
			//System.out.println("客户端连接到服务端");
			BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader br1 = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			
			while(true){
				//读一行数据,发送到服务器端 --- 服务器端读操作
				String str = br.readLine();
				out.println(str);
				if("exit".equals(str))break;
				// =============== 读取来自服务器端的数据 ================
				String string1 = br1.readLine();
				System.out.println("客户端收到服务端的消息"+string1);
			}
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
