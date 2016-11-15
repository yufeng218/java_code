package com.my.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.my.ssh.dao.BaseDao;
import com.my.ssh.model.User;
import com.my.ssh.service.UserService;
import com.my.ssh.util.ValidateUtil;

/**
 * 	用户service
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> 
	implements UserService
{
	
	/*
	 * 重写该方法的目的使为了覆盖超类中该方法的注解，指明注入指定的Dao对象，否则Spring无法
	 * 确定注入哪个dao ----- 有四个满足条件的dao;
	 */
	@Override
	@Autowired
	@Qualifier("userDao")
	public void setDao(BaseDao<User> dao)
	{
		super.setDao(dao);
	}
	
	/*
	 * 判断email是否被占用
	 */
	@Override
	public boolean isRegisted(String email)
	{
		String hql = "from User u where u.email = ?";
		List<User> list = this.findEntityByHQL(hql, email);
		return ValidateUtil.isValid(list);
	}
	
	/*
	 * 验证登录信息
	 */
	@Override
	public User validateLoginInfo(String email, String md5)
	{
		String hql = "from User u where u.email = ? and u.password = ?";
		List<User> list = this.findEntityByHQL(hql, email, md5);
		return ValidateUtil.isValid(list) ? list.get(0) : null;
	}

}
