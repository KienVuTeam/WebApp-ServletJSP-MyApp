package com.kienvu.models;

public class user {
	private String username;
	private String password;
	
	public user() {}
	public user(String u, String p) {
		this.username =u;
		this.password=p;
	}
	
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
}
