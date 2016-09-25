package java_Core3.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo2 {

	public static void main(String[] args) {
		User u1 = new User("001", "zhangsan", 20, "1234");
		User u2 = new User("002", "lisi", 21, "6789");
		User u3 = new User("003", "wangwu",22,"9876");
		
		HashMap<String, User> hm = new HashMap<String, User>();
		hm.put(u1.getId(), u1);
		hm.put(u2.getId(), u2);
		hm.put(u3.getId(), u3);
		System.out.println(hm);
		
		//遍历方式1
		Set<String> s1 = hm.keySet();
		for(String x : s1) {
			System.out.println(x + "=" +hm.get(x));
		}
		
		//遍历方式2
		Set<Map.Entry<String, User>> s2 = hm.entrySet();
		for(Map.Entry<String, User> x : s2) {
			System.out.println(x.getKey() + "=" + x.getValue());
		}
	}

}
