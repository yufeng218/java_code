package com.my.ssh.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.my.ssh.dao.BaseDao;

/**
 * 抽象的dao实现，专门用于继承
 */
@SuppressWarnings("unchecked")	//忽略警告
public abstract class BaseDaoImpl<T> implements BaseDao<T>
{
	// 注入sessionFactory
	@Autowired
	private SessionFactory sessionFactory;
	
	private Class<T> clazz;
	
	public BaseDaoImpl()
	{
		/*  得到泛型的父类;
		 *	Type是 Java 编程语言中所有类型的公共高级接口。它们包括原始类型、参数化类型、
		 * 	数组类型、类型变量和基本类型。
		 */
		Type type =  this.getClass().getGenericSuperclass();
		
		//ParameterizedType参数化类型，即泛型  
		ParameterizedType pType = (ParameterizedType) type;
		
		//getActualTypeArguments获取参数化类型的数组，泛型可能有多个  
		clazz = (Class<T>) pType.getActualTypeArguments()[0];
	}
	
	@Override
	public void saveEntity(T t)
	{
		sessionFactory.getCurrentSession().save(t);
	}

	@Override
	public void saveOrUpdateEntity(T t)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(t);
	}

	@Override
	public void updateEntity(T t)
	{
		sessionFactory.getCurrentSession().update(t);
	}

	@Override
	public void deleteEntity(T t)
	{
		sessionFactory.getCurrentSession().delete(t);
	}
	
	/**
	 *  按照HQL语句进行批量更新
	 */
	@Override
	public void batchEntityByHQL(String hql, Object... objects)
	{
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		for(int i = 0; i < objects.length; i++)
		{
			query.setParameter(i, objects[i]);
		}
		query.executeUpdate();
	}
	
	/**
	 * 	load获取不到返回异常，可以产生代理;
	 *  get 获取不到返回null，不可以产生代码;
	 */
	@Override
	public T loadEntity(Integer id)
	{
		return (T) sessionFactory.getCurrentSession().load(clazz, id);
	}

	@Override
	public T getEntity(Integer id)
	{
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	@Override
	public List<T> findEntityByHQL(String hql, Object... objects)
	{
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		for(int i = 0; i < objects.length; i++)
		{
			query.setParameter(i, objects[i]);
		}
		return query.list();
	}

}
