package java_Core5.Tread;

public class TestDemo1 {

	public static void main(String[] args) {
		A a = new A();
		Thread t = new Thread(a);
		t.start();	//�����߳�
		
		//������������һ���̣߳�ϰ�߳�Ϊ���߳�
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