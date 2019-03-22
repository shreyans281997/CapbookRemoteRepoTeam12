
package com.cg.capbook.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.multipart.MultipartFile;

import com.cg.capbook.exceptions.EmailAlreadyRegisteredException;
import com.cg.capbook.exceptions.InvalidUsernameOrPasswordException;
import com.cg.capbook.exceptions.UserAccountNotFoundException;
import com.cg.capbook.model.UserAccount;

public interface IUserService {
	public UserAccount getUserDetails(String emailId) throws UserAccountNotFoundException;
	public UserAccount loginUser(String emailId, String password) throws InvalidUsernameOrPasswordException, UserAccountNotFoundException;
    public boolean changePassword(String emaildId, String password) throws UserAccountNotFoundException;
	UserAccount acceptUserDetails(String emailId, String password, String firstName, String secondName,
			String dateOfBirth, String gender, String mobileNo) throws EmailAlreadyRegisteredException;
	public UserAccount updateDetails(String emailId,String userName) throws UserAccountNotFoundException, FileNotFoundException, IOException, SQLException;
	String addProfilePic(String emailId, MultipartFile file) throws UserAccountNotFoundException;
}