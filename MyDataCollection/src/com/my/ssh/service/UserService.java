package com.my.ssh.service;

import org.springframework.stereotype.Repository;

import com.my.ssh.model.User;

/**
 * 
 * @author pc
 *
 */
public interface UserService extends BaseService<User>
{
	
	/*
	 *  判断email是否被占用
	 */
	public boolean isRegisted(String email);
	
	/*
	 * 验证登录信息
	 */
	public User validateLoginInfo(String email, String md5);
}
