<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String name = "";
	String passwd = "";
	request.setCharacterEncoding("utf-8"); //设置页面的编码格式
	name = request.getParameter("username");
	passwd = request.getParameter("password");
	
	if(name.equals("admin") && passwd.equals("admin"))
	{
		session.setAttribute("loginUser", name);
		//服务器内部转发,服务器的行为；URL地址不变
		request.getRequestDispatcher("pro1_loginsuccess.jsp").forward(request, response);
	}
	else
	{
		//请求重定向,客户端行为；URL地址会改变
		response.sendRedirect("pro1_loginfail.jsp");
	}
	
%>
