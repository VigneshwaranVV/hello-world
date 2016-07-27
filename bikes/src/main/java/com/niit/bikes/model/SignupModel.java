package com.niit.bikes.model;
	

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;

	//import org.hibernate.annotations.Entity;
	//import org.hibernate.annotations.Table;

	@Entity
	@Table(name="UserDetails")
	public class SignupModel {
		
		
		@Column
		private String UserName;
		@Id
		@Column
		private String UID;
		@Column
		private String EmailId;
		@Column
		private String Password;
		@Column
		private String PasswordAgain;
		@Column
		private boolean isAdmin;
		public String getUID() {
			return UID;
		}
		public void setUID(String uID) {
			UID = uID;
		}
		public boolean isAdmin() {
			return isAdmin;
		}
		public void setAdmin(boolean isAdmin) {
			this.isAdmin = isAdmin;
		}
		
		public String getUserName() {
			return UserName;
		}
		public void setUserName(String userName) {
			UserName = userName;
		}
		public String getEmailId() {
			return EmailId;
		}
		public void setEmailId(String emailId) {
			EmailId = emailId;
		}
		public String getPassword() {
			return Password;
		}
		public void setPassword(String password) {
			Password = password;
		}
		public String getPasswordAgain() {
			return PasswordAgain;
		}
		public void setPasswordAgain(String passwordAgain) {
			PasswordAgain = passwordAgain;
		}
		
	}


