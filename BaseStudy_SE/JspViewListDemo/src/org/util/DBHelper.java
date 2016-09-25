package org.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper
{
	// 数据库驱动
	private static final String driver = "com.mysql.jdbc.Driver";
	// 连接数据库的URL地址
	private static final String url = "jdbc:mysql://127.0.0.1:3306/shopping?useUnicode=true&characterEncoding=utf-8";
	// 数据库的用户名和密码
	private static final String user = "root";
	private static final String password = "123456";
	
	private static Connection con = null;
	
	static
	{
		try
		{
			Class.forName(driver);//加载驱动
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException
	{
		if(con == null)
		{
			con = DriverManager.getConnection(url, user, password);
		}
		return con;
	}
	
//	public static void main(String[] args)
//	{
//		try
//		{
//			Connection con = DBHelper.getConnection();
//			if(con != null)
//			{
//				System.out.println("数据库连接成功");
//			}
//		}
//		catch (SQLException e)
//		{
//			e.printStackTrace();
//		}
//		
//	}
	
}
