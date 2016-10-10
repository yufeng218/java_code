package com.my.struts.app;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

public class EmployeeAction implements RequestAware
{
	private Dao dao = new Dao();
	private Map<String, Object> request;

	public String list()
	{
		request.put("emps", dao.getEmployees());
		return "list";
	}
	
	//定义的employeeId，用来接收页面的请求参数
	private Integer employeeId;
	
	public String delete()
	{
		dao.delete(employeeId);
		
		//返回的结果类型为: redirectAction;
		//也可以是chain: 实际上chain是没有必要的，因为不需要在下一个Action中保留当前Aciton的状态
		//若使用chain，则到达目录页面后，地址栏显示的仍然是删除的那个链接，页面刷新时会有重复提交;
		return "success";
	}
	
	private String firstName;
	private String lastName;
	private String email;
	
	public String save()
	{
		//1、获取请求参数: 通过定义对应属性的方式
		//2、调用 Dao 的 save 方法
		Employee employee = new Employee(null, firstName, lastName, email);
		dao.save(employee);
		
		//3、通过redirectAction 的方式响应结果给 emp-list
		return "success";
	}
	
	@Override
	public void setRequest(Map<String, Object> request)
	{
		this.request = request;
	}

	public Integer getEmployeeId()
	{
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId)
	{
		this.employeeId = employeeId;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
	
}
