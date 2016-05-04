package java_Core5.Tread;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//public class cacheDemo {
//	private HashMap<String, String> hm = new HashMap<String, String>();
//	private String value = null;
//	public String getData(String key){
//		value = hm.get(key);
//		if(value == null){
//			value = "hello"; //����ͨ��������Դ��ȡ
//			hm.put(key, value);
//		}
//		return value;
//	}
//}

public class cacheDemo {

	/*
	 * �޸�����ֻ��һ���̷߳��ʣ�����Ƕ����ݣ������̶߳����Է��ʣ�
	 * ��д���Ļ���
	 */
	private HashMap<String, String> hm = new HashMap<String, String>();
	ReentrantReadWriteLock rrw = new ReentrantReadWriteLock();

	private String value = null;
	public String getData(String key){
//		value = hm.get(key);
//		if(value == null){
//			value = "hello"; //����ͨ��������Դ��ȡ
//			hm.put(key, value);
//		}
//		return value;
		
		rrw.readLock().lock();
		try{
			value = hm.get(key);
			if(value == null){
				//Ҫ����д����
				rrw.readLock().unlock();
				rrw.writeLock().lock();
				try{
					if(value == null){
						value = "hello";
						hm.put(key, value);
					}
				}finally{
					rrw.writeLock().unlock();
					rrw.readLock().lock();
				}
			}
		}finally{
			rrw.readLock().unlock();
		}
		
		return value;
	}
	
	
}











