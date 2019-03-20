package com.cg.capbook.services;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.cg.capbook.exceptions.EmailAlreadyRegisteredException;

import com.cg.capbook.model.UserAccount;

@Component("userService")
public interface IUserService {
	public UserAccount getUserDetails(String emailId);
	public UserAccount loginUser(String email, String password);
	UserAccount acceptUserDetails(String emailId, String password, String firstName, String secondName,
			Date dateOfBirth, String gender, String mobileNo) throws EmailAlreadyRegisteredException;

}
