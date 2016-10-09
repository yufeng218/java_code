package com.my.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil
{
    public static Connection getConn()
    {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/mvc_link";
        String user = "root";
        String password = "123456";
        try
        {
            //º”‘ÿ«˝∂Ø¿‡
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection(url, user, password);
            
        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        
        return con;
    }
    
    public static void close(Connection con)
    {
        try
        {
            con.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
