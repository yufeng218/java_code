package java_Core5.Tread;

public class ThreadDemo11 {
	public static void main(String[] args) {
		for(int i=0; i<2; i++){
			new Thread(new Runnable(){
				@Override
				public void run() {
					UserService us = UserService.getInstance();
					A a = new A();
					a.print();
					B b = new B();
					b.print();
				}
			}).start();
		}
	}
	
	static class A{
		public void print(){
			UserService us = UserService.getInstance();
			System.out.println(Thread.currentThread().getName()+" A  "+us);
		}
	}
	
	static class B{
		public void print(){
			UserService us = UserService.getInstance();
			System.out.println(Thread.currentThread().getName()+" B "+us);
		}
	}
}
