<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 条件:
		1. 原始数据: 1, Tom, 123456, tom@163.com,	12
		2. 密码不能被修改
		3. 表单回显, 模拟操作直接在表单填写对应的属性值
	 -->
	<form action="springmvc/testModelAttribute" method="post">
		<input type="hidden" name="id" value="1" />
		username: <input type="text" name="username" value="Tom"/> <br/>
		email: <input type="text" name="email" value="tom@163.com"/> <br/>
		age: <input type="text" name="age" value="12"/> <br/>
		<input type="submit" value="提交"/>
	</form>
	<br/><br/>
	
	<a href="springmvc/testSessionAttributes">Test SessionAttributes</a> <br/><br/>
	
	<a href="springmvc/testMap">Test Map</a> <br/><br/>
	
	<a href="springmvc/testModelAndView">Test ModelAndView</a> <br/><br/>
	
	<a href="springmvc/testServletAPI">Test ServletAPI</a> <br/><br/>
	
	<a href="helloworld">Hello World</a> <br/><br/>
	
	
	 
</body>
</html>