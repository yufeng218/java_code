package org.my.bbs.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.Attributes.Name;

public class Category implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String order;
	private Set<Forum> forums = new HashSet<Forum>(); //存放子版块
	
	public Set<Forum> getForums() {
		return forums;
	}
	public void setForums(Set<Forum> forums) {
		this.forums = forums;
	}
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
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
	
}
