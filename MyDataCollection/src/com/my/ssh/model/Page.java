package com.my.ssh.model;

import java.util.HashSet;
import java.util.Set;

/**
 * 页面类
 * 
 * @author pc
 * 
 */
public class Page
{
	private Integer id;
	private String title = "未命名";
	private String description;

	// 建立从page到survey之间的多对一关联
	private Survey survey;

	// 建立从page到question之间的一对多关联关系
	private Set<Question> questions = new HashSet<Question>();

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Survey getSurvey()
	{
		return survey;
	}

	public void setSurvey(Survey survey)
	{
		this.survey = survey;
	}

	public Set<Question> getQuestions()
	{
		return questions;
	}

	public void setQuestions(Set<Question> questions)
	{
		this.questions = questions;
	}

}
