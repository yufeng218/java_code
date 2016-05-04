package java_Core5.Tread;

public class ThreadDemo3 {
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
//					e.printStackTrace();
					System.out.println("ÖÐ¶Ït1");
				}

				System.out.println(Thread.currentThread().getName()+" helloworld");
			}
		});
		t1.start();
		for(int i = 0; i < 10; i++){
			try {
				Thread.sleep(300);
				System.out.println(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		t1.interrupt();
	}
}
