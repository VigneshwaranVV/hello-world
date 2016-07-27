package com.niit.bikes.dao;

import com.niit.bikes.model.SignupModel;
import com.niit.bikes.model.UserDetails;

public interface UserDAO {

	public void insertSignupModel(SignupModel sm);

	public boolean isValidUser(String un, String pd);
	public boolean isAdminUser(String un, String pd);

	public void insertUserDetails(UserDetails u);
	

	


}
