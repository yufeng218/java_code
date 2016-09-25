<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>登陆页面</title>
	</head>
	<body>
		<div id="container">
			<div class="logo" align="center">
				<a href="#" ><img alt="" src="login.png"></a>
			</div>
			<div id="box">
				<form action="pro1_doLogin.jsp" method="post">
					<p align="center">
						<label>用户名：</label>
						<input name="username" type="text" />
						<label>密   码：</label>
						<input name="password" type="password" />
					</p>
					<p align="center">
						<input type="submit" value="登录"/>
					</p>
				</form>
			</div>
		</div>
		
	</body>
</html>