package org.my.bbs.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil
{
	private static Properties prop = new Properties();
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

	static
	{
		try
		{
			prop.load(
					JdbcUtil.class.getResourceAsStream("/database.properties"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return
	 */
	public static Connection getConn()
	{
		Connection connection = tl.get();

		try
		{
			// 加载驱动
			if (connection == null)
			{
				Class.forName(prop.getProperty("driverClass"));
				connection = DriverManager.getConnection(
						prop.getProperty("url"), prop.getProperty("user"),
						prop.getProperty("pass"));
				tl.set(connection);
			}
			return tl.get();
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 关闭Statement、ResultSet对象
	 * @param stmt
	 * @param rs
	 */
	public static void close(Statement stmt, ResultSet rs)
	{
		if (rs != null)
		{
			try
			{
				rs.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}

		if (stmt != null)
		{
			try
			{
				stmt.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 关闭Connection对象
	 */
	public static void closeConnection()
	{
		Connection con = tl.get();

		if (con != null)
		{
			try
			{
				con.close();
				tl.remove();

			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
