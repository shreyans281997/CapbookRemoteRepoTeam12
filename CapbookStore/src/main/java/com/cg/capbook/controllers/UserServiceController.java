package com.cg.capbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.capbook.exceptions.EmailAlreadyRegisteredException;
import com.cg.capbook.exceptions.InvalidUsernameOrPasswordException;

@Controller
public class UserServiceController {



@RequestMapping("/showSignup")
public ModelAndView signUp(@RequestParam String emailId,String password) throws EmailAlreadyRegisteredException {
	return null;
	     
}

@RequestMapping("/showLogin")
public ModelAndView login(@RequestParam String emailId,String password) throws InvalidUsernameOrPasswordException{
	return null;
	
}
}
