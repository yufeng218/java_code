package lesson1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 向数据库的表中插入记录、增加记录、修改记录
 * @author pc
 *
 */

public class JdbcDemo2 {
	public static void main(String[] args) {
		
		//向数据库的表中增加记录、删除记录、修改记录
		try {
			//加载驱动类
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//连接数据库, java.sql.Connection
			String url = "jdbc:oracle:thin:@192.168.1.100:1521:ORCL";
			Connection con = DriverManager.getConnection(url, "scott", "tiger");
			Statement stmt = con.createStatement();
			//String sql = "insert into bbs_user values(1,'zhangsan',25,'zhangS@163.com')";
			String sql = "delete bbs_user where name='zhangsan'";
			//String sql = "update bbs_user set age=30,email='zhangsan@163.com' where name='zhangsan'";
			
			//返回的是影响的记录条数
			int n = stmt.executeUpdate(sql);  //使用executeUpdate函数
			System.out.println(n);
			
			stmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
