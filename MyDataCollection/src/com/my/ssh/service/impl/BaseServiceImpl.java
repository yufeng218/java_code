package com.my.ssh.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.my.ssh.dao.BaseDao;
import com.my.ssh.service.BaseService;

/**
 * 抽象的BaseService，专门用于继承
 */
public abstract class BaseServiceImpl<T> implements BaseService<T>
{
	
	private BaseDao<T> dao;
	
	// 注入dao
	@Autowired
	public void setDao(BaseDao<T> dao)
	{
		this.dao = dao;
	}
	
	@Override
	public void saveEntity(T t)
	{
		dao.saveEntity(t);
	}

	@Override
	public void saveOrUpdateEntity(T t)
	{
		dao.saveOrUpdateEntity(t);
	}

	@Override
	public void updateEntity(T t)
	{
		dao.updateEntity(t);
	}

	@Override
	public void deleteEntity(T t)
	{
		dao.deleteEntity(t);
	}

	@Override
	public void batchEntityByHQL(String hql, Object... objects)
	{
		dao.batchEntityByHQL(hql, objects);
	}

	@Override
	public T loadEntity(Integer id)
	{
		return dao.loadEntity(id);
	}

	@Override
	public T getEntity(Integer id)
	{
		return dao.getEntity(id);
	}

	@Override
	public List<T> findEntityByHQL(String hql, Object... objects)
	{
		return dao.findEntityByHQL(hql, objects);
	}

}
