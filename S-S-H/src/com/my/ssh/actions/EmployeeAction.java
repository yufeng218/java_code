package com.my.ssh.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.my.ssh.service.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport implements RequestAware
{
	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService;
	private Integer id;

	public void setId(Integer id)
	{
		this.id = id;
	}

	public void setEmployeeService(EmployeeService employeeService)
	{
		this.employeeService = employeeService;
	}

	public String list()
	{
		request.put("employees", employeeService.getAll());

		return "list";
	}

	private InputStream inputStream;

	public InputStream getInputStream()
	{
		return inputStream;
	}

	public String delete()
	{
		try
		{
			employeeService.delete(id);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
			try
			{
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			}
			catch (UnsupportedEncodingException e1)
			{
				e1.printStackTrace();
			}
		}
		return "delete";
	}

	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> request)
	{
		this.request = request;
	}

}
