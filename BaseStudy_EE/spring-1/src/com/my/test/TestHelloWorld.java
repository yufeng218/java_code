package com.my.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.my.bean.HelloWorld;

public class TestHelloWorld
{
    public static void main(String[] args)
    {
        
        //1������Spring��IOC��������
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        //2����IOC �����л�ȡBeanʵ��
        HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloW");
        
        //3������ hello����
        helloWorld.hello();
        
    }
}
