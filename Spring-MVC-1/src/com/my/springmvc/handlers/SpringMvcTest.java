package com.my.springmvc.handlers;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.my.springmvc.bean.User;

@Controller
@RequestMapping("/springmvc")
//@SessionAttributes(value="user", types=String.class)
public class SpringMvcTest
{
	
	private static final String SUCCESS = "success";
	
	/**
	 *  @ModelAttribute 注解标记的方法会在每个目标方法被执行之前调用
	 * @param id
	 * @param map
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value="id", required=false) Integer id,
			Map<String, Object> map)
	{
		if(id != null)
		{
			// 模拟从数据中获取到一个对象
			User user = new User(2, "tom", "123456", "tom@163.com", 34);
			System.out.println("模拟从数据中获取到一个对象: " + user);
			
			map.put("user", user);
		}
	}
	
	/**
	 * 运行流程: 
	 * 	1. 执行@ModelAttribute 注解修饰的方法: 从数据库中取对象,  把对象放入map中.  键为:user;
	 *  2. SpringMVC 从map中取出  User 对象, 并把表单的参数赋值给 User 对象的对应属性;
	 *  3. SpringMVC 把上述对象传入到目标方法的参数.
	 *  
	 * 源代码分析流程:
	 *  1. 调用 @ModelAttribute 修饰的放法, 实际上把 @ModelAttribute 方法中 Map 中的数据放在了 implicitModel 中.
	 *  2. 解析请求处理器的目标参数, 实际上该目标参数来自于 WebDataBinder 对象的 target 属性.
	 *    1) 创建 WebDataBinder 对象
	 *     ① 确定 objectName 属性: 若传入的 attrName 属性值为 "", 则 objectName 为类名第一个字母小写;
	 *     注意: attrName. 若目标方法的 POJO 属性使用了 @ModelAttribute 来修饰, 则 attrName 的值即为
	 *     	 @ModelAttribute 的 value 属性.
	 *     ② 确定 target 属性:
	 *  	> 在 implicitModel 中查找 attrName 对象的属性值. 若存在该属性值, OK; 
	 *  	> *若不存在, 则验证当前 Handler 是否使用了 @SessionAttributes 进行修饰;
	 *  		如果使用了, 则尝试从 session 中获取 attrName 所对应的值. 
	 *  		如果 session 中没有对应的属性值, 则抛出异常;
	 *  	> 若 Handler 没有使用 @SessionAttributes 修饰 或 @SessionAttributes 中没有使用 value 指定的key
	 *  		和 attrName 相匹配, 则通过反射创建了 POJO 对象.
	 *    2) springMvc 把表单的请求参数赋给了 WebDataBinder 的 target 对应的属性.
	 *    3) *springMvc 会把 WebDataBinder 的 attrName 和 target 给到 implicitModel, 进而传到request 域对象中;
	 *    4) 把 WebDataBinder 的 target 作为参数传递给目标方法的入参.
	 *    
	 * @param user
	 * @return
	 */
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(User user)
	{
		
		System.out.println("修改后: " + user);
		return SUCCESS;
	}
	
	
	/**
	 *  @SessionAttributes 
	 * @param map
	 * @return
	 */
	@RequestMapping("/testSessionAttributes")
	public String testSessionAttributes(@ModelAttribute("user") Map<String, Object> map)
	{
		User user1 = new User(5,"Tom", "1234", "tom@163.com", 24);
		map.put("user", user1);
		map.put("school", "xuexiao");
		return SUCCESS;
	}
	
	
	/**
	 *  目标方法可以传入Map 类型(实际上也可以是 Model 或 ModelMap类型)的对象
	 * @param map
	 * @return
	 */
	@RequestMapping("/testMap")
	public String testMap(Map<String, Object> map)
	{
		map.put("names", Arrays.asList("tom", "Jerry", "Mike"));
		return SUCCESS;
	}
	
	/**
	 * Spring mvc会把 ModelAndView 中的数据放入到request 域对象中.
	 * @return
	 */
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView()
	{
		String viewName = SUCCESS;	//视图
		ModelAndView modelAndView = new ModelAndView(viewName);
		
		//添加模型数据到 ModelAndView 中
		modelAndView.addObject("time", new Date());
		
		return modelAndView;
	}
	
	
	
	/**
	 * springmvc 支持 Servlet API类型的参数
	 * HttpSevletRequest、HttpServletResponse、HttpSession
	 * InputStream、Reader、OutputStream、Writer等
	 * 
	 * @throws IOException 
	 */
	@RequestMapping("/testServletAPI")
	public void testServletAPI(HttpServletRequest request,
//	public String testServletAPI(HttpServletRequest request, 
			HttpServletResponse response, Writer out) throws IOException
	{
		System.out.println("testServletAPI " + request + "," + response);
		out.write("spring mvc writer");
//		return "success";
	}
}
