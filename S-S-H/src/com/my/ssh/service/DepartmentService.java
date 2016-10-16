package com.my.ssh.service;

import java.util.List;

import com.my.ssh.dao.DepartmentDao;
import com.my.ssh.entities.Department;

public class DepartmentService
{
	private DepartmentDao departmentDao;
	
	public void setDepartmentDao(DepartmentDao departmentDao)
	{
		this.departmentDao = departmentDao;
	}
	
	public List<Department> getAll()
	{
		return departmentDao.getAll();
	}
	
}
