package com.my.beans.generic.di;

import javax.management.relation.Role;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{

	public static void main(String[] args)
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-generic.di.xml");
	
		UserService userService = (UserService) ctx.getBean("userService");
		userService.add();
		
		System.out.println("------------------------------");
		RoleService roleService = (RoleService) ctx.getBean("roleService");
		roleService.add();
	}

}
