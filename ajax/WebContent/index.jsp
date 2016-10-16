<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		
		<script type="text/javascript">
			
			window.onload = function(){
				//1. 获取a节点，并对其添加onclick响应函数
				document.getElementsByTagName("a")[0].onclick = function(){
					
					//3. 创建一个XMLHttpRequest 对象
					var request = new XMLHttpRequest();
					
					//4. 准备发送请求的数据： url
					var url = this.href + "?time=" + new Date();
					//var method = "get";
					var method = "post";
					
					//5. 调用 XMLHttpRequest 的 open 方法
					request.open(method, url);
					
					request.setRequestHeader("ContentType", "application/x-www-form-urlencoded");
					
					//6. 调用 XMLHttpRequest 的 send 方法
					//request.send(null);
					request.send("name='study'");
					
					//7. 为XMLHttpRequest 对象添加 onreadystatechange 响应函数
					request.onreadystatechange = function(){
						//8. 判断响应是否完成： XMLHttpRequest对象的 readyState 属性值为 4 的时候
						if(request.readyState == 4)
						{
							//9. 判断响应是否可用： XMLHttpRequest对象的 state 属性值为 200
							if(request.status == 200 || request.status == 304)
							{
								//10. 打印响应结果： responseText
								alert(request.responseText);
							}
						}
						
					};
					
					//2. 取消a节点的默认行为
					return false;
				};
				
			};
		
		</script>
		
	</head>
	<body>
	
		<a href="helloAjax.txt">Hello Ajax</a>
	
	</body>
</html>



