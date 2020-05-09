package com.simple.jwt.model;


public class JwtUser
{
    private String userName;
    private String role;
    
	public JwtUser(String userName2, String passWord) {
		//this.userName = userName2;
		System.out.println("--> "+userName2+"---> "+passWord);
		//this.role = passWord;
	}


	public JwtUser() {
		userName = "";
		role = "";
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
    
    
}
