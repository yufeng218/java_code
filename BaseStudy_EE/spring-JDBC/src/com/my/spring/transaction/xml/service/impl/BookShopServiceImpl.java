package com.my.spring.transaction.xml.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.my.spring.transaction.xml.BookShopDao;
import com.my.spring.transaction.xml.service.BookShopService;

public class BookShopServiceImpl implements BookShopService
{
	
	private BookShopDao bookShopDao;
	
	public void setBookShopDao(BookShopDao bookShopDao)
	{
		this.bookShopDao = bookShopDao;
	}
	
	@Override
	public void purchase(String username, String isbn)
	{
		//1、获取书的单价
		Double price = bookShopDao.findBookPriceByIsbn(isbn);
		
		//2、更新书的库存
		bookShopDao.updateBookStock(isbn);
		
		//3、更新账户余额
		bookShopDao.updateUserAccount(username, price);
	}

}
