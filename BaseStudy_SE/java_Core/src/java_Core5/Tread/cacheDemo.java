package java_Core5.Tread;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//public class cacheDemo {
//	private HashMap<String, String> hm = new HashMap<String, String>();
//	private String value = null;
//	public String getData(String key){
//		value = hm.get(key);
//		if(value == null){
//			value = "hello"; //将来通过其他资源获取
//			hm.put(key, value);
//		}
//		return value;
//	}
//}

public class cacheDemo {

	/*
	 * 修改数据只能一个线程访问，如果是读数据，所有线程都可以访问；
	 * 读写锁的机制
	 */
	private HashMap<String, String> hm = new HashMap<String, String>();
	ReentrantReadWriteLock rrw = new ReentrantReadWriteLock();

	private String value = null;
	public String getData(String key){
//		value = hm.get(key);
//		if(value == null){
//			value = "hello"; //将来通过其他资源获取
//			hm.put(key, value);
//		}
//		return value;
		
		rrw.readLock().lock();
		try{
			value = hm.get(key);
			if(value == null){
				//要进行写操作
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











