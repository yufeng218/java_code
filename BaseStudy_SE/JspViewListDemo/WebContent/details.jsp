<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="org.util.*" %>
<%@page import="org.entity.*"%>
<%@ page import="org.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>my JSP 'details.jsp'</title>
		<style type="text/css">
			div{
				float:left;
				margin-left:30px;
				margin-right:30px;
				margin-top:5px;
				margin-bottom:5px;
			}
			div dd{
				margin:0px;
				font-size:10px;
			}
			div dd.dd_name{
				color:blue;
			}
			div dd.dd_city{
				color:#000;
			}
		</style>
	</head>
	<body>
		<h1>商品详情</h1>
		<hr/>
		
		<center>
			<table width="750" height="60" cellpadding="0" cellspacing="0" border="0" >
				<tr>
					<%
						itemsDao itsDao = new itemsDao();
						int id = Integer.parseInt(request.getParameter("id"));
						items its = itsDao.getItemsById(id);
						if(its != null)
						{
					%>
					<td width="70%" valign="top">
						<table>
							<tr>
								<td rowspan="4"><img src="images/<%=its.getPicture() %>" width="200" height="160"/></td>
							</tr>
							<tr>
								<td><B><%=its.getName() %></B></td>
							</tr>
							<tr>
								<td>产地：<%=its.getCity() %></td>
							</tr>
							<tr>
								<td>价格：￥<%=its.getPrice() %></td>
							</tr>
						</table>
					</td>
					<%
						}
					%>
					
					<%
						
					%>
					<!-- 浏览过的商品 -->
					<td width="30%" bgcolor="#EEE" align="center" >
						<br/>
						<b>您浏览过的商品</b><hr/>
						
						<div>
							<dl>
								<dt>
									<a href="details.jsp" ><img src="images/aDi02.jpg" width="120" height="90" border="1"/></a>
								</dt>
								<dd class="dd_name">沃特</dd>
								<dd class="dd_city">产地：佛山&nbsp;&nbsp;价格：￥180</dd>
							</dl>
						</div>
						
					</td>
					
				</tr>
				
			</table>
		</center>
	</body>
</html>




