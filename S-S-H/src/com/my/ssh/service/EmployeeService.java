package com.my.ssh.service;

import java.util.List;

import com.my.ssh.dao.EmployeeDao;
import com.my.ssh.entities.Employee;

public class EmployeeService
{
	private EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao)
	{
		this.employeeDao = employeeDao;
	}
	
	public List<Employee> getAll()
	{
		List<Employee> employees = employeeDao.getAll();
		return employees;
	}
	
	public void delete(Integer id)
	{
		employeeDao.delete(id);
	}
	
	public void saveOrUpdate(Employee employee)
	{
		employeeDao.saveOrUpdate(employee);
	}
	
	public boolean lastNameIsVaild(String lastName)
	{
		return employeeDao.getEmployeeByLastName(lastName) == null;
	}
	
	public Employee get(Integer id)
	{
		return employeeDao.get(id);
	}
}
