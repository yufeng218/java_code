package lesson1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDao {
	/**
	 * ��������
	 * 
	 * @param user
	 * @return
	 */
	// public int addUser(User user) {
	// Connection con = null;
	// Statement stmt = null;
	// int n = 0;
	// try {
	//
	// con = JdbcUtil.getConn();
	// stmt = con.createStatement();
	// String sql = String.format("insert into bbs_user(id,name,age,email)
	// values (%d,'%s',%d,'%s')", user.getId(),
	// user.getName(), user.getAge(), user.getEmail());
	// n = stmt.executeUpdate(sql);
	//
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// JdbcUtil.close(con, stmt, null);
	// return n;
	// }
	// }

	/**
	 * ʹ��PreparedStatement
	 * 
	 * @param user
	 * @return
	 */
	public int addUser(User user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int n = 0;
		try {

			con = JdbcUtil.getConn();
			String sql = "insert into bbs_user(id,name,age,email) values (?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setInt(3, user.getAge());
			pstmt.setString(4, user.getEmail());
			n = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(con, pstmt, null);
			return n;
		}
	}

	/**
	 * ��ѯ���ݿ���������Ϣ
	 * 
	 * @return
	 */
	public ArrayList<User> getAll() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<User> list = new ArrayList<User>();
		try {
			con = JdbcUtil.getConn();
			stmt = con.createStatement();
			String sql = "select * from bbs_user";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				User user = new User(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("email"));
				list.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(con, stmt, null);
			return list;
		}
	}

	/**
	 * ���ݱ���һ����Ϊ�յ����ԣ���ѯ����������������Ϣ ����������ѯ
	 * 
	 * @param user
	 */
	public ArrayList<User> findByUser(User user) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<User> users = new ArrayList<User>();
		try {
			con = JdbcUtil.getConn();
			stmt = con.createStatement();

			String sql = "select * from bbs_user where 1 = 1";
			if (user.getName() != null && !"".equals(user.getName())) {
				sql += " and name ='" + user.getName() + "'";
			}
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				User u = new User();
				u.setAge(rs.getInt("age"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				users.add(u);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(con, stmt, rs);
			return users;
		}
	}

	/**
	 * ɾ������
	 */
	public int deleteUser(int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int n = 0;
		try {

			con = JdbcUtil.getConn();
			String sql = "delete from bbs_user where id=" + id;
			pstmt = con.prepareStatement(sql);
			n = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(con, pstmt, null);
			return n;
		}
	}

	/**
	 * ��ҳ��ѯ
	 * page: �ڼ�ҳ
	 * pageSize:ÿҳ�Ĵ�С
	 */
	public ArrayList<User> findByPage(int page, int pageSize) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<User> users = new ArrayList<User>();
		int begin = (page-1)*pageSize;
		try {
			con = JdbcUtil.getConn();
			String sql = "select * from bbs_user limit ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, begin);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("email"));
				users.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			JdbcUtil.close(con, pstmt, rs);
			return users;
		}
	}
}
