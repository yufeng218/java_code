package java_Core5.Tread;

public class ThreadInfoDemo9 {

	public static void main(String[] args) {
		final TestThread1 business = new TestThread1();
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
		
		Thread t3 = new Thread(new Runnable(){
			@Override
			public void run() {
				business.C();
			}
		});
		t1.start();
		t2.start();
		t3.start();
	}


}

class TestThread1{
	private int flag = 1;
	
	public void A(){
		for(int i = 0; i < 50; i++){
			synchronized (this) {
				while(flag != 1){
					try{
						this.wait();
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				//value = new Random().nextInt(1000);
				for(int j=0; j < 10; j++)
					System.out.printf("A线程循环%d次\n",j);
				flag = 2;
				this.notifyAll();
			}
		}
	}
	
	public void B(){
		for(int i = 0; i < 50; i++){
			synchronized (this){
				while(flag != 2){
					try {
						this.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				//System.out.println("rec value is: "+value);
				for(int j=0; j < 20; j++)
					System.out.printf("B线程循环%d次\n",j);
				flag = 3;
				this.notifyAll();
			}
		}
	}
	
	public void C(){
		for(int i = 0; i < 50; i++){
			synchronized (this){
				while(flag != 3){
					try {
						this.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				//System.out.println("rec value is: "+value);
				for(int j=0; j < 20; j++)
					System.out.printf("C线程循环%d次\n",j);
				flag = 1;
				this.notifyAll();
			}
		}
	}
}
