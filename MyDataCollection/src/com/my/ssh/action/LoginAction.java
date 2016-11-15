package com.my.ssh.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.my.ssh.model.User;
import com.my.ssh.service.UserService;
import com.my.ssh.util.DataUtil;

/**
 *  登录action
 */
@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction<User> implements SessionAware
{
	private static final long serialVersionUID = -7115552761080649498L;
	
	@Autowired
	private UserService userService;
	
	//接收session的map
	private Map<String, Object> sessionMap;
	
	public String toLoginPage()
	{
		return "loginPage";
	}
	
	public String doLogin()
	{
		return "success";
	}
	
	/**
	 *  校验登录信息
	 */
	public void validateDoLogin()
	{
		//1、验证登录信息;
		User user = userService.validateLoginInfo(model.getEmail(), DataUtil.md5(model.getPassword()));
		if(user == null)
		{
			addActionError("email/password错误!");
		}
		else
		{
			sessionMap.put("user", user);
		}
	}
	
	/*
	 *  注入session的map
	 */
	@Override
	public void setSession(Map<String, Object> sessionMap)
	{
		this.sessionMap = sessionMap;
	}
}
