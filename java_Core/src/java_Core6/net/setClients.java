package java_Core6.net;

import java.net.Socket;
import java.net.UnknownHostException;
import java.io.*;
public class setClients {

	public static void main(String[] args) {
		
		try {
			//���ӵ���������
			Socket socket = new Socket("127.0.0.1",9900);
			
			//�������յ��������������߳�
			new Thread(new AcceptDataFromServer(socket)).start();
			
			//�������ռ��̵��߳�
			new AcceptDataFromKeypanel(socket).start();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

/**
 * �ӷ������˶�����
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
					System.out.println("Ⱥ����Ϣ��:" + str);
				}
				else{
					String[] ss = str.split("/");
					System.out.printf("���յ�%s���͵���Ϣ:%s\n",ss[0],ss[1]);
				}
					
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}

/**
 * �Ӽ��̶�ȡ���ݣ����͵������
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