package lesson2.proxyaccount;

import java.util.ArrayList;

import lesson2.Account;

public class AccountProxyDemo1 {

	public static void main(String[] args) {
		//生成目标对象
		AccountService as = new AccountServiceImpl();
		
		//建立目标对象的代理
		ProxyAccountServiceImpl pas = new ProxyAccountServiceImpl(as);
		
		//生成代理对象
		AccountService asProxy = (AccountService)pas.getProxy();
		
		//调用代理的方法
		Account account = new Account(6, 9000, "pudong");
//		asProxy.addAccount(account);
//		asProxy.changAccount(4, 5, 1000);
		ArrayList<Account> accounts = asProxy.getAll();
		for (Account account2 : accounts) {
			System.out.println(account2);
		}
	}

}
