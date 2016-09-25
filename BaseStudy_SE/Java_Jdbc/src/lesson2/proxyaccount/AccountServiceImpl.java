package lesson2.proxyaccount;

import java.util.ArrayList;

import lesson2.Account;
import lesson2.AccountDao;

public class AccountServiceImpl implements AccountService{
	private boolean flag ;	//ģ���쳣��־
	private AccountDao adDao = new AccountDao();
	
	@Override
	public int addAccount(Account account) {
		int n = adDao.addAccount(account);
		return n;
	}

	@Override
	public void changAccount(int id1, int id2, int money) {
		
		Account account1 = adDao.findById(id1);
		Account account2 = adDao.findById(id2);
		int n1 = adDao.updateAccount(id1, account1.getMoney()-money);
//		if(flag)	//�����쳣
//			throw new RuntimeException("�����쳣");
		int n2 = adDao.updateAccount(id2, account2.getMoney()+money);
		
	}
	
	/**
	 * �˻���ѯ����Ҫ����������
	 */
	@Override
	public ArrayList<Account> getAll() {
		ArrayList<Account> accounts = adDao.getAll();
		return accounts;
	}
	
	
	
}
