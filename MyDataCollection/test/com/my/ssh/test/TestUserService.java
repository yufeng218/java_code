package com.my.ssh.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.my.ssh.model.User;
import com.my.ssh.service.SurveyService;
import com.my.ssh.service.UserService;

public class TestUserService
{
	private static SurveyService ss;
	
	@BeforeClass
	public static void initUserService()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ss = (SurveyService) ac.getBean("surveyService");
		System.out.println(ss);
	}
	
	/**
	 * 	新建调查
	 */
	@Test
	public void newSurvey()
	{
		User u = new User();
		u.setId(4);
		ss.newSurvey(u);
	}
	
}
