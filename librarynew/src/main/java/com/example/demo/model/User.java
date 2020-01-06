package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class User {
	
	private int userId;
	private String userName;
	
	User(){
		System.out.println("in user constructor");
	}
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + "]";
	}
	
	

}
