package org.my.bbs.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Role implements Serializable{
	//序列化的标识
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String description;//
	private boolean defaultForNewUser;//新用户是否有默认的权限
	//该角色被哪些用户拥有
	private Set<User> users = new HashSet<User>();
	//该角色拥有哪些权限
	private Set<Systemprivilege> systemprivileges = new HashSet<Systemprivilege>();
	
	
	public Set<Systemprivilege> getSystemprivileges() {
		return systemprivileges;
	}
	public void setSystemprivileges(Set<Systemprivilege> systemprivileges) {
		this.systemprivileges = systemprivileges;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isDefaultForNewUser() {
		return defaultForNewUser;
	}
	public void setDefaultForNewUser(boolean defaultForNewUser) {
		this.defaultForNewUser = defaultForNewUser;
	}
	
}
