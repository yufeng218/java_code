package com.my.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookShopServiceImpl implements BookShopService
{
	@Autowired
	private BookShopDao bookShopDao;
	
	//使用propagation指定事务的传播行为,即当前事务被另一个事务调用时；
	//@Transactional(propagation=Propagation.REQUIRED)
	
	//REQUIRED_NEW：开启事务自己的事务，调用该事务方法的事务被挂起。
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	
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
