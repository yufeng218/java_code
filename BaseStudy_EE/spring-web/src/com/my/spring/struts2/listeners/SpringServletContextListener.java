package com.my.spring.struts2.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Application Lifecycle Listener implementation class
 * SpringServletContextListener
 * 
 */
@WebListener
public class SpringServletContextListener implements ServletContextListener
{

	/**
	 * Default constructor.
	 */
	public SpringServletContextListener()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0)
	{
		//1、获取Spring配置文件的名称
		ServletContext servletContext = arg0.getServletContext();
		String config = servletContext.getInitParameter("configLocation");
		
		//2、创建IOC容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
		
		//3、把IOC容器放在ServletContext的一个属性中
		servletContext.setAttribute("ApplicationContext", ctx);
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0)
	{
		// TODO Auto-generated method stub

	}

}
