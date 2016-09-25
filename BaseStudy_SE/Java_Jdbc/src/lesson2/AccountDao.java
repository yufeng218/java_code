package lesson2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class AccountDao {
	
	/**
	 * 查询数据库中所有信息
	 * 
	 * @return
	 */
	public ArrayList<Account> getAll() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Account> list = new ArrayList<Account>();
		try {
			con = JdbcUtil.getConn();
			stmt = con.createStatement();
			String sql = "select * from account";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Account account = new Account(rs.getInt("id"), rs.getInt("money"), rs.getString("name"));
				list.add(account);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, null);
			return list;
		}
	}
	
	/**
	 * 通过id查询记录
	 * @param id
	 * @return
	 */
	public Account findById(int id){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Account account = null;
		int money = 0;
		try {
			con = JdbcUtil.getConn();
			String sql = "select * from account where id=" + id;
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				account = new Account();
				account.setId(rs.getInt("id"));
				account.setMoney(rs.getInt("money"));
				account.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			JdbcUtil.close(pstmt, rs);
			return account;
		}
		
	}
	
	/**
	 * 插入数据
	 * 使用PreparedStatement
	 * @param user
	 * @return
	 */
	public int addAccount(Account account) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int n = 0;
		try {
			con = JdbcUtil.getConn();
			String sql = "insert into account(id,money,name) values (?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, account.getId());
			pstmt.setInt(2, account.getMoney());
			pstmt.setString(3, account.getName());
			n = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
			return n;
		}
	}
	
	/**
	 * 根据id修改对应的money
	 * @param id
	 * @param money
	 * @return
	 */
	public int updateAccount(int id, int money){
		Connection con = null;
		PreparedStatement pstmt = null;
		int n = 0;
		try {
			con = JdbcUtil.getConn();
			String sql = "update account set money=? where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, money);
			pstmt.setInt(2, id);
			n = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
			return n;
		}
	}
	
	/**
	 * 根据id删除表中的记录
	 * @param id
	 * @return
	 */
	public int deleteAccount(int id){
		Connection con = null;
		PreparedStatement pstmt = null;
		int n = 0;
		try {
			con = JdbcUtil.getConn();
			String sql = "delete from account where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			n = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
			return n;
		}
	}
	
	
}
