<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Employee List Page</title>
	</head>
	
	<!-- JQuery -->
	<script type="text/javascript" src="scripts/jquery.js"></script>
	<script type="text/javascript">
	
		$(function()
		{
			//1、点击delete时，弹出“确定要删除XXX的信息吗？”，若确定，执行删除；若不确定，则取消；
			$(".delete").click(function()
			{
				var $tr = $(this).parent().parent();
				var lastName = $(this).next(":input").val();
				var flag = confirm("确定要删除" + lastName + "的信息吗？");
				if(flag)
				{
					//删除，使用Ajax的方式
					var url = this.href;
					var args = {"time" : new Date()};
					$.post(url, args, function(data)
					{
						//若data的返回值是1， 则提示删除成功，且把当前行删除
						if(data == 1)
						{
							alert("删除成功");
							$tr.remove();//删除当前行
						}
						else //若data的返回值不是1，则提示删除失败
						{
							alert("删除失败");
						}
					});
				}
				
				return false;//取消超链接的默认行为
			});
			
		});
	
	</script>
	
	<body>
		
		<h4>Employee List Page</h4>
		
		<s:if test="#request.employees == null || #request.employees.size() == 0">
			没有任何员工信息
		</s:if>
		<s:else>
			<table border="1" cellpadding="10" cellspacing="0">
				<tr>
					<td>ID</td>
					<td>LastName</td>
					<td>Email</td>
					<td>Birth</td>
					<td>createTime</td>
					<td>Dept</td>
					<td>Edit</td>
					<td>Delete</td>
				</tr>
				<s:iterator value="#request.employees">
					<tr>
						<td>${id }</td>
						<td>${lastName }</td>
						<td>${email }</td>
						<td>
							<s:date name="birth" format="yyyy-MM-dd"/>
						</td>
						<td>
							<s:date name="createTime" format="yyyy-MM-dd hh:mm:ss"/>
						</td>
						<td>${department.departmentName }</td>
						<td>
							<a href="emp-input?id=${id }">修改</a>
						</td>
						<td>
							<a href="emp-delete?id=${id }" class="delete">删除</a>
							<input type="hidden" value="${lastName }"/>
						</td>
					</tr>
				</s:iterator>
			</table>
		</s:else>
		
		
	</body>
</html>