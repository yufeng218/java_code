<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String path = request.getContextPath();
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>上传的页面</title>
	</head>
	<body>
		
		<form name="f1" id="f1" action="<%=path %>/upAction.action" method="post"
		 enctype="multipart/form-data">
			<table>
				<tr>
					<td>File:</td>
					<td><input type="file" name="upload" id="f" /></td>
				</tr>
				<tr>
					<td>File:</td>
					<td><input type="file" name="upload" id="f" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="upload"/>
					</td>
				</tr>
			</table>
		</form>
		
	</body>
</html>