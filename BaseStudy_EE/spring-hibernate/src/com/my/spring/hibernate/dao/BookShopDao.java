package com.my.spring.hibernate.dao;

public interface BookShopDao
{
	//根据书号isbn获取书的单价
	public Double findBookPriceByIsbn(String isbn);
	
	//更新书的库存
	public void updateBookStock(String isbn);
	
	//更新用户的账户余额
	public void updateUserAccount(String username, Double price);
}
