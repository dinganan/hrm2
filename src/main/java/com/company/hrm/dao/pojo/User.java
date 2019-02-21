package com.company.hrm.dao.pojo;

import java.io.Serializable;

import org.springframework.stereotype.Repository;
@Repository("user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int userid;
	private String username;
	private String userpassword;
	private int priority;
	public User() {
		super();
	}
	
	public User(String username, String userpassword, int priority) {
		super();
		this.username = username;
		this.userpassword = userpassword;
		this.priority = priority;
	}

	public User(int userid, String username, String userpassword, int priority) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpassword = userpassword;
		this.priority = priority;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", userpassword=" + userpassword + ", priority="
				+ priority + "]";
	}
	
	

}
