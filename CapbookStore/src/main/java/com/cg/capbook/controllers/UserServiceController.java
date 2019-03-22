package com.cg.capbook.controllers;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.cg.capbook.exceptions.EmailAlreadyRegisteredException;
import com.cg.capbook.exceptions.IncorrectOldPassword;
import com.cg.capbook.exceptions.InvalidQuestionOrAnswer;
import com.cg.capbook.exceptions.InvalidUsernameOrPasswordException;
import com.cg.capbook.exceptions.UserAccountNotFoundException;
import com.cg.capbook.model.UserAccount;
import com.cg.capbook.services.IUserService;

@Controller
@SessionAttributes("user")
public class UserServiceController {
	@Autowired
	IUserService userService; 
		@RequestMapping("/showSignup")
	public ModelAndView signUp(@RequestParam String emailId,String password,String firstName,String secondName,String dateOfBirth, String gender, String mobileNo,String securityQue) throws EmailAlreadyRegisteredException {
		UserAccount user= userService.acceptUserDetails(emailId, password, firstName, secondName, dateOfBirth, gender, mobileNo, securityQue);
		return new ModelAndView("loginPage","user",user); 
	}
	@RequestMapping("/changePassword") public ModelAndView changePassword(@RequestParam String
			emailId,String password, String securityQue) throws UserAccountNotFoundException, IncorrectOldPassword, InvalidQuestionOrAnswer {
		userService.forgotPassword(emailId, password, securityQue);
		return new ModelAndView("loginPage","success","Password changed Successfully");
	}
	@RequestMapping("/showLogin") public ModelAndView login(@RequestParam String
			emailId,String password) throws InvalidUsernameOrPasswordException, UserAccountNotFoundException {
		UserAccount user=userService.loginUser(emailId, password);
		return new ModelAndView("profilePage","user",user);
	}
	@RequestMapping("/updateProfile") public ModelAndView editProfile( @RequestParam String userName ,@SessionAttribute("user") UserAccount user) throws UserAccountNotFoundException {
		user=userService.updateDetails(user.getEmailId(), userName);
		return new ModelAndView("profilePage","user",user);
	}
}