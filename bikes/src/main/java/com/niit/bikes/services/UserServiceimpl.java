package com.niit.bikes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.bikes.dao.UserDAO;
import com.niit.bikes.model.SignupModel;
import com.niit.bikes.model.UserDetails;
@Service
public class UserServiceimpl implements UserService{

	@Autowired
	UserDAO userDAO;
	public void insertSignupModel(SignupModel sm)
	{
		userDAO.insertSignupModel(sm);
	}
	public void insertUserDetails(UserDetails u) {
		// TODO Auto-generated method stub
		userDAO.insertUserDetails(u);
	}

}
