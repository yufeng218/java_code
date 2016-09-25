package java_Core5.Tread;

import java.util.Random;
public class ThreadDemo6 {

	public static void main(String[] args) {
		WaitSend send = new WaitSend();
		WaitRec rec = new WaitRec(send);
		Thread t1 = new Thread(send);
		Thread t2 = new Thread(rec);
		
		t2.setDaemon(true);
		t1.start();
		t2.start();
		
	}

}

class WaitSend implements Runnable{
	boolean flag;
	int theValue;
	@Override
	public void run() {
		for(int i = 0; i <= 5; i++){
			synchronized (this) {
				while(flag){  //
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				//生成消息
				theValue = new Random().nextInt(1000);
				System.out.println("send value is:"+theValue);
				//自己去等待
				flag = true;
				//唤醒另外一个
				this.notify();
			}
			
		}
		
	}
}


class WaitRec implements Runnable{
	private WaitSend send;

	public WaitRec(WaitSend send) {
		super();
		this.send = send;
	}
	@Override
	public void run() {
		while(true){
			synchronized (send) {
				while(!send.flag){
					try{
						send.wait();
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				System.out.println("recevie value is:"+send.theValue);
				send.flag = false;
				send.notify();
			}
		}
	}
	
}
