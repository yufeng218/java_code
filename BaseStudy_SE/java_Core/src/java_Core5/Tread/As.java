package java_Core5.Tread;

public class As {
	public static void main(String[] args) {
		MyThreadTest mt=new MyThreadTest();
		mt.run();
		while(true){
			System.out.println("Main()方法正在运行");
		}
	}
}
class MyThreadTest{
	public void run(){
		while(true){
			System.out.println("MyThread类的run()方法正在运行");
		}
	}
}