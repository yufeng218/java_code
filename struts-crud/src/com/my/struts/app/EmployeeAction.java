package com.my.struts.app;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class EmployeeAction implements RequestAware, ModelDriven<Employee>
{
	private Dao dao = new Dao();

	private Employee employee;

	private Integer employeeId;

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

	public String edit()
	{
		// 1、获取请求参数 employeeId: employee.getEmployeeId()
		// 2、根据employeeId 获取 Employee 对象
		// Employee emp = dao.get(employee.getEmployeeId());

		// 3、 把栈顶对象的属性装配好: 此时栈顶对象是employee
		// 目前的employee 对象只有 employeeId 属性，其他属性为 null
		/*
		 * struts2中表单回显时: 从值栈栈顶开始查找匹配的属性，若找到就添加到value 属性中;
		 */
		// employee.setEmail(emp.getEmail());
		// employee.setFirstName(emp.getFirstName());
		// employee.setLastName(emp.getLastName());

		// 手动的把从数据库中获取的employee对象放入到值栈的栈顶. 不够完美
		// ActionContext.getContext().getValueStack()
		// .push(dao.get(employee.getEmployeeId()));

		return "edit";
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
		// 判断是Create 还是 Edit
		// 若为Create, 则employee = new Employee();
		// 若为Edit, 则employee = dao.get(employee.getEmployeeId());
		// 判断标准为是否有 employeeId这个参数, 有则为edit，无则为Create;
		// 若函数通过 employeeId 来判断, 则需要在 modelDriven 拦截之前就执行一个params 拦截器!
		// 而这个可以通过使用 paramsPrepareParams 拦截器栈实现,
		// 则需要在 struts.xml 文件中配置使用 paramsPrepareParams 作为默认的拦截器栈;
		if (employeeId == null)
		{
			employee = new Employee();
		}
		else
		{
			employee = dao.get(employeeId);
		}
		return employee;
	}

}
