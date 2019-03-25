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
import com.cg.capbook.exceptions.UserNotAFriendException;
import com.cg.capbook.model.Post;
import com.cg.capbook.model.UserAccount;
import com.cg.capbook.services.IEditProfileServices;
import com.cg.capbook.services.IEmailService;
import com.cg.capbook.services.IPostService;
import com.cg.capbook.services.IUserService;

@Controller
@SessionAttributes("user")
public class UserServiceController {

	@Autowired
	IUserService userService; 
	@Autowired
	IEmailService emailService;
	@Autowired
	IEditProfileServices editProfile;
	@Autowired
	IPostService postService;
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
	@RequestMapping("/updatePassword")
	public ModelAndView changePassword(@RequestParam String oldPassword, String newPassword,@SessionAttribute("user") UserAccount user) throws UserAccountNotFoundException, IncorrectOldPassword {
		userService.changePassword(user.getEmailId(),oldPassword, newPassword);
		return new ModelAndView("editProfilePage","success","Password changed Successfully");
	}
	
	
	@RequestMapping("/updateAddress")
	public ModelAndView updateAddress(@RequestParam String city,String state,String country,String zipCode,@SessionAttribute("user") UserAccount user) throws UserAccountNotFoundException, IncorrectOldPassword {
		editProfile.editAddress(user.getEmailId(), city, state, country, zipCode);
		return new ModelAndView("editProfilePage","success","Address Updated Successfully");
	}
	@RequestMapping("/updateBio")
	public ModelAndView updateBio(@RequestParam String bio,@SessionAttribute("user") UserAccount user) throws UserAccountNotFoundException, IncorrectOldPassword {
		editProfile.editBio(user.getEmailId(), bio);
		return new ModelAndView("editProfilePage","success","Bio Updated Successfully");
	}
	@RequestMapping("/updateProfessionalInfo")
	public ModelAndView updateProfessionalInfo(@RequestParam String workPlace,String workExperience,String businessProfile,String mobileNo,@SessionAttribute("user") UserAccount user) throws UserAccountNotFoundException, IncorrectOldPassword {
		editProfile.editWorkPlaceAndWorkExperience(user.getEmailId(), workPlace, workExperience, businessProfile, mobileNo);
		return new ModelAndView("editProfilePage","success","Professional Information Updated Successfully");
	}
	@RequestMapping("/updatePic") public ModelAndView updatePic( @RequestParam MultipartFile file ,@SessionAttribute("user") UserAccount user) throws UserAccountNotFoundException {
		userService.addProfilePic(user.getEmailId(), file);
		return new ModelAndView("profilePage","success","File successfully uploaded");
	}
	@RequestMapping("/sendEmail")
	public ModelAndView sendEmail(@RequestParam @SessionAttribute("user") UserAccount user, String toAddress, String subject, String messageBody) throws UserAccountNotFoundException, UserNotAFriendException {
		emailService.saveEmail(user.getEmailId(), toAddress, subject, messageBody);
		return new ModelAndView("sendEmail", "success", "Email Sent Successfully");
	}
	@RequestMapping("/updatePost")
	public ModelAndView updatePost(@RequestParam @SessionAttribute("user") UserAccount user, String postContent) throws UserAccountNotFoundException, UserNotAFriendException {
		Post newPost=postService.createPostText(user.getEmailId(), postContent);
		return new ModelAndView("homePage", "newPost", newPost);
	}
}