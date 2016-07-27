package com.niit.bikes.services;

import com.niit.bikes.model.SignupModel;
import com.niit.bikes.model.UserDetails;

public interface UserService {

	public void insertSignupModel(SignupModel sm);

	public void insertUserDetails(UserDetails u);


}
