package com.my.ssh.action;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.my.ssh.model.User;
import com.my.ssh.service.UserService;
import com.my.ssh.util.DataUtil;
import com.my.ssh.util.ValidateUtil;
import com.opensymphony.xwork2.inject.Container;

/**
 * 注册action
 */
@Controller
@Scope("prototype")
public class RegAction extends BaseAction<User>
{
	private static final long serialVersionUID = -9119119426314269435L;
	
	private String confirmPassword;//确认密码
	
	public void setConfirmPassword(String confirmPassword)
	{
		this.confirmPassword = confirmPassword;
	}
	
	@Autowired
	private UserService userService;
	
	/*
	 * 到达注册页面
	 */
	@SkipValidation	//跳过validate()方法
	public String toRegPage()
	{
		return "regPage";
	}
	
	/*
	 *  用户注册
	 */
	public String doReg()
	{
		//密码加密
		model.setPassword(DataUtil.md5(model.getPassword()));
		userService.saveEntity(model);
		return SUCCESS;
	}
	
	/*
	 *  ------- 进行表单的校验 ---------
	 *  	Struts2在执行action方法前，都要先执行validateXXX()和validate()方法
	 *  来进行表单验证;
	 *  	如果在验证时发现错误，则会将错误信息放入filedError中，并跳过action方法，
	 *  直接返回到INPUT指定的视图中。
	 *  	这样，当返回INPUT视图后，视图中再通过<s:action>去请求另一个action时，
	 *  会将之前filedError一起带入到这个action中，这个action（即newsList）同样
	 *  也需要调用validate方法进行验证，当发现了存在filedError后，就会立即返回到这个
	 *  action指定的input视图中。
	 */
	@Override
	public void validate()
	{
		//1、非空
		if(!ValidateUtil.isValid(model.getEmail()))
		{
			addFieldError("email", "email是必填项");
		}
		if(!ValidateUtil.isValid(model.getPassword()))
		{
			addFieldError("password", "password是必填项");
		}
		if(!ValidateUtil.isValid(model.getNickName()))
		{
			addFieldError("nickName", "nickName是必填项");
		}
		if(hasErrors())//如果发生错误，直接返回
		{
			return ;
		}
		//2、密码一致性
		if(!model.getPassword().equals(confirmPassword))
		{
			addFieldError("password", "两次密码不一致");
			return ;
		}
		
		//3、email是否占用
		if(userService.isRegisted(model.getEmail()))
		{
			addFieldError("email", "email已经存在");
		}
		
	}
}
