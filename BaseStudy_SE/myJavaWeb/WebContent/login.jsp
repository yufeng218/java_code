<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>My JSP 'login.jsp' page</title>
</head>
<body>
	<!--  <form action="dologin.jsp" name="loginForm" method="get">
	-->
	<form action="dologin.jsp" name="loginForm" method="post">
		<h1>用户登录</h1>
		<br />
		<table>
			<tr>
				<td>用户名:
					<input type="text" name="user" />
				</td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;&nbsp;码:
					<input type="password" name="passwd" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="登录" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>