package com.my.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.my.bean.Computer;

public class TestComputer
{
    public static void main(String[] args)
    {
        //1����IOC�����ж�ȡ
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        //2����IOC��ȡBeanʵ��
        Computer c = (Computer) ctx.getBean("computer");
        
        c.test();
        
    }
}
