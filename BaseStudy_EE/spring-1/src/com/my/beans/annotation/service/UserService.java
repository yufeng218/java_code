package com.my.beans.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.beans.annotation.repository.UserRepository;

@Service
public class UserService
{
	@Autowired
	private UserRepository userRepository;
	
	public void add()
	{
		System.out.println("UserService add...");
		userRepository.save();
	}
}
