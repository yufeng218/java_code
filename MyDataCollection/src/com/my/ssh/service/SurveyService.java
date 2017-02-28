package com.my.ssh.service;

import java.util.List;

import com.my.ssh.model.Survey;
import com.my.ssh.model.User;

/**
 *	
 */

public interface SurveyService
{
	/*
	 * 查询调查的集合
	 */
	public List<Survey> findMySurveys(User user);
	
	/*
	 * 新建调查
	 */
	public Survey newSurvey(User user);
}
