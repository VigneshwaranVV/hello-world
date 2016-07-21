package com.niit.bikes.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.niit.bikes.dao.UserDAO;
import com.niit.bikes.model.SignupModel;

public class UserServiceimpl implements UserService{

	//@Autowired
	UserDAO userDAO;
	public void insertSignupModel(SignupModel u)
	{
		userDAO.insertSignupModel(u);
	}

}
