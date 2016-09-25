package com.my.spring.struts2.beans;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class TestServletActionContextAction
{
	/**
	 * 使用ServletActionContext，可以从中获取到当前Action对象需要的一切Servlet API相关对象；
	 *
	 * @return
	 */
	public String execute()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = ServletActionContext.getRequest().getSession();
		ServletContext servletContext = ServletActionContext.getServletContext();
		
		System.out.println("execute...");
		return "success";
	}
}
