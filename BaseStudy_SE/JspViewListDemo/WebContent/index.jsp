<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="org.util.*" %>
<%@page import="org.entity.*"%>
<%@ page import="org.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>my JSP 'index.jsp'</title>
		<style type="text/css">
			div{
				float:left;
				margin:10px;
			}
			div dd{
				margin:0px;
				font-size:10pt;
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
		<h1>商品展示</h1>
		<hr/>
		
		<center>
		<table width="750" height="60" cellpadding="0" cellspacing="0" border="0" >
			<tr>
				<td>
					<%
						itemsDao itsDao = new itemsDao();
						ArrayList<items> list = itsDao.getAllItems();
						if(list != null && list.size()>0)
						{
							for(int index = 0; index < list.size(); index++)
							{
					%>
					<!-- 商品循环开始  -->
					<div>
						<dl>
							<dt>
								<a href="details.jsp?id=<%=list.get(index).getId()%>"><img src="images/<%=list.get(index).getPicture() %>" width="120" height="90" border="1"></a>
							</dt>
							<dd class="dd_name"><%=list.get(index).getName() %></dd>
							<dd class="dd_city">产地：<%=list.get(index).getCity() %>&nbsp;&nbsp;价格：￥<%=list.get(index).getPrice() %></dd>
						</dl>
					</div>
					<%
							}
						}
					%>
					<!-- 商品循环结束 -->
				</td>
			</tr>
		</table>
		</center>
		
	</body>
</html>



