package com.my.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.my.bean.Computer;

public class TestComputer
{
    public static void main(String[] args)
    {
        //1、从IOC容器中读取
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        //2、从IOC获取Bean实例
        Computer c = (Computer) ctx.getBean("computer");
        
        c.test();
        
    }
}
