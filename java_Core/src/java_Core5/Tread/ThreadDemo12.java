package java_Core5.Tread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo12 {
	public static void main(String[] args) {
		//����һ���̶��߳������̳߳�,3���߳�ִ��10������
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		for(int i = 0; i < 10; i++){
			final int task = i;
			threadPool.execute(new Runnable(){
				@Override
				public void run() {
					for(int j = 1; j <= 10; j++){
						System.out.println(Thread.currentThread().getName()+"ִ�е�"+task+"������ĵ�"+j+"��ѭ��");
					}
				}
			});
		}
		threadPool.shutdown(); //�ر��߳�
	}
}
