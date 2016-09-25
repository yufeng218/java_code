<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>JSP setProperty</title>
	</head>
	<body>
		<h1 align="center">系统登录</h1>
		<!--  h1>使用setProperty动作元素来给javaBean实例的属性赋值</h1--><br/>
		<div align="center">
			<form name="loginForm" action="5setPropertyDoLogin.jsp?mypass=8888" method="post">
				<table>
					<tr>
						<td>用户名:</td>
						<td><input type="text" name="username" value=""/></td>
					</tr>
					<tr>
						<td>密码:</td>
						<td><input type="text" name="password" value=""/></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="登录" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		
	</body>
</html>