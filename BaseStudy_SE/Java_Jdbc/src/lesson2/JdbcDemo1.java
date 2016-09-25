package lesson2;

import java.util.ArrayList;

public class JdbcDemo1 {
	public static void main(String[] args) {
		AccountDao ad = new AccountDao();
//		ArrayList<Account> accounts = ad.getAll();
//		for (Account account : accounts) {
//			System.out.println(account);
//		}
		
//		Account account = new Account(5, 2000, "huhu");
//		int n = ad.addUser(account);
//		System.out.println(n);
		
		AccountService service = new AccountService();
		service.setFlag(true);
		service.changAccount(2, 3, 1000);
		
		
	}
}
