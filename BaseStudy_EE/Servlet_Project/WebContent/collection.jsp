<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>收藏链接页面</title>
	</head>
	<body>
		
		<form name="f1" id="f1" action="<%=path %>/servlet/collection?action=save" method="post">
			<table boder="0">
				<tr>
					<td>收&nbsp;藏&nbsp;名：</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>URL链接：</td>
					<td><input type="text" name="url" value="http://" /></td>
				</tr>
				
				<tr align="center">
					<td colspan="2">
						<input type="submit" value="保存" />
					</td>
				</tr>
			</table>
		</form>
		<hr/>
		
		<c:forEach var="info" items="${DataInfo}" >
			${info.id }
			${info.name }
			<a href="${info.url }">${info.url }</a>
			
			<a href="<%=path%>/servlet/collection?action=get&id=${info.id}">Edit</a>
			<br/>
		</c:forEach>
		
	</body>
</html>