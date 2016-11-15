package com.my.ssh.model;

import java.util.Date;

/**
 * 用户类
 * 
 * @author pc
 * 
 */
public class User
{
	private Integer id;
	private String name;
	private String password;
	private String email;
	private String nickName; // 昵称
	// 注册时间 (不可修改)
	private Date regDate = new Date(); 

	public Date getRegDate()
	{
		return regDate;
	}

	public void setRegDate(Date regDate)
	{
		this.regDate = regDate;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getNickName()
	{
		return nickName;
	}

	public void setNickName(String nickName)
	{
		this.nickName = nickName;
	}

}
