package lesson1;

import java.util.ArrayList;

public class JdbcMysqlDemo1 {

	public static void main(String[] args) {
		//��ѯ���ݿ������
//		UserDao ud = new UserDao();
//		ArrayList<User> users = ud.getAll();
//		for (User user : users) {
//			System.out.println(user);
//		}
		
		//��������
//		UserDao ud = new UserDao();
//		User user = new User(7, "zhaoliu", 28, "zhaoliu@126.com");
//		int n = ud.addUser(user);
//		System.out.println(n);
		
		//ɾ������
//		UserDao ud = new UserDao();
//		int n = ud.deleteUser(5);
//		System.out.println(n);
		
		//��ҳ��ѯ
		UserDao ud = new UserDao();
		ArrayList<User> users = ud.findByPage(3, 5);
		for (User user : users) {
			System.out.println(user);
		}
		
	}

}
