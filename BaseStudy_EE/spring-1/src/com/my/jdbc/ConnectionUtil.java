package com.my.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil
{
    private String driver;
    private String url;
    private String username;
    private String password;
    
    /**
     * 获取驱动类
     * @return
     */
    public Connection getConnection()
    {
        Connection con = null;
        try
        {
            Class.forName(driver);//加载驱动类
            con = DriverManager.getConnection(url, username, password);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        
        return con;
    }
    
    
    public void setDriver(String driver)
    {
        this.driver = driver;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

}
