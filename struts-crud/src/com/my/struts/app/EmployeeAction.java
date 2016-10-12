package com.my.struts.app;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class EmployeeAction implements RequestAware, ModelDriven<Employee>, Preparable
{
	private Dao dao = new Dao();

	private Employee employee;	//创建压入值栈栈顶的对象
	private Integer employeeId;	//接收参数

	public void setEmployeeId(Integer employeeId)
	{
		this.employeeId = employeeId;
	}

	public String list()
	{
		request.put("emps", dao.getEmployees());
		return "list";
	}

	public String delete()
	{
		dao.delete(employeeId);

		// 返回的结果类型为: redirectAction;
		// 也可以是chain: 实际上chain是没有必要的，因为不需要在下一个Action中保留当前Aciton的状态
		// 若使用chain，则到达目录页面后，地址栏显示的仍然是删除的那个链接，页面刷新时会有重复提交;
		return "success";
	}

	public String save()
	{
		// 1、获取请求参数: 通过定义对应属性的方式
		// 2、调用 Dao 的 save 方法
		dao.save(employee);

		// 3、通过redirectAction 的方式响应结果给 emp-list
		return "success";
	}
	
	/**
	 * 为 save() 方法准备model
	 */
	public void prepareSave()
	{
		employee = new Employee();
	}
	
	public String update()
	{
		dao.update(employee);
		return "success";
	}
	
	/**
	 * 为 update() 方法准备model
	 */
	public void prepareUpdate()
	{
		employee = new Employee();
	}
	
	public String edit()
	{
		return "edit";
	}
	
	/**
	 * 为 edit() 方法准备model
	 */
	public void prepareEdit()
	{
		employee = dao.get(employeeId);
	}

	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> request)
	{
		this.request = request;
	}

	@Override
	public Employee getModel()
	{
		return employee;
	}
	
	/**
	 * prepare 方法的主要作用: 为getModel()方法准备 model 的;
	 * @throws Exception
	 */
	@Override
	public void prepare() throws Exception
	{
		//System.out.println("preapare");
	}

}
