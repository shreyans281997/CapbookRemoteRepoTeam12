package com.cg.capbook.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.capbook.exceptions.EmailAlreadyRegisteredException;
import com.cg.capbook.exceptions.InvalidUsernameOrPasswordException;
import com.cg.capbook.exceptions.invalidOTPException;
import com.cg.capbook.model.UserAccount;
import com.cg.capbook.services.IUserService;

@Controller
public class UserServiceController {
@Autowired
IUserService userService; 

@RequestMapping("/showSignup")
public ModelAndView signUp(@RequestParam String emailId,String password,String firstName,String secondName,String dateOfBirth, String gender, String mobileNo) throws EmailAlreadyRegisteredException {
	UserAccount user= userService.acceptUserDetails(emailId, password, firstName, secondName, dateOfBirth, gender, mobileNo);
	return new ModelAndView("loginPage","user",user); 
}
	/*
	 * @RequestMapping("/successfulRegister") public ModelAndView
	 * successfulRegister(@RequestParam int otp) throws invalidOTPException { String
	 * message=iUserService.verifyOtp(otp); return new
	 * ModelAndView("otpPage","message",message); }
	 */

	/*
	 * @RequestMapping("/showLogin") public ModelAndView login(@RequestParam String
	 * emailId,String password) throws InvalidUsernameOrPasswordException{
	 * 
	 * }
	 */
}
