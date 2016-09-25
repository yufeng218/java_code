package java_Core6.net;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.UUID;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class setServer {
	public static String addr;
	public static void main(String[] args) {
		new SaveSocket();	//�洢
		try {
			ServerSocket s = new ServerSocket(9900);
			System.out.println("������Ѿ�����...");
			while(true){
				Socket socket = s.accept();//�����ͻ���ͨ��9900�ķ���
				addr = socket.getInetAddress().getHostAddress() + UUID.randomUUID();
				System.out.printf("���ܵ�%s�ķ���\n", addr);
				SaveSocket.addClient(addr, socket);
				new ReadDataFromClient(socket); //�����߳�
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
class ReadDataFromClient extends Thread{
	private Socket socket;
	private BufferedReader br;
	private PrintStream ps;	//��ǰ�ͻ���д����ǰ�ͻ���
	private String ip;
	
	public ReadDataFromClient(Socket socket){
		this.socket = socket;
		try{
			
			this.br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			this.ps = new PrintStream(socket.getOutputStream());
			
		}catch(IOException e){
			e.printStackTrace();
		}
		this.ip = setServer.addr;
		this.start();//�����߳�
	}
	
	@Override
	public void run() {
		super.run();
		try {
			
			while(true){
				String str = br.readLine();
				if(str.equals("") || str == null) continue;
				if(str.equals("exit")) System.out.println("�пͻ����˳�");
				
				if(str.indexOf("/") == -1){
					
					//Ⱥ�� -- �������е�Socket��Ȼ�����д����
					for(String addr : SaveSocket.getUsers().keySet()){
						Socket socketClient = SaveSocket.findClient(addr);
						if(socket.equals(socketClient)) continue;
						PrintStream toAll = new PrintStream(socketClient.getOutputStream());
						toAll.println(str);
					}
					
				}
				else{
					//˽�� 
					String addr = str.split("/")[0];
					String content = str.split("/")[1];
					String text = this.ip + "/"+ content;
					
					Socket sendSocket = SaveSocket.findClient(addr);
					if(sendSocket != null){
						PrintStream clientToClient = new PrintStream(sendSocket.getOutputStream());
						clientToClient.println(text);
					}
					else{
						ps.println("��Ҫ���͵Ŀͻ��˲�����!");
					}
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

class SaveSocket{
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

