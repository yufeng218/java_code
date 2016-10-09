package com.my.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineUsers implements ServletContextListener, HttpSessionListener
{
    private int counts;
    private ServletContext cxt;
    
    @Override
    //容器在启动的时候会调用该方法初始化
    public void contextInitialized(ServletContextEvent e)
    {   
        cxt = e.getServletContext();
    }
    
    @Override
    //容器在关闭的时候会调用该方法销毁
    public void contextDestroyed(ServletContextEvent arg0)
    {
        cxt = null;
    }

    
    @Override
    //创建session的时候会调用该方法
    public void sessionCreated(HttpSessionEvent arg0)
    {
        counts++;
        cxt.setAttribute("counts", new Integer(counts));
    }

    @Override
    //session销毁的时候会调用该方法
    public void sessionDestroyed(HttpSessionEvent arg0)
    {
        counts--;
        cxt.setAttribute("counts", new Integer(counts));
    }

}
