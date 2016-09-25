package lesson.xml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	private static Properties prop = new Properties();
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	static{
		try {
			prop.load(JdbcUtil.class.getResourceAsStream("/database.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡ��ݿ������Connection
	 * @return
	 */
	public static Connection getConn(){
		Connection con = tl.get();
		//��������
		try {
			if(con == null){
				Class.forName(prop.getProperty("driverClass"));
				con = DriverManager.getConnection(
						prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("pass"));
				tl.set(con);
			}
			return tl.get();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void close(Statement stmt, ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * �ر�Connection����
	 * @param con
	 */
	public static void closeConnection(){
		Connection con = tl.get();
		
		if(con != null){
			try {
				
				con.close();
				tl.remove();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
