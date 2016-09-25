package java_Core5.Tread;

public class ThreadLockDemo2 {
	public static void main(String[] args) {
		final Output out = new Output();
		final Output out1 = new Output();
		new Thread(new Runnable(){
			@Override
			public void run() {
				while(true){
					out.print("hello");
				}
			}
		}).start();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				while(true){
					out.print("WROLD");
				}
			}
		}).start();
	}
}


class Output{
	public synchronized void print(String name){
		for (int i = 0; i < name.length(); i++) {
			System.out.print(name.charAt(i));
		}
		System.out.println();
	}
	public synchronized void print1(String name){
		synchronized(this){
			for (int i = 0; i < name.length(); i++) {
				System.out.print(name.charAt(i));
			}
		}
		System.out.println();
	}
	public static synchronized void print2(String name){
		for (int i = 0; i < name.length(); i++) {
			System.out.print(name.charAt(i));
		}
		System.out.println();
	}
	public synchronized void print3(String name){
		synchronized(Output.class){
			for (int i = 0; i < name.length(); i++) {
				System.out.print(name.charAt(i));
			}
		}
		System.out.println();
	}
}