package com.my.ssh.actions;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.my.ssh.service.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport implements RequestAware
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EmployeeService employeeService;
	public void setEmployeeService(EmployeeService employeeService)
	{
		this.employeeService = employeeService;
	}

	public String list()
	{
		request.put("employees", employeeService.getAll());
		
		return "list";
	}
	
	private Map<String, Object> request;
	
	@Override
	public void setRequest(Map<String, Object> request)
	{
		this.request = request;
	}
	
}
