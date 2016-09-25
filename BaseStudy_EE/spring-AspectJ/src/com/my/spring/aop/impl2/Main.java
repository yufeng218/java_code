package com.my.spring.aop.impl2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
	public static void main(String[] args)
	{
		//1、创建Spring的IOC容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext1.xml");
		
		//2、从IOC容器获取bean的实例
		ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
		
		System.out.println(arithmeticCalculator.getClass().getName());
		
		//3、使用bean
		int result = arithmeticCalculator.add(3, 6);
		System.out.println("result:" + result);
		
		int re1 = arithmeticCalculator.div(12, 2);
		System.out.println("result:" + re1);
	}
}
