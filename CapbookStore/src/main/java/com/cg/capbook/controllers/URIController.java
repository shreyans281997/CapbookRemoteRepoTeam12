package com.cg.capbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.capbook.model.*;

@Controller
public class URIController {
private UserAccount user;
private Friend friend;
private Post post;
private Comments comments;
private Notification notification;
private Photo photo;

@RequestMapping(value= {"/","getLoginPage"})
public String getIndexPage() {
return "loginPage";
}

@RequestMapping("/getSignUp")
public String getSignUp() {
	return "getSignUp";}

//@RequestMapping("/getLogin")
//public String getLogin() {
//	return "loginPage";}
@RequestMapping("/getEmailPage")
public String getEmailPage() {
	return "sendEmail";}
@RequestMapping("/getHomePage")
public String getHomePage() {
	return "homePage";}

@RequestMapping("/getForgotPassword")
public String getChangePassword() {
	return "forgotPassword";}

@RequestMapping("/getEditProfile")
public String getEditProfile() {
	return "editProfilePage";}

@ModelAttribute
public UserAccount getUserAccount() {
	user=new UserAccount();
	return user;}

@ModelAttribute
public Friend getFriend() {
	friend=new Friend();
	return friend;}

@ModelAttribute
public Post getPost() {
	post=new Post();
	return post;}

@ModelAttribute
public Photo getPhoto() {
	photo=new Photo();
	return photo;}

@ModelAttribute
public Comments getCommnets() {
	comments=new Comments();
	return comments;}

@ModelAttribute
public Notification getNotification() {
	notification=new Notification();
	return notification;}
}