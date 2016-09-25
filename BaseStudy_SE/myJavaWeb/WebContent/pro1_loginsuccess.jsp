<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>登录成功页面</title>
	</head>
	<body>
		<div id="container" align="center">
			<div class="logo" >
				<a href="#" ><img alt="" src="login.png"></a>
			</div>
			<div id="box">
				<%
					String username = "";
					if(session.getAttribute("loginUser") != null)
					{
						username = session.getAttribute("loginUser").toString();
					}
				%>
				欢迎<font color="red"><%=username %></font>用户登录成功！
			</div>
		</div>
		
	</body>
</html>