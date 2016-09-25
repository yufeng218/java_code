package lesson2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import lesson2.Account;

public class Demo1 {

	public static void main(String[] args) {
		
		SupportDao<Account> sd = new SupportDao<Account>();
		Account account = sd.findById(5, "select * from account where id=?", new AccountRowMapper());
		System.out.println(account);
	}
	
	static class AccountRowMapper implements RowMapper<Account>{

		@Override
		public Account getRowMapper(ResultSet rs) throws SQLException {
			Account account = new Account();
			account.setId(rs.getInt("id"));
			account.setMoney(rs.getInt("money"));
			account.setName(rs.getString("name"));
			return account;
		}
		
	}
}
