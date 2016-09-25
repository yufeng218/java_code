package java_Core6.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

	public static void main(String[] args) {
		
		try {
			//开启服务，占用9000端口
			System.out.println("======== 服务器端 =======");
			ServerSocket s = new ServerSocket(9900);
			System.out.println("服务端已经启动，等待客户端访问");
			
			//等待客户来访问 ----> 如果没有客户端访问，该方法阻塞
			Socket socket = s.accept();
			System.out.println("服务器端接收到"+socket.getInetAddress().getHostAddress()+"客户端消息");
			final BufferedReader br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			final BufferedReader br1 = new BufferedReader(
					new InputStreamReader(System.in));
			final PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
			
			new Thread(new Runnable(){
				@Override
				public void run() {
					//服务端socket.getInputStream()读操作是字节，需要一行一行的读
					while(true){
						try {
							String str = br.readLine();
							System.out.println("服务端收到客户端的消息是:"+str);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
				
				
			new Thread(new Runnable(){
				@Override
				public void run() {
					//服务端socket.getInputStream()读操作是字节，需要一行一行的读
					while(true){
						try {
							//服务器端从键盘输入，发送到客户端
							String string1 = br1.readLine();
							pw.println(string1);
							System.out.println("服务器端发送数据:"+string1);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
				
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
