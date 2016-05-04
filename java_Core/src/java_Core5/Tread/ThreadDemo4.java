package java_Core5.Tread;

public class ThreadDemo4 {
	public static void main(String[] args) {
		Data data = new Data();
		Thread t1 = new Thread(data);
		Thread t2 = new Thread(data);
		t1.start();
		t2.start();
	}
}


class Data implements Runnable{
	private int i;

	@Override
	public void run() {
		int h;
		for(int j = 1; j <= 10; j++){
			synchronized (this) {
				h = i + 1;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				i = h;
			}//出同步块就会释放锁的钥匙
			System.out.println(i);
		}
		
	}
	
}

