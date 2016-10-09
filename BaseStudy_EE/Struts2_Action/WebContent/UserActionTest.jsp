<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>页面</title>
	</head>
	<body>
		
		<%--
			指明要调用的方法，格式： ActionName!methodName.action
		 --%>
		<a href="<%=path %>/user!login.action">Login</a><br/>
		<a href="<%=path %>/user!register.action">Register</a><br/>
		
		<hr/>
		
		<h4>通配符</h4>
		<a href="<%=path %>/loginAction.action">Login</a><br/>
		<a href="<%=path %>/registerAction.action">Register</a><br/>
		
	</body>
</html>