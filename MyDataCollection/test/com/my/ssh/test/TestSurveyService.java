package com.my.ssh.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.my.ssh.model.User;
import com.my.ssh.service.UserService;

public class TestSurveyService
{
	private static UserService us;
	
	@BeforeClass
	public static void initUserService()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		us = (UserService) ac.getBean("userService");
		System.out.println(us);
	}
	
	/**
	 * 	插入用户
	 */
	@Test
	public void insertUser()
	{
		User u = new User();
		u.setEmail("zhangsan@163.com");
		u.setName("zhangsan");
		u.setNickName("drak");
		us.saveEntity(u);
	}
	
}
