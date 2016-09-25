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
	 * 增加账户的业务
	 * @param account
	 */
	public void addAccount(Account account){
		
	}
	
	/**
	 * 转账业务
	 * id1向id2转账
	 * @param id1
	 * @param id2
	 * @param money
	 */
	public void changAccount(int id1, int id2, int money){
		Connection con = JdbcUtil.getConn();
		try {
			//开启事务
			con.setAutoCommit(false);
			
			Account account1 = ad.findById(id1);
			Account account2 = ad.findById(id2);
			int n1 = ad.updateAccount(id1, account1.getMoney()-money);
			if(flag)
				throw new RuntimeException("出现了某种异常");
			int n2 = ad.updateAccount(id2, account2.getMoney()+money);
			
			//提交事务
			con.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				//回滚
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			//关闭Conneciton
			JdbcUtil.closeConnection();
		}
		
	}
}
