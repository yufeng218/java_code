<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>My JSP 'request.jsp' page</title>
	</head>
	<body>
		<h1>request内置对象</h1>
		<%
			request.setCharacterEncoding("utf-8");
			request.setAttribute("passwd", "1234565");//设置密码
		%>
		用户名:<%=request.getParameter("username") %><br/>
		爱好:<%
				if(request.getParameterValues("favorite") != null)
				{
					String[] favorite = request.getParameterValues("favorite");
					for(String str : favorite)
					{
						out.print(str+"&nbsp;&nbsp;");
					}
				}
			%>
		<br />
		<!-- 获取密码 -->
		密码:<%=request.getAttribute("passwd") %><br/>
		请求体的MIME类型:<%=request.getContentType() %>><br/>
		协议的版本类型及版本号:<%=request.getProtocol() %><br/>
		接收请求服务器的主机名:<%=request.getServerName() %><br/>
		服务器的端口号:<%=request.getServerPort() %><br />
		请求体的长度:<%=request.getContentLength() %><br />
		客户端的IP地址:<%=request.getRemoteAddr() %><br />
		 
		虚拟路径的真实路径:<%=request.getRealPath("request.jsp") %><br />
		请求的上下文路径:<%=request.getContextPath() %> <br />
		
	</body>
</html>