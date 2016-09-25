package java_Core6.net;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class setServerHigh {
	public static String addr;
	public static void main(String[] args) {
		new SaveSocket();	//存储
		//创建线程池
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		try {
			ServerSocket s = new ServerSocket(9900);
			System.out.println("服务端已经开启...");
			while(true){
				Socket socket = s.accept();//监听客户端通过9900的访问
				addr = socket.getInetAddress().getHostAddress() + UUID.randomUUID();
				System.out.printf("接受到%s的访问\n", addr);
				SaveSocket.addClient(addr, socket);
				threadPool.execute(new ReadDataFromClient1(socket)); 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/**
 * 
 * @author he
 *
 */
class ReadDataFromClient1 implements Runnable{
	private Socket socket;
	private BufferedReader br;
	private PrintStream ps;	//当前客户端写给当前客户端
	private String ip;
	
	public ReadDataFromClient1(Socket socket){
		this.socket = socket;
		try{
			
			this.br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			this.ps = new PrintStream(socket.getOutputStream());
			
		}catch(IOException e){
			e.printStackTrace();
		}
		this.ip = setServerHigh.addr;
	}
	
	@Override
	public void run() {
		//super.run();
		try {
			
			while(true){
				String str = br.readLine();
				if(str.equals("") || str == null) continue;
				if(str.equals("exit")) System.out.println("有客户端退出");
				
				if(str.indexOf("/") == -1){
					
					//群聊 -- 遍历所有的Socket，然后进行写操作
					for(String addr : SaveSocket.getUsers().keySet()){
						Socket socketClient = SaveSocket.findClient(addr);
						if(socket.equals(socketClient)) continue;
						PrintStream toAll = new PrintStream(socketClient.getOutputStream());
						toAll.println(str);
					}
					
				}
				else{
					//私聊 
					String addr = str.split("/")[0];
					String content = str.split("/")[1];
					String text = this.ip + "/"+ content;
					
					Socket sendSocket = SaveSocket.findClient(addr);
					if(sendSocket != null){
						PrintStream clientToClient = new PrintStream(sendSocket.getOutputStream());
						clientToClient.println(text);
					}
					else{
						ps.println("您要发送的客户端不存在!");
					}
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

class SaveSocket1{
	private static HashMap<String, Socket> users = new HashMap<String, Socket>();
	
	public static void addClient(String addr, Socket socket){
		users.put(addr, socket);
	}
	
	public static Socket findClient(String addr){
		return users.get(addr);
	}
	
	public static HashMap<String, Socket> getUsers(){
		return users;
	}
}

