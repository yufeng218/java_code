package java_Core5.Tread;

import java.util.HashMap;
import java.util.Random;

public class ThreadDemo10 {
	//private static HashMap<Thread, Integer> data = new HashMap<Thread, Integer>();
	private static ThreadLocal<Integer> t1 = new ThreadLocal<Integer>();
	public static void main(String[] args) {
		for(int i=0; i<2; i++){
			new Thread(new Runnable(){
				@Override
				public void run() {
					int value = new Random().nextInt(1000);
					System.out.println(Thread.currentThread().getName() + " value is "+value);
					//data.put(Thread.currentThread(), value);
					t1.set(value);	//·ÅÊý¾Ý
					A a = new A();
					a.getData();
					B b = new B();
					b.getData();
					C c = new C();
					c.getData();
				}
			}).start();
		}

	}
	
	public static class A{
		public void getData(){
//			Thread t = Thread.currentThread();
//			int value = data.get(t);
//			System.out.println(t.getName()+":A-value is"+value);
			
			System.out.println("A-ThreadLocal value is "+t1.get());
		}
	}
	
	public static class B{
		public void getData(){
//			Thread t = Thread.currentThread();
//			int value = data.get(t);
//			System.out.println(t.getName()+":B-value is"+value);
			System.out.println("B-ThreadLocal value is "+t1.get());
		}
	}
	
	public static class C{
		public void getData(){
//			Thread t = Thread.currentThread();
//			int value = data.get(t);
//			System.out.println(t.getName()+":C-value is"+value);
			System.out.println("C-ThreadLocal value is "+t1.get());
		}
	}
}
