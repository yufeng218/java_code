<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>使用useBean动作元素来创建javaBean实例</h1><br/>
		<jsp:useBean id="myUser" class="org.my.code.User" scope="page"></jsp:useBean>
		<hr />
		
		用户名:<%=myUser.getUsername() %><br />
		密    码:<%=myUser.getPassword() %>
		
	</body>
</html>