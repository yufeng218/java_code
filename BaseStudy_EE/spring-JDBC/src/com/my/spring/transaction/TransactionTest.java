package com.my.spring.transaction;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TransactionTest
{
	private ApplicationContext ctx = null;
	private BookShopDao bookShopDao = null;
	private BookShopService bookShopService = null;
	private Cashier cashier = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		bookShopDao = ctx.getBean(BookShopDao.class);
//		bookShopService = ctx.getBean(BookShopService.class);
		cashier = (Cashier) ctx.getBean("cashier");
	}
	
//	@Test
//	public void testBookShopDaoFindPriceByIsbn()
//	{
//		System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
//	}
//	
//	@Test
//	public void testBookShopDaoUpdateBookStock()
//	{
//		bookShopDao.updateBookStock("1001");
//	}
//	
//	@Test
//	public void testBookShopDaoUpdateUserAccount()
//	{
//		bookShopDao.updateUserAccount("张三", 100.0);
//	}
	
//	@Test
//	public void testBookShopService()
//	{
//		bookShopService.purchase("张三", "1001");
//	}
	
	@Test
	public void testCashier()
	{
		cashier.checkout("张三", Arrays.asList("1001","1002"));
	}
	
}
