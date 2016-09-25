package java_Core6.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

	public static void main(String[] args) {
		
		try {
			//开启服务，占用9000端口
			System.out.println("======== 服务器端 =======");
			ServerSocket s = new ServerSocket(9900);
			System.out.println("服务端已经启动，等待客户端访问");
			
			//等待客户来访问 ----> 如果没有客户端访问，该方法阻塞
			Socket socket = s.accept();
			System.out.println("服务器端接收到"+socket.getInetAddress().getHostAddress()+"客户端消息");
			
			//服务端socket.getInputStream()读操作是字节，需要一行一行的读
			BufferedReader br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			String str = br.readLine();
			System.out.println("收到客户端的消息是:"+str);
			
			//=============从服务器端键盘输入，发送到客户端=================
			BufferedReader br1 = new BufferedReader(
					new InputStreamReader(System.in));
			String string1 = br1.readLine();
			PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
			pw.println(string1);
			System.out.println("服务器端发送数据:"+string1);
			socket.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
