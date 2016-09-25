package java_Core5.Tread;

import java.util.Random;

public class ThreadInfoDemo8 {
	public static void main(String[] args) {
		final TestThread business = new TestThread();
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				business.A();
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				business.B();
			}
		});
		t1.start();
		t2.start();
	}
}


class TestThread{
	private boolean flag;
	
	public void A(){
		for(int i = 0; i < 50; i++){
			synchronized (this) {
				while(flag){
					try{
						this.wait();
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				//value = new Random().nextInt(1000);
				for(int j=0; j < 10; j++)
					System.out.printf("A线程循环%d次\n",j);
				flag = true;
				this.notify();
			}
		}
	}
	
	public void B(){
		for(int i = 0; i < 50; i++){
			synchronized (this){
				while(!flag){
					try {
						this.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				//System.out.println("rec value is: "+value);
				for(int j=0; j < 20; j++)
					System.out.printf("B线程循环%d次\n",j);
				flag = false;
				this.notify();
			}
		}
	}
}
