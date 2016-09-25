package com.my.spring.transaction;

public interface BookShopService
{
	//某个人买书
	public void purchase(String username, String isbn);
}
