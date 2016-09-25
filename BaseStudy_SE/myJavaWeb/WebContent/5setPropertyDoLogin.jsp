<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>JSP setProperty</title>
	</head>
	<body>
		<h1>使用setProperty动作元素来给javaBean实例的属性赋值</h1><br/>
		<!-- 实例化一个javabean -->
		<jsp:useBean id="myUser" class="org.my.code.User" scope="page"></jsp:useBean>
		
		
		<!-- 根据表单自动匹配所有的属性 -->
		<%-- 
		<jsp:setProperty property="*" name="myUser"/>
		用户名:<%=myUser.getUsername() %><br />
		密    码:<%=myUser.getPassword() %>
		--%>
		
		<!-- 根据表单自动匹配部分的属性 --%>
		<%-- 
		<jsp:setProperty property="username" name="myUser"/>
		用户名:<%=myUser.getUsername() %><br />
		--%>
		
		
		<!-- 与表单无关，通过手动给属性赋值 -->
		<%-- 
		<jsp:setProperty name="myUser" property="username" value="wangwu"/>
		<jsp:setProperty name="myUser" property="password" value="123456"/>
		用户名:<%=myUser.getUsername() %><br />
		密    码:<%=myUser.getPassword() %>
		--%>
		
		
		<!-- 通过URL传参数给属性赋值 -->
		<jsp:setProperty name="myUser" property="username" />
		<jsp:setProperty name="myUser" property="password" param="mypass"/>
		用户名:<%=myUser.getUsername() %><br />
		密    码:<%=myUser.getPassword() %>
		
	</body>
</html>