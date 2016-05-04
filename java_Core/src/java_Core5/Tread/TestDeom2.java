package java_Core5.Tread;

public class TestDeom2 {

	public static void main(String[] args) {
		
		myThread t = new myThread();
		t.start();
		for(;;){
			System.out.println("world");
		}
	}

}

class myThread extends Thread{
	@Override
	public void run() {
		super.run();
		for(;;){
			System.out.println("hello");
		}
	}
}
