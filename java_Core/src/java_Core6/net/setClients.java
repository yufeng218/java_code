package java_Core6.net;

import java.net.Socket;
import java.net.UnknownHostException;
import java.io.*;
public class setClients {

	public static void main(String[] args) {
		
		try {
			//连接到服务器端
			Socket socket = new Socket("127.0.0.1",9900);
			
			//启动接收到服务器的数据线程
			new Thread(new AcceptDataFromServer(socket)).start();
			
			//启动接收键盘的线程
			new AcceptDataFromKeypanel(socket).start();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

/**
 * 从服务器端读数据
 * @author he
 *
 */
class AcceptDataFromServer implements Runnable{
	private Socket socket;
	private BufferedReader br;
	public AcceptDataFromServer(Socket socket){
		this.socket = socket;
		try {
			br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		try {
			while(true){
				String str = br.readLine();
				if(str.equals("") || str == null) continue;
				if(str.indexOf("/") == -1){
					System.out.println("群聊消息是:" + str);
				}
				else{
					String[] ss = str.split("/");
					System.out.printf("接收到%s发送的消息:%s\n",ss[0],ss[1]);
				}
					
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}

/**
 * 从键盘读取数据，发送到服务端
 * @author he
 *
 */
class AcceptDataFromKeypanel extends Thread{
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;
	public AcceptDataFromKeypanel(Socket socket){
		this.socket = socket;
		try {
			br = new BufferedReader(
					new InputStreamReader(System.in));
			pw = new PrintWriter(socket.getOutputStream(),true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		try{
			while(true){
				String str = br.readLine();
				if(str.equals("exit")) break;
				pw.println(str);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			pw.close();
		}
	}
}