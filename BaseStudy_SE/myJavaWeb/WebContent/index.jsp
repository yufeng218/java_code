<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>我的个人主页</title>
</head>
<body>
  <h1>欢迎大家学习javaee开发</h1>
  <hr/>
  <!-- HTML注释，在客户端可见 -->
  <%-- JSP注释，在客户端不可见 --%>
  <%!
  	String s = "张三";//声明了一个字符串变量
  	int add(int a, int b)//声明了一个求和的方法
  	{
  		return a + b;
  	}
  %>
  
  <br />
     你好，<%=s %> <br />
  a+b=<%=add(10,5) %><br/>
  
  <hr/><br/>
  <%
  	//单行注释
  	/*多行注释，客户端不可见*/
  	out.print("大家好，欢迎学习！");//给浏览器输出文本信息
  %>
</body>
</html>