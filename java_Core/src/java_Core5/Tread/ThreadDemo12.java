package java_Core5.Tread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo12 {
	public static void main(String[] args) {
		//创建一个固定线程数的线程池,3个线程执行10个任务
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		for(int i = 0; i < 10; i++){
			final int task = i;
			threadPool.execute(new Runnable(){
				@Override
				public void run() {
					for(int j = 1; j <= 10; j++){
						System.out.println(Thread.currentThread().getName()+"执行第"+task+"个任务的第"+j+"次循环");
					}
				}
			});
		}
		threadPool.shutdown(); //关闭线程
	}
}
