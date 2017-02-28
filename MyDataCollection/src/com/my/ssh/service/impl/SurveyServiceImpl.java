package com.my.ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.my.ssh.dao.BaseDao;
import com.my.ssh.model.Page;
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
	@Qualifier("surveyDao")
	private BaseDao<Survey> surveyDao;
	
	@Autowired
	@Qualifier("pageDao")
	private BaseDao<Page> pageDao;
	
	/*
	 * 	查询调查的集合
	 */
	@Override
	public List<Survey> findMySurveys(User user)
	{
		String hql = "from Survey s where s.user.id = ?";
		return surveyDao.findEntityByHQL(hql, user.getId());
	}
	
	/*
	 * 新建调查
	 */
	@Override
	public Survey newSurvey(User user)
	{
		Survey s = new Survey();
		Page p = new Page();
		
		//设置关联
		s.setUser(user);
		//双向关联的
		p.setSurvey(s);	
		s.getPages().add(p);
		
		//先保存调查,再存页面
		surveyDao.saveEntity(s);
		pageDao.saveEntity(p);
		
		return s;
	}
}
