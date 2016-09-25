package com.my.spring.hibernate.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.my.spring.hibernate.service.BookShopService;

public class SpringHibernateTest
{
	private ApplicationContext ctx = null;
	private BookShopService bookShopService = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		bookShopService = ctx.getBean(BookShopService.class);
		
	}
	
	@Test
//	public void testDataSource() throws SQLException
//	{
//		DataSource dataSource = ctx.getBean(DataSource.class);
//		System.out.println(dataSource.getConnection());
//	}
	
	public void testBookShopService()
	{
		bookShopService.purchase("aa", "1001");
	}
	
}
