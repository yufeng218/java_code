package com.my.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookshopDao")
public class BookShopDaoImpl implements BookShopDao
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Double findBookPriceByIsbn(String isbn)
	{
		String sql = "select price from book where isbn=?";
		return jdbcTemplate.queryForObject(sql, Double.class, isbn);
	}

	@Override
	public void updateBookStock(String isbn)
	{
		//检查书的库存是否不够，若不够则抛出异常
		String sql2 = "select stock from book_stock where isbn=?";
		int stock = jdbcTemplate.queryForObject(sql2, Integer.class, isbn);
		if(stock == 0)
		{
			throw new BookStockException("库存不足");
		}
		
		String sql = "update book_stock set stock = stock-1 where isbn=?";
		jdbcTemplate.update(sql, isbn);
	}

	@Override
	public void updateUserAccount(String username, Double price)
	{
		//检查账号的余额是否不够，若不够则抛出异常
		String sql2 = "select balance from account where username=?";
		double balance = jdbcTemplate.queryForObject(sql2, Double.class, username);
		if(balance < price)
		{
			throw new BookStockException("余额不足");
		}
		
		String sql = "update account set balance = balance-? where username = ?";
		jdbcTemplate.update(sql, price, username);
	}
	
}
