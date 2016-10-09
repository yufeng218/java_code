package com.my.demo2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicServlet extends HttpServlet
{
    private String encode = null;

    public BasicServlet()
    {
        System.out.println("BasicServlet");
    }

    @Override
    public void init() throws ServletException
    {
        // 从web.xml中获取全局的参数
        String url = this.getServletContext()
                .getInitParameter("url");
        System.out.println(url);

        // 从web.xml中获取局部的参数
        String username = this.getInitParameter("username");
        System.out.println(username);
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        System.out.println("doGet");
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        
        PrintWriter out = response.getWriter();
        out.println("my Servlet");
        
        String username = request.getParameter("username");
        if(username != null && username.equals("zhangsan"))
        {
            //请求转发
            request.getRequestDispatcher("/success.html").forward(request, response);
           
            //请求包含
            //request.getRequestDispatcher("/success.html").include(request, response);
        }
        else
        {
            //请求重定向
            response.sendRedirect("/Servlet_Pro2/failure.html");
            
        }
        out.close();
        //System.out.println("doPost");
    }

    
    // @Override
    // protected void service(HttpServletRequest request, HttpServletResponse
    // arresponseg1) throws ServletException, IOException
    // {
    // System.out.println("service");
    // }
    
}
