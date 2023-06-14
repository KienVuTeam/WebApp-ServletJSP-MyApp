package com.kienvu.models;

public class AccountAdmin {
	private int id;
	private String username;
	private String password;
	private boolean status;
	
	//
	public AccountAdmin() {
		
	}
	
	public AccountAdmin(String username, String password, boolean status) {
		this.username = username;
		this.password = password;
		this.status = status;
	}
	public AccountAdmin(int id, String username, String password, boolean status) {
		this.id =id;
		this.username=username;
		this.password =password;
		this.status = status;
	}
	
	public void setId(int id) {
		this.id =id;
	}
	public void setUsername(String username) {
		this.username =username;
	}
	public void setPassword(String password) {
		this.password =password;
	}
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean getStatus() {
		return status;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
	
	
}
