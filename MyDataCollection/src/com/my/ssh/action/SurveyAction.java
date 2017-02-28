package com.my.ssh.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.my.ssh.model.Survey;
import com.my.ssh.model.User;
import com.my.ssh.service.SurveyService;

/**
 *	调查的action
 */
@Controller
@Scope("prototype")
public class SurveyAction extends BaseAction<Survey> implements SessionAware
{
	private static final long serialVersionUID = 8416103610298985754L;
	
	@Autowired	//注入surveyService
	private SurveyService surveyService;
	
	//调查的集合
	private List<Survey> mySurveys = new ArrayList<Survey>();
	
	public void setMySurveys(List<Survey> mySurveys)
	{
		this.mySurveys = mySurveys;
	}
	public List<Survey> getMySurveys()
	{
		return mySurveys;
	}
	
	private Map<String, Object> sessionMap;
	
	/**
	 * 	查询我的调查列表
	 */
	public String mySurveys()
	{
		User user = (User) sessionMap.get("user");	//从session中获取用户信息
		this.mySurveys = surveyService.findMySurveys(user);
		return "mySurveyListPage";
	}

	@Override
	public void setSession(Map<String, Object> sessionMap)
	{
		this.sessionMap = sessionMap;
	}
	
	/**
	 *  新建调查
	 */
	public String newSurvey()
	{
		//1、从session中获取user;
		User user = (User) sessionMap.get("user");
		this.model = surveyService.newSurvey(user);// model回显
		return "designSurveyPage";
	}
	
}
