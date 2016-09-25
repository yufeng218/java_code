package com.my.beans.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.my.beans.annotation.controller.UserController;
import com.my.beans.annotation.repository.UserRepository;
import com.my.beans.annotation.service.UserService;

public class Main
{
	public static void main(String[] args)
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");
		
//		TestObject to = (TestObject) ctx.getBean("testObject");
//		System.out.println(to);
	
		UserController userController = (UserController) ctx.getBean("userController");
		userController.execute();
		System.out.println(userController);
		
//		UserService userService = (UserService) ctx.getBean("userService");
//		System.out.println(userService);
		
//		UserRepository userRepository = (UserRepository) ctx.getBean("userRepository");
//		System.out.println(userRepository);
		
		
	}
}
