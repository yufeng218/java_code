package com.my.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld
{
	/**
	 * 1. 使用 @RequestMapping 注解来映射请求的URL
	 * 2. 返回值会通过视图解析器解析为实际的物理视图, 对于 InternalResourceViewResolver 视图解析器会做出如下的所示:
	 * 	      通过 前缀(prefix) + 返回值 + 后缀(suffix)	这样的方式回到实际的物理视图, 然后做转发操作。
	 *    前缀: /WEB-INF/views/;  返回值: success;   后缀: .jsp;
	 *   	/WEB-INF/views/success.jsp
	 * @return
	 */
	@RequestMapping("/helloworld")
	public String hello()
	{
		System.out.println("hello world!");
		return "success";
	}
}
