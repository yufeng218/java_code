package java_Core3;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo2 {

	public static void main(String[] args) {
		User1 user1 = new User1("zhangsan", "1234", 20);
		User1 user2 = new User1("lisi", "56789", 21);
		User1 user3 = new User1("wangwu","1234",22);
		
		TreeSet<User1> list = new TreeSet<User1>(new MyComparator());
		list.add(user1);
		list.add(user2);
		list.add(user3);
		System.out.println(list);
		
		System.out.println("===================================");
		TreeSet<User1> list1 = new TreeSet<User1>(new Comparator<User1>(){
			@Override
			public int compare(User1 o1, User1 o2) {
				return o2.getName().compareTo(o1.getName());
			}
		});
		list1.add(user1);
		list1.add(user2);
		list1.add(user3);
		System.out.println(list1);
	}
	
	static class MyComparator implements Comparator<User1>{

		@Override
		public int compare(User1 o1, User1 o2) {
			return o1.getName().compareTo(o2.getName());
		}
		
	}

}
