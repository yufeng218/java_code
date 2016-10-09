package com.my.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test
{
    public static void main(String[] args)
    {
        //创建容器对象
        ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
        
//        ConnectionUtil con = (ConnectionUtil) act.getBean("url");
//        System.out.println(con.getConnection());
        
        UserDao dao = (UserDao) act.getBean("userDao");
        dao.register(new User());
    }
}
