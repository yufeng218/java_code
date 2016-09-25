package com.my.beans.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.my.beans.annotation.service.UserService;

@Controller
public class UserController
{
	@Autowired(required=false)
	private UserService userService;
	
	public void execute()
	{
		userService.add();
		System.out.println("UserController execute...");
	}
}
