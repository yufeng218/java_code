package com.my.spring.hibernate.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.my.spring.hibernate.dao.BookShopDao;
import com.my.spring.hibernate.exception.BookStockException;

@Repository
public class BookShopDaoImpl implements BookShopDao
{
	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * 不推荐使用HibernateTemplate 和 HibernateDaoSupport，
	 * 因为这样会导致Hibernate和Spring的API进行耦合，可移植性变差；
	 * private HibernateTemplate hibernateTemplate;
	 */
	
	//获取和当前线程绑定的session
	private Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Double findBookPriceByIsbn(String isbn)
	{
		String hql = "select b.price from Book b where b.isbn = ?";
		Query query = getSession().createQuery(hql).setString(0, isbn);
		return (Double) query.uniqueResult();
	}

	@Override
	public void updateBookStock(String isbn)
	{
		//验证书的库存是否充足
		String hql1 = "select b.stock from Book b where isbn = ?";
		Query query1 = getSession().createQuery(hql1).setString(0, isbn);
		int stock = (int) query1.uniqueResult();
		if(stock == 0)
		{
			throw new BookStockException("库存不足:"+isbn);
		}
		
		String hql = "update Book b set b.stock = b.stock - 1 where b.isbn = ?";
		Query query = getSession().createQuery(hql).setString(0, isbn);
		query.executeUpdate();
	}

	@Override
	public void updateUserAccount(String username, Double price)
	{
		// 验证余额是否充足
		String hql1 = "select a.balance from Account a where username = ?";
		Query query1 = getSession().createQuery(hql1).setString(0, username);
		double balance = (double) query1.uniqueResult();
		if(balance < price)
		{
			throw new BookStockException("余额不足");
		}
		
		String hql = "update Account a set a.balance = a.balance - ? where username = ?";
		Query query = getSession().createQuery(hql)
					.setDouble(0, price).setString(1, username);
		query.executeUpdate();
	}

}
