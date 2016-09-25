package com.my.spring.struts2.action;

import com.my.spring.struts2.service.PersonService;
import com.opensymphony.xwork2.ActionSupport;

public class PersonAction extends ActionSupport
{
	private PersonService personService;
	
	public void setPersonService(PersonService personService)
	{
		this.personService = personService;
	}
	
	@Override
	public String execute() throws Exception
	{
		System.out.println("execute action ...");
		personService.save();
		return SUCCESS;
	}
}
