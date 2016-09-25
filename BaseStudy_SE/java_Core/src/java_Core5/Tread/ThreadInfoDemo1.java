package java_Core5.Tread;

import java.util.Random;

public class ThreadInfoDemo1 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		FlagSend send = new FlagSend();
		FlagRec rec = new FlagRec(send);
		
		Thread t1 = new Thread(send);
		Thread t2 = new Thread(rec);
		t1.start();
		t2.start();
		
	}

}

class FlagSend implements Runnable{
	int value;
	boolean flag;
	
	@Override
	public void run() {
		for(int i=0; i<5; i++){
			while(flag){
				Thread.yield();
			}
			value = new Random().nextInt();
			System.out.println("send value is:"+value);
			//�Լ��ȴ�
			flag = true;
		}
	}
	
}

class FlagRec implements Runnable{
	private FlagSend flagSend;
	
	public FlagRec(FlagSend flagSend) {
		super();
		this.flagSend = flagSend;
	}

	@Override
	public void run() {
		for(int i=0; i<5; i++){
			while(!flagSend.flag){
				Thread.yield();
			}
			System.out.println("receive value is:"+flagSend.value);
			//�Լ��ȴ�
			flagSend.flag = false;
		}
	}
	
}


