<%@ page language="java" import="java.util.*,java.text.*" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>My JSP 'session_page2.jsp' page</title>
	</head>
	<body>
		<h1>session 内置对象</h1>
		<hr />
		<%
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//Date date = new Date(session.getCreationTime());
			//session.setAttribute("username", "admin");
		%>
		session的ID编号：<%=session.getId() %><br />
		从session中获取用户名:<%=session.getAttribute("username") %><br/>
		从session中获取保存的属性:<%
			String[] names = session.getValueNames();
			for(String x : names)
			{
				out.println(x+"<br/>");
			}
		%>
	</body>
</html>