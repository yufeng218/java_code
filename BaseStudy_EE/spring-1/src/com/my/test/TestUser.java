package com.my.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.my.bean.User;

public class TestUser
{
    public static void main(String[] args)
    {
        ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
        
        User u = (User) act.getBean("user");
        User u1 = (User) act.getBean("user1");
        
        System.out.println(u.getName()+":"+u.getAge());
        
        System.out.println(u1.getName()+":"+u1.getAge());
    }
}
