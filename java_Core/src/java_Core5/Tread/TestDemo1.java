package java_Core5.Tread;

public class TestDemo1 {

	public static void main(String[] args) {
		A a = new A();
		Thread t = new Thread(a);
		t.start();	//启动线程
		
		//主函数本身是一个线程，习惯称为主线程
		for(;;){
			System.out.println("world");
		}
	}

}


class A implements Runnable{

	@Override
	public void run() {
		for(;;){
			System.out.println("hello...");
		}
	}
	
}