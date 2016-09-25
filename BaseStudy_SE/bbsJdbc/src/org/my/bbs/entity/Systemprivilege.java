package org.my.bbs.entity;

import java.io.Serializable;

public class Systemprivilege implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String action;
	private String resource;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	
	
}
