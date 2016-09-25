package lesson2;

import java.sql.Connection;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class AccountService {
	
	AccountDao ad = new AccountDao();
	boolean flag = true;
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	/**
	 * �����˻���ҵ��
	 * @param account
	 */
	public void addAccount(Account account){
		
	}
	
	/**
	 * ת��ҵ��
	 * id1��id2ת��
	 * @param id1
	 * @param id2
	 * @param money
	 */
	public void changAccount(int id1, int id2, int money){
		Connection con = JdbcUtil.getConn();
		try {
			//��������
			con.setAutoCommit(false);
			
			Account account1 = ad.findById(id1);
			Account account2 = ad.findById(id2);
			int n1 = ad.updateAccount(id1, account1.getMoney()-money);
			if(flag)
				throw new RuntimeException("������ĳ���쳣");
			int n2 = ad.updateAccount(id2, account2.getMoney()+money);
			
			//�ύ����
			con.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				//�ع�
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			//�ر�Conneciton
			JdbcUtil.closeConnection();
		}
		
	}
}
