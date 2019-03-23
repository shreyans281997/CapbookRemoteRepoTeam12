package com.cg.capbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.cg.capbook.exceptions.EmailAlreadyRegisteredException;
import com.cg.capbook.exceptions.FieldsEmptyException;
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
public ModelAndView signUp(@RequestParam String emailId,String password,String firstName,String secondName,String dateOfBirth, String gender, String mobileNo,String securityQue,String answer) throws EmailAlreadyRegisteredException, FieldsEmptyException {
		userService.acceptUserDetails(emailId, password, firstName, secondName, dateOfBirth, gender, mobileNo, securityQue,answer);
return new ModelAndView("loginPage","register","You have registered successfully"); 
	}
	@RequestMapping("/forgotPassword") public ModelAndView changePassword(@RequestParam String
			emailId,String password, String securityQue,String answer) throws UserAccountNotFoundException, IncorrectOldPassword, InvalidQuestionOrAnswer {
		userService.forgotPassword(emailId, password, securityQue,answer);
		return new ModelAndView("forgotPassword","success","Password changed Successfully");
	}
	@RequestMapping("/showLogin") public ModelAndView login(@RequestParam String
			emailId,String password) throws InvalidUsernameOrPasswordException, UserAccountNotFoundException {
		UserAccount user=userService.loginUser(emailId, password);
		return new ModelAndView("homePage","user",user);
	}
	@RequestMapping("/updateProfile") public ModelAndView editProfile( @RequestParam String userName ,@SessionAttribute("user") UserAccount user) throws UserAccountNotFoundException {
		user=userService.updateDetails(user.getEmailId(), userName);
		return new ModelAndView("profilePage","user",user);
	}
	@RequestMapping("/changePassword")
	public ModelAndView changePassword(@RequestParam String oldPassword, String newPassword,@SessionAttribute("user") UserAccount user) throws UserAccountNotFoundException, IncorrectOldPassword {
		boolean check=userService.changePassword(user.getEmailId(),oldPassword, newPassword);
		return new ModelAndView("editProfilePage","success","Password changed Successfully");
	}
	@RequestMapping("/updatePic") public ModelAndView updatePic( @RequestParam MultipartFile file ,@SessionAttribute("user") UserAccount user) throws UserAccountNotFoundException {
		userService.addProfilePic(user.getEmailId(), file);
		return new ModelAndView("profilePage","success","File successfully uploaded");
	}
}