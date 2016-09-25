package com.my.beans.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.my.beans.spel.Address;
import com.my.beans.spel.Person;

public class Main
{
	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-factory.xml");
		
		Car car1 = (Car) ctx.getBean("car1");
		System.out.println(car1);
		
		Car car2 = (Car) ctx.getBean("car2");
		System.out.println(car2);
		
	}
}
