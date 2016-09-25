package lesson2.proxyaccount;

import java.util.ArrayList;

import lesson2.Account;

public class AccountProxyDemo1 {

	public static void main(String[] args) {
		//����Ŀ�����
		AccountService as = new AccountServiceImpl();
		
		//����Ŀ�����Ĵ���
		ProxyAccountServiceImpl pas = new ProxyAccountServiceImpl(as);
		
		//���ɴ������
		AccountService asProxy = (AccountService)pas.getProxy();
		
		//���ô���ķ���
		Account account = new Account(6, 9000, "pudong");
//		asProxy.addAccount(account);
//		asProxy.changAccount(4, 5, 1000);
		ArrayList<Account> accounts = asProxy.getAll();
		for (Account account2 : accounts) {
			System.out.println(account2);
		}
	}

}
