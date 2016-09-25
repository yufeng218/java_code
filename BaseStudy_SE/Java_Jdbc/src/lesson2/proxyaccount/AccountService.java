package lesson2.proxyaccount;

import java.util.ArrayList;

import lesson2.Account;

public interface AccountService {
	/**
	 * 增加账户
	 * @param account
	 */
	
	public int addAccount(Account account); 
	
	/**
	 * 转账
	 * @param id1
	 * @param id2
	 * @param money
	 */
	public void changAccount(int id1, int id2, int money);
	
	/**
	 * 查询所有账户
	 * @return
	 */
	@Support
	public ArrayList<Account> getAll();
}
