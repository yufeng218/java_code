package java_Core5.Tread;

public class ThreadLockDemo1 {
	public static void main(String[] args) {
		Data data1 = new Data();
		Thread t1 = new Thread(data1);
		Thread t2 = new Thread(data1);
		t1.start();
		t2.start();
	}
}

class Data1 implements Runnable{
	private int i;

	@Override
	public synchronized void run() {
		int h;
		for(int j = 1; j <= 10; j++){
			h = i + 1;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i = h;
			System.out.println(i);
		}
		
	}
	
}