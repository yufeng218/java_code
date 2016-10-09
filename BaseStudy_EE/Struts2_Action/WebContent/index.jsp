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
		<form name="f1" id="f1" action="<%=path %>/login.action" method="post">
			<table>
				${requestScope.tip }
				<tr>
					<td>Username:</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" /></td>
				</tr>
				
				<tr align="center">
					<td colspan="2">
						<input type="submit" value="Login" />
					</td>
				</tr>
			</table>
		</form>
		
		<hr/>
	</body>
</html>