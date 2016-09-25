package com.my.spring.struts2.beans;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

/**
 * 通过实现ServletXxxAware接口的方式可以由Struts2注入需要的Servlet相关对象；
 *
 */
public class TestServletAwareAction 
	implements ServletRequestAware, ServletContextAware, ServletResponseAware
{
	private HttpServletResponse response;
	private ServletContext servletContext;
	private HttpServletRequest request;
	/**
	 * HttpSession 可以由 request.getSession()获取；
	 */
	
	@Override
	public void setServletResponse(HttpServletResponse response)
	{
		this.response = response;
		System.out.println("获取的response:" + response);
	}

	@Override
	public void setServletContext(ServletContext servletContext)
	{
		this.servletContext = servletContext;
		System.out.println("获取的servletContext:" + servletContext);
	}

	@Override
	public void setServletRequest(HttpServletRequest servletContext)
	{
		this.request = request;
		System.out.println("获取的servletContext:" + servletContext);
	}
	
	public String execute()
	{
		return "success";
	}
	
}
