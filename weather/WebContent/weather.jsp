<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<style type="text/css">
		#info {
			float: left;
		}
	</style>
	
	<script src="plugin/jquery.min.js" type="text/javascript"></script>
	<script>
		$(function(){
			var icty=$("select option:selected").text();	
			getWeatherCond(icty);
			$("#city").change(function(){
				var cty=$("select option:selected").text();	
				getWeatherCond(cty);
			});
		});
		
		function getWeatherCond(cty){
							
				$.ajax({
					type:"GET",
					headers:{apikey:'0ae09eed4f3c0267cb6e6ed7e1cdda8f'},
					url:"http://apis.baidu.com/heweather/weather/free?city="+cty+"",
					dataType:"json",
					success:function(result){
						if(result){
							var data=result["HeWeather data service 3.0"];
							var txt=data[0].now.cond.txt;
							var tmp =data[0].now.tmp;
							var wddir = data[0].now.wind.dir;
							$("#txt").text(txt);
							$("#tmp").text(tmp);
							$("#wddir").text(wddir);
							
							var curtDate = new Date();
							var nYear = curtDate.getFullYear();
							var nMonth = curtDate.getMonth() + 1; 
							var nDay = curtDate.getDate();
							var nowDate = nYear + "-" + nMonth + "-" + nDay;
							var mDay = curtDate.getDate() + 1; 
							var nextDate = nYear + "-" + nMonth + "-" + mDay;
							
							var obj = data[0].daily_forecast;
							$.each(obj,function(n,value) {
						    	if(value.date == nowDate)
						    	{
									$("#txt_d").text(value.cond.txt_d);
									$("#txt_n").text(value.cond.txt_n);
									$("#tmp_max").text(value.tmp.max);
									$("#tmp_min").text(value.tmp.min);
						    	}
						    	if(value.date == nextDate)
					    		{
						    		$("#txtd").text(value.cond.txt_d);
									$("#txtn").text(value.cond.txt_n);
									$("#tmpMax").text(value.tmp.max);
									$("#tmpMin").text(value.tmp.min);
					    		}
							});
							
						}
					},
					error:function(){
						alert("加载失败!");
					}
			})		
		}
	</script>
  </head>
  
  <body>
   
   <div style="text-align:center;">
   		<select id="city" style="width:150px;height:28px;border:none;font-size:20px;">
   			<option>西安</option>
   			<option>北京</option>
   			<option>上海</option>
   			<option>天津</option>
   		</select>
   </div>
   <hr>
   
   <div style="text-align:center;">
   		<span>现在:</span><br/>
   		&nbsp;&nbsp;&nbsp;&nbsp;<label>天气:</label><span id="txt"></span><br/>
   		&nbsp;&nbsp;&nbsp;&nbsp;<label>温度:</label><span id="tmp"></span>摄氏度<br/>
   		&nbsp;&nbsp;&nbsp;&nbsp;<label>风向:</label><span id="wddir"></span><br/>
   </div>
   
   <div id="info">
   		<span>今天:</span><br/>
   		&nbsp;&nbsp;&nbsp;&nbsp;<label>天气:</label><span id="txt_d"></span>转<span id="txt_n"></span><br/>
   		&nbsp;&nbsp;&nbsp;&nbsp;<label>温度:</label><span id="tmp_min"></span>-<span id="tmp_max"></span>摄氏度<br/>
   </div>
   
   <div id="info">
   		<span>明天:</span><br/>
   		&nbsp;&nbsp;&nbsp;&nbsp;<label>天气:</label><span id="txtd"></span>转<span id="txtn"></span><br/>
   		&nbsp;&nbsp;&nbsp;&nbsp;<label>温度:</label><span id="tmpMin"></span>-<span id="tmpMax"></span>摄氏度<br/>
   	</div>
  
  </body>
</html>
