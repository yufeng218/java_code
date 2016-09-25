package java_Core3.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HasMapDemo1 {

	public static void main(String[] args) {
		User u1 = new User("001", "zhangsan", 20, "1234");
		User u2 = new User("002", "lisi", 21, "6789");
		User u3 = new User("003", "wangwu",22,"9876");
		
		HashMap hm = new HashMap();
		hm.put(u1.getId(), u1);
		hm.put(u2.getId(), u2);
		hm.put(u3.getId(), u3);
		System.out.println(hm.size());
		//直接打印Map对象会打印：key的toString方法 = value的toString方法
		System.out.println(hm);
		
		//key,value都是Object; get(key)得到value；
		User user1 = (User)hm.get(u1.getId());
		System.out.println(user1);
		
		//是否包含某个key, 还有是否包含某个value
		System.out.println(hm.containsKey("003"));
		System.out.println(hm.containsKey("004"));
		
		System.out.println("========= 遍历方式 ============");
		/*
		 * 遍历方式1：把Map中所有的key放入Set集合中，然后遍历Set集合得到key，
		 * 通过key获得value；
		 */
		Set set = hm.keySet();
		for(Object x : set) {
			String key = (String)x;
			User user2 = (User)hm.get(key);
			System.out.println(key + "=" + user2);
		}
		
		/*
		 * 遍历方式2：放入HashMap集合中的key和value，
		 * 其实都被包装成Map.Entry这个内部类的属性；
		 * 有一个键值对就存在一个Map.Entry的实例对象；
		 * 通过entrySet()方法就可以把这些实例对象放入Set集合中；
		 */
		Set s1 = hm.entrySet();
		for(Object x : s1) {
			Map.Entry me = (Map.Entry)x;
			System.out.println(me.getKey() + "=" + me.getValue());
		}
		
	}

}
