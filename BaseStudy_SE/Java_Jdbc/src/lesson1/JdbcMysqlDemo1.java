package lesson1;

import java.util.ArrayList;

public class JdbcMysqlDemo1 {

	public static void main(String[] args) {
		//查询数据库的数据
//		UserDao ud = new UserDao();
//		ArrayList<User> users = ud.getAll();
//		for (User user : users) {
//			System.out.println(user);
//		}
		
		//插入数据
//		UserDao ud = new UserDao();
//		User user = new User(7, "zhaoliu", 28, "zhaoliu@126.com");
//		int n = ud.addUser(user);
//		System.out.println(n);
		
		//删除数据
//		UserDao ud = new UserDao();
//		int n = ud.deleteUser(5);
//		System.out.println(n);
		
		//分页查询
		UserDao ud = new UserDao();
		ArrayList<User> users = ud.findByPage(3, 5);
		for (User user : users) {
			System.out.println(user);
		}
		
	}

}
