package com.simple.jwt.dto;


public class AuthDTO
{
    private String userName;
    private String passWord;
    
    public AuthDTO() {
    	userName = "";
    	passWord = "";
	}
    public AuthDTO(String userName,String password){
    	this.userName = userName;
    	this.passWord = password;
    }
    
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
    
}
