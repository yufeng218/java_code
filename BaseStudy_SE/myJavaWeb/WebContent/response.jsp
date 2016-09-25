<%@ page language="java" import="java.util.*,java.io.*" contentType="text/html; charset=utf-8"%>

<%
	//设置相应的MIME类型
	response.setContentType("text/html; charset=utf-8");
	
	out.println("<h1>response内置对象</h1>");
	out.println("<hr />");
	//out.flush();
	
	PrintWriter outer = response.getWriter();//获得输出流对象
	outer.println("PrintWriter的outer输出流");
	
	//response.sendRedirect("usrReg.jsp");//请求重定向
	
	//请求重定向
	//response.sendRedirect("request.jsp");
	
	//请求转发
	request.getRequestDispatcher("request.jsp").forward(request, response);
	
%>