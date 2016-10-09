package com.my.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.my.bean.HelloWorld;

public class TestHelloWorld
{
    public static void main(String[] args)
    {
        
        //1、创建Spring的IOC容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        //2、从IOC 容器中获取Bean实例
        HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloW");
        
        //3、调用 hello方法
        helloWorld.hello();
        
    }
}
