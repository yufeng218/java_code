package java_Core5.Tread;

import java.util.Random;

public class ThreadInfoDemo7 {
	public static void main(String[] args) {
		final Business business = new Business();
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				business.send();
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				business.recevie();
			}
		});
		t2.setDaemon(true);
		t1.start();
		t2.start();
	}
}


class Business{
	private int value;
	private boolean flag;
	
	public void send(){
		for(int i = 0; i < 5; i++){
			synchronized (this) {
				while(flag){
					try{
						this.wait();
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				value = new Random().nextInt(1000);
				System.out.println("send value is: "+value);
				flag = true;
				this.notify();
			}
		}
	}
	
	public void recevie(){
		while(true){
			synchronized (this){
				while(!flag){
					try {
						this.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println("rec value is: "+value);
				flag = false;
				this.notify();
			}
		}
	}
}
