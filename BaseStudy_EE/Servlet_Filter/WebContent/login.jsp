<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		${requestScope.error }
		<form name="f1" action="/Servlet_Filter/servlet/LoginServlet" method="post">
			<table boder="0">
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="username"  /></td>
				</tr>
				<tr>
					<td>密&nbsp;&nbsp;码：</td>
					<td><input type="password" name="password"  /></td>
				</tr>
				
				<tr align="center">
					<td colspan="2">
						<input type="submit" value="提交内容" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>