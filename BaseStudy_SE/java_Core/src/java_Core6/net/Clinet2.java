package java_Core6.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Clinet2 {

	public static void main(String[] args) {
		try {
			System.out.println("======== 客户端 =======");
			Socket socket = new Socket("127.0.0.1",9900);
			//System.out.println("客户端连接到服务端");
			final BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
			final PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			final BufferedReader br1 = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			
			new Thread(new Runnable(){
				@Override
				public void run() {
					//客户端读一行数据,发送到服务器端 
					while(true){
						try {
							String str = br.readLine();
							out.println(str);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
			
			new Thread(new Runnable(){
				@Override
				public void run() {
					// 读取来自服务器端的数据
					while(true){
						try {
							String string1 = br1.readLine();
							System.out.println("客户端收到服务端的消息"+string1);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
			
			

//			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
