package com.niit.newapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	
	public ModelAndView index()
	{
		return new ModelAndView("index");
	}
@RequestMapping("/signup")
	
	public ModelAndView signup()
	{
		return new ModelAndView("signup");
	}
@RequestMapping("/products")

public ModelAndView products()
{
	return new ModelAndView("products");
}
@RequestMapping("/login")

public ModelAndView login()
{
	return new ModelAndView("login");
}



}
