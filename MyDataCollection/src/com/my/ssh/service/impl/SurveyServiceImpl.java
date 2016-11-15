package com.my.ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.my.ssh.dao.BaseDao;
import com.my.ssh.model.Survey;
import com.my.ssh.model.User;
import com.my.ssh.service.SurveyService;

/**
 *	SurveyService的实现 
 */
@Service("surveyService")
public class SurveyServiceImpl implements SurveyService
{
	@Autowired
	//@Qualifier("surveyDao")
	private BaseDao<Survey> surveyDao;
	
	@Override
	public List<Survey> findMySurveys(User user)
	{
		String hql = "from Survey s where s.user.id = ?";
		return surveyDao.findEntityByHQL(hql, user.getId());
	}
}
