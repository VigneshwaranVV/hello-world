package com.niit.bikes.model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

//import org.hibernate.annotations.Entity;
//import org.hibernate.annotations.Table;
@Entity
@Table(name = "UserDetails")
@Component
public class UserDetails {
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	@Id
	private String UserName;
	private String Password;
	private String UID;
	private boolean isAdmin;
	
	
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
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
