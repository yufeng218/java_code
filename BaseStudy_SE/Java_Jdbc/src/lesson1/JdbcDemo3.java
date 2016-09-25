package lesson1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo3 {

	public static void main(String[] args) {
		try {

			Connection con = JdbcUtil.getConn();
			Statement stmt = con.createStatement();
			// 增加记录
//			int id = 1003;
//			String name = "wangwu";
//			int age = 28;
//			String email = "wangwu@163.com";
//			String sql = String.format("insert into bbs_user(id,name,age,email)values(%d,'%s',%d,'%s')", id, name, age,
//					email);
//			int n = stmt.executeUpdate(sql);
//			System.out.println(n);
			
			// 修改记录
			int id = 1003;
			String name = "WangWu";
			String email = "wang5@163.com";
			String sql = String.format("update bbs_user set name='%s',email='%s' where id=%d", name, email, id);
			int n = stmt.executeUpdate(sql);
			System.out.println(n);
			
			JdbcUtil.close(con, stmt, null);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
