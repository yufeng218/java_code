package com.my.ssh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.my.ssh.entities.Employee;

public class EmployeeDao
{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	public List<Employee> getAll()
	{
		String hql = "from Employee e left outer join fetch e.department";
		return getSession().createQuery(hql).list();
	}
	
	public void delete(Integer id)
	{
		String hql = "delete from Employee e where e.id = ?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	
}
