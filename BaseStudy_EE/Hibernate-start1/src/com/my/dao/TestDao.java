package com.my.dao;

import com.my.bean.User;

public class TestDao
{
    public static void main(String[] args)
    {
        User u = new User();
        u.setId(1);
        u.setUsername("zhangsan");
        u.setPassword("123456");
        
        UserDao dao = new UserDaoImpl();
        dao.save(u);
    }
    
}
