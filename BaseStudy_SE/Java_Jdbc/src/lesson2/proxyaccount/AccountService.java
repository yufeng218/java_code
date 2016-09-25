package lesson2.proxyaccount;

import java.util.ArrayList;

import lesson2.Account;

public interface AccountService {
	/**
	 * �����˻�
	 * @param account
	 */
	
	public int addAccount(Account account); 
	
	/**
	 * ת��
	 * @param id1
	 * @param id2
	 * @param money
	 */
	public void changAccount(int id1, int id2, int money);
	
	/**
	 * ��ѯ�����˻�
	 * @return
	 */
	@Support
	public ArrayList<Account> getAll();
}
