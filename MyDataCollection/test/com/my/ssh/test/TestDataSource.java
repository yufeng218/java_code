package com.my.ssh.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.my.ssh.service.UserService;
import com.my.ssh.service.impl.UserServiceImpl;

/**
 * 测试数据源
 * @author pc
 *
 */
public class TestDataSource
{	
	@Test
	public void getConnection() throws SQLException
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource ds = (DataSource) ac.getBean("dataSource");
		System.out.println(ds.getConnection());
	
		System.out.println("*****************");
		UserService us = (UserService) ac.getBean("userService");
		System.out.println(us);
	}

}
