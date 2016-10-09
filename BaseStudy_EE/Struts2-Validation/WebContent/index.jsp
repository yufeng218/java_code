<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登录</title>
		<script type="text/javascript">
			function validate()
			{
				var form = document.forms[0];
				var uname = form.username.value;
				var upasswd = form.password.value;
				if(uname == null || uname == "")
				{
					alert("用户名称是必填项");
					form.username.focus(); //光标定位到此处
					return;
				}
				if(upasswd == null || upasswd == "")
				{
					alert("用户密码是必填项");
					form.password.focus(); //光标定位到此处
					return;
				}
			}
		
		</script>
	</head>
	<body>
		
		<s:form action="register" validate="true">
			<s:textfield name="username" label="用户名称"></s:textfield>
			<s:password name="password" label="用户密码"></s:password>
			<s:textfield name="age" label="年龄"></s:textfield>
			<s:textfield name="url" label="个人主页"></s:textfield>
			<s:textfield name="birthday" label="生日"></s:textfield>
			<s:textfield name="email" label="Email"></s:textfield>
			<s:submit value="注册"></s:submit>
			<%-- 
			<input name="subimt" type="button" value="注册" onclick="validate()" />
			 --%>
		</s:form>
		
	</body>
</html>