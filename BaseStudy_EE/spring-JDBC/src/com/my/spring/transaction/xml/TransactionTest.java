package com.my.spring.transaction.xml;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.my.spring.transaction.xml.service.BookShopService;
import com.my.spring.transaction.xml.service.Cashier;

public class TransactionTest
{
	private ApplicationContext ctx = null;
	private BookShopDao bookShopDao = null;
	private BookShopService bookShopService = null;
	private Cashier cashier = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
		cashier = (Cashier) ctx.getBean("cashier");
	}
	
	
	@Test
	public void testCashier()
	{
		cashier.checkout("张三", Arrays.asList("1001","1002"));
	}
	
}
