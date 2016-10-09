<%@page import="java.util.Date"%>
<%@page import="com.my.struts.valuestack.PersonComparator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.my.struts.valuestack.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		
		<s:debug></s:debug>
		
		<s:url value="/getProduct" var="url1">
			<!-- 对于value的值会自动进行OGNL解析， 若不希望进行OGNL解析则使用单引号括起来 -->
			<s:param name="productId" value="productId"></s:param>
		</s:url>
		${url1 }
		
		<br/><br/>
		<!-- 构建一个action的地址 -->
		<s:url action="testAction" namespace="/hello" method="save" var="url2">
		</s:url>
		${url2 }
		
		<br/><!-- *************************** --><br/>
		
		s:set :在以下 Map 对象里创建一个键值对; ContextMap 值栈;
		向Map类型的page、request、session、application 域对象中加入一个属性值;<br/>
		<!-- 对value属性值自动的进行OGNL解析     -->
		<s:set name="myName" value="productName" scope="request"></s:set>
		productName:{requestScope.myName }<br/>
		
		productName:${productName }<br/>
		从值栈中取值:<s:property value="[0].productName"/> 或   <s:property value="productName"/>
		
		<br/><!-- *************************** --><br/>
		
		s:push 在标签起始时把一个对象压入栈, 标签结束时将对象弹出栈;<br/>
		<%
			Person person = new Person();
			person.setName("zhangsan");
			person.setAge(13);
			
			request.setAttribute("per", person);
		%>
		<s:push value="#request.per">
			${per.name }
		</s:push>
		
		<br/><!-- *************************** --><br/>
		s:if, s:else, s:elseif
		<br/>
		<!-- 可以直接使用值栈中的属性 -->
		<s:if test="productPrice > 1000">
			I7处理器
		</s:if>
		<s:elseif test="productPrice >800">
			I5处理器
		</s:elseif>
		<s:else>
			I3处理器
		</s:else>
		
		<br/><!-- *************************** --><br/>
		iterator 标签用来遍历一个数组或集合, 并把这个可遍历对象里的每一个元素依次压入和弹出值栈<br/>
		<%
			List<Person> persons = new ArrayList<Person>();
			persons.add(new Person("AA", 10));
			persons.add(new Person("BB", 20));
			persons.add(new Person("CC", 30));
			persons.add(new Person("DD", 40));
			persons.add(new Person("EE", 50));
			
			request.setAttribute("persons", persons);
		%>
		
		<s:iterator value="#request.persons" status="status">
			index:${status.index} - count:${status.count}: ${name } -- ${age }<br/>
		</s:iterator>
		
		<br/><br/>
		
		<!-- 通过Product类中的get/set方法放入值栈中的 -->
		<s:iterator value="persons">
			${name } -- ${age }<br/>
		</s:iterator>
		
		<br/><!-- *************************** --><br/>
		s:sort 标签用来对一个可遍历对象里的元素进行排序;<br/>
		<%
			PersonComparator pc = new PersonComparator();
			request.setAttribute("comparator", pc);
		%>
		<s:sort comparator="#request.comparator" source="persons" var="persons2">
			<s:iterator value="#attr.persons2">
				${name } --- ${age }<br/>
			</s:iterator>
		</s:sort>
		
		
		<br/><!-- *************************** --><br/>
		s:date 标签用来对 Date 对象进行排版;<br/>
		<%
			Date date = new Date();
			request.setAttribute("date", date);
		%>
		<s:date name="#request.date" format="yyyy-MM-dd hh:mm:ss" var="date2"/>
		date:${date2 }
		
		
		<br/><!-- *************************** --><br/>
		s:a 标签将呈现为一个 HTML 连接.这个标签可以接受 HTML 语言中的 a 元素所能接受的所有属性
		
		
	</body>
</html>