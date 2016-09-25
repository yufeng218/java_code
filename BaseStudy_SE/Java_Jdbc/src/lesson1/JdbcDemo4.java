package lesson1;

import java.util.ArrayList;

public class JdbcDemo4 {
	public static void main(String[] args) {
		//增加记录
//		UserDao ud = new UserDao();
//		User user = new User(1008, "QingBa", 29, "QingB@126.com");
//		int n = ud.addUser(user);
//		System.out.println(n);
		
		//查询所有记录
//		UserDao ud = new UserDao();
//		ArrayList<User> users = ud.getAll();
//		for (User user : users) {
//			System.out.println(user);
//		}
		
		UserDao ud = new UserDao();
		User user = new User();
		user.setName("");
		//user.setName("tianqi");
		ArrayList<User> users = ud.findByUser(user);
		for (User user2 : users) {
			System.out.println(user2);
		}
	}
}
