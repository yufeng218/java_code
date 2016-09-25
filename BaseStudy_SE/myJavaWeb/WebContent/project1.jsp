<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.io.IOException" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>九九乘法表</title>
  </head>
  <body>
	<h1>九九乘法表</h1>
	<%!
		//返回九九乘法表对应的HTML代码，通过表达式来调用
		String printMessage()
		{
			String result = "";
			for(int i = 1; i < 10; i++)
			{
				for(int j = 1; j < i+1; j++)
				{
					result += i+"x"+j+"="+i*j+"&nbsp;&nbsp;&nbsp;&nbsp;";
				}
				result += "<br />";
			}
			return result;
		}
		
		//通过JSP脚本的方式
		void printOut(JspWriter out) throws IOException
		{
			for(int i = 1; i < 10; i++)
			{
				for(int j = 1; j < i+1; j++)
				{
					out.print(i+"x"+j+"="+i*j+"&nbsp;&nbsp;&nbsp;&nbsp;");
				}
				out.print("<br />");
			}
		}
	%>
	
	<hr />
	<h4>表达式的方式实现九九乘法表</h4>
	<%=printMessage() %>
	
	<hr />
	<h4>JSP脚本调用的方式实现九九乘法表</h4>
	<%printOut(out); %>
  </body>
</html>