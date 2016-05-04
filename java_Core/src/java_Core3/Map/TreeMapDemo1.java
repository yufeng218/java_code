package java_Core3.Map;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapDemo1 {
	public static void main(String[] args) {
		TreeMap<User1, Integer> users = new TreeMap<User1, Integer>();
		User1 u1 = new User1("001", "zhangsan", 20, "1234");
		User1 u2 = new User1("002", "lisi", 21, "6789");
		User1 u3 = new User1("003", "wangwu",22,"9876");
		users.put(u1, 1);
		users.put(u2, 2);
		users.put(u3, 3);
		
		for(User1 x: users.keySet()) {
			System.out.println(x + "=" + users.get(x));
		}
		
		System.out.println("===================");
		
		TreeMap<User, Integer> list = new TreeMap<User, Integer>(
				new Comparator<User>(){

					@Override
					public int compare(User o1, User o2) {
						return o2.getId().compareTo(o1.getId());
					}
				});
		User us1 = new User("001", "zhangsan", 20, "1234");
		User us2 = new User("002", "lisi", 21, "6789");
		User us3 = new User("003", "wangwu",22,"9876");
		list.put(us1, 1);
		list.put(us2, 2);
		list.put(us3, 3);
		System.out.println(list);
	}

}
