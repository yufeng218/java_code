<%@page import="com.my.struts.form.City"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		
		<s:debug></s:debug>
		
		
		<%
			List<City> cities = new ArrayList<City>();
			cities.add(new City(1001, "AA"));
			cities.add(new City(1002, "BB"));
			cities.add(new City(1003, "CC"));
			cities.add(new City(1004, "DD"));
			
			request.setAttribute("cities", cities);
		%>
		
		<!-- 
		表单标签:
			1、struts2的form标签会自动生成一个table，以进行自动的排版;
			2、可以对表单值进行回显;
			3、struts2的form标签回显:
				从栈顶对象开始匹配属性,并把匹配的属性值赋到对应标签的value中;
				若栈顶对象没有对应的属性，则依次向下找对应的属性;
		 -->
		<s:form action="save">
			<s:hidden name="userId"></s:hidden>
			
			<s:textfield name="userName" label="UserName" ></s:textfield>
			<s:password name="password" label="Password" showPassword="true"></s:password>
			<s:textarea name="desc" label="Desc"></s:textarea>
			
			<s:checkbox name="married" label="Married"></s:checkbox>
			
			<s:radio name="gender" list="#{'1':'Male','0':'Female' }" 
				label="Gender"></s:radio>
			
			<!-- 服务端要使用集合类型，以保证能够被正常的回显 -->
			<s:checkboxlist name="city" list="#request.cities" 
				listKey="cityId" 
				listValue="cityName" 
				label="City">
			</s:checkboxlist>
			
			<s:select name="age" list="{11,12,13,14,15,16,17,18,19,20}"
				headerKey="" 
				headerValue="请选择" 
				label="Age">
				<!-- 
					s:optgroup 可用作 s:select的子标签，用于显示更多的下拉框;
					注意: 必须有键值对，而不能使用一个集合让其值即作为键又作为值;
				 -->
				<s:optgroup label="21-30" list="#{21:21,22:22,23:23}"></s:optgroup>
				<s:optgroup label="31-40" list="#{31:31,32:32,33:33}"></s:optgroup>
			</s:select>
			
			<s:submit ></s:submit>
		</s:form>
		
		
		<!-- 
		checkbox标签:
			当包含着一个复选框的表单被提交时, 如果某个复选框被选中了,
			 它的值将为 true, 这个复选框在 HTTP 请求里增加一个请求参数.
			 但如果该复选框未被选中, 在请求中就不会增加一个请求参数
		 -->
		<s:form action="save">
			<s:checkbox name="married" label="Married"></s:checkbox>
			<s:submit ></s:submit>
		</s:form>
		
		
		
		
	</body>
</html>