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
    //������������ʱ�����ø÷�����ʼ��
    public void contextInitialized(ServletContextEvent e)
    {   
        cxt = e.getServletContext();
    }
    
    @Override
    //�����ڹرյ�ʱ�����ø÷�������
    public void contextDestroyed(ServletContextEvent arg0)
    {
        cxt = null;
    }

    
    @Override
    //����session��ʱ�����ø÷���
    public void sessionCreated(HttpSessionEvent arg0)
    {
        counts++;
        cxt.setAttribute("counts", new Integer(counts));
    }

    @Override
    //session���ٵ�ʱ�����ø÷���
    public void sessionDestroyed(HttpSessionEvent arg0)
    {
        counts--;
        cxt.setAttribute("counts", new Integer(counts));
    }

}
