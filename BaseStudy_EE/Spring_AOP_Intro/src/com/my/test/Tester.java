package com.my.test;

import com.my.dao.DynamicLogProxy;
import com.my.dao.LogProxy;
import com.my.dao.UserDao;
import com.my.dao.UserDaoImpl;

public class Tester
{
    public static void main(String[] args)
    {
//        UserDao dao = new UserDaoImpl();
//        dao.delete("admin");
        
        //��̬����
//        UserDao dao = new LogProxy(new UserDaoImpl());
//        dao.delete("adim");
        
        //��̬����
        UserDao dao = (UserDao) new DynamicLogProxy().bind(new UserDaoImpl());
        dao.delete("admin");
        
    }
}
