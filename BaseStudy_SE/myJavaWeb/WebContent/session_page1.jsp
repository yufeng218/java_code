<%@ page language="java" import="java.util.*,java.text.*" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>My JSP 'session_page1.jsp' page</title>
	</head>
	<body>
		<h1>session 内置对象</h1>
		<hr />
		<%
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date(session.getCreationTime());
			session.setAttribute("username", "admin");
			session.setAttribute("password", "12345");
			session.setAttribute("age", "20");
			
			//设置当前的session最大生成期限，单位是秒
			session.setMaxInactiveInterval(10);//10秒
			
			
		%>
		session创建时间:<%=sdf.format(date) %><br/>
		session的ID编号：<%=session.getId() %><br />
		从session中获取用户名:<%=session.getAttribute("username") %>
		<br>
		<a href="session_page2.jsp" target="_blank">跳转到session_page2.jsp页面</a>
		
		<%

			//销毁当前会话
			session.invalidate();
		%>
		
	</body>
</html>