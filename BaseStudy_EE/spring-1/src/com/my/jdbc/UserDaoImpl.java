package com.my.jdbc;

import java.sql.Connection;

public class UserDaoImpl implements UserDao
{
    private ConnectionUtil conUtil;
    
    public void setUcon(ConnectionUtil conUtil)
    {
        this.conUtil = conUtil;
    }

    @Override
    public void register(User u)
    {
        Connection con = conUtil.getConnection();
        System.out.println(con);
        System.out.println("register ok ...");
    }

}
