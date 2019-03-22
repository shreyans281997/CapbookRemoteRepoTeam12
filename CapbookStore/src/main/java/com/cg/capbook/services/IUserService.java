
package com.cg.capbook.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.multipart.MultipartFile;

import com.cg.capbook.exceptions.EmailAlreadyRegisteredException;
import com.cg.capbook.exceptions.IncorrectOldPassword;
import com.cg.capbook.exceptions.InvalidQuestionOrAnswer;
import com.cg.capbook.exceptions.InvalidUsernameOrPasswordException;
import com.cg.capbook.exceptions.UserAccountNotFoundException;
import com.cg.capbook.model.UserAccount;

public interface IUserService {
	public UserAccount getUserDetails(String emailId) throws UserAccountNotFoundException;
	public UserAccount loginUser(String emailId, String password) throws InvalidUsernameOrPasswordException, UserAccountNotFoundException;
    public boolean forgotPassword(String emaildId, String password,String securityQue,String answer) throws UserAccountNotFoundException, InvalidQuestionOrAnswer;
	UserAccount acceptUserDetails(String emailId, String password, String firstName, String secondName,
<<<<<<< HEAD
			String dateOfBirth, String gender, String mobileNo) throws EmailAlreadyRegisteredException;
	public UserAccount updateDetails(String emailId,String userName) throws UserAccountNotFoundException, FileNotFoundException, IOException, SQLException;
	String addProfilePic(String emailId, MultipartFile file) throws UserAccountNotFoundException;
=======
			String dateOfBirth, String gender, String mobileNo,String securityQue,String answer) throws EmailAlreadyRegisteredException;
	String addProfilePic(MultipartFile photo);
	public UserAccount updateDetails(String emailId,String userName) throws UserAccountNotFoundException;
	public boolean changePassword(String emailId,String oldPassword,String newPassword) throws UserAccountNotFoundException, IncorrectOldPassword;
>>>>>>> refs/remotes/origin/master
}