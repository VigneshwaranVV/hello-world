package com.niit.bikes.model;

//import org.hibernate.annotations.Entity;
//import org.hibernate.annotations.Table;

public class SignupModel { 

	private String FullName;

	private String EmailId;

	private String UserName;

	private String Password;

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	
}
