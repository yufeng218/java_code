package java_Core3;

import java.util.TreeSet;

public class TreeSetDemo1 {

	public static void main(String[] args) {
		User user1 = new User("zhangsan", "1234", 20);
		User user2 = new User("lisi", "56789", 21);
		User user3 = new User("wangwu","1234",22);
		
		TreeSet<User> list = new TreeSet<User>();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		System.out.println(list);

	}

}
