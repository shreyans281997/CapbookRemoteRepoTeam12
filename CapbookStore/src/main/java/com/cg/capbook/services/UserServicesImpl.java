package com.cg.capbook.services;

<<<<<<< HEAD
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;

=======
>>>>>>> refs/remotes/origin/master
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
<<<<<<< HEAD
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.cg.capbook.daoservice.PhotoDAO;
=======

import com.cg.capbook.daoservice.FriendDAO;
import com.cg.capbook.daoservice.FriendRequestDAO;
>>>>>>> refs/remotes/origin/master
import com.cg.capbook.daoservice.UserDAO;
import com.cg.capbook.exceptions.EmailAlreadyRegisteredException;
import com.cg.capbook.exceptions.IncorrectOldPassword;
import com.cg.capbook.exceptions.InvalidQuestionOrAnswer;
import com.cg.capbook.exceptions.InvalidUsernameOrPasswordException;
import com.cg.capbook.exceptions.UserAccountNotFoundException;
import com.cg.capbook.model.Friend;
import com.cg.capbook.model.FriendRequest;
import com.cg.capbook.model.UserAccount;
@Component("userService")
public class UserServicesImpl implements IUserService{
	private static String UPLOADED_FOLDER = "D:/";
	@Autowired
	private UserDAO userDao;
	@Autowired
	private PhotoDAO photoDao;
	@Autowired
	private EncryptionAndDecryption encryptionAndDecryption;
	@Override
	public UserAccount acceptUserDetails(String emailId, String password, String firstName, String secondName, String dateOfBirth, String gender, String mobileNo,String securityQue,String answer)
			throws EmailAlreadyRegisteredException {
		UserAccount userAccount=userDao.findById(emailId).orElse(null);
		if(userAccount!=null)
			throw new EmailAlreadyRegisteredException("Email is already in use.");
		userAccount=new UserAccount(emailId, password, gender, firstName, secondName, mobileNo, dateOfBirth,securityQue,answer);
		String encryptPassword=EncryptionAndDecryption.encrypt(password);
		userAccount.setPassword(encryptPassword);
		return userDao.save(userAccount);
	}
	@Override
	public UserAccount getUserDetails(String emailId) throws UserAccountNotFoundException {
		return userDao.findById(emailId).orElseThrow(()->new UserAccountNotFoundException("Sorry this user is not part of our family"));
	}
	@Override
	public UserAccount loginUser(String emailId, String password) throws InvalidUsernameOrPasswordException, UserAccountNotFoundException {
		UserAccount userAccount=getUserDetails(emailId);
		String depcryptPassword=EncryptionAndDecryption.decrypt(userAccount.getPassword());
		System.out.println(depcryptPassword);
		if(password.equals(depcryptPassword))
			return userAccount;
		else
			throw new InvalidUsernameOrPasswordException();
	}
	public boolean forgotPassword(String emailId, String password, String securityQue,String answer) throws UserAccountNotFoundException, InvalidQuestionOrAnswer{
		UserAccount userAccount=getUserDetails(emailId);
		if(securityQue.equals(userAccount.getSecurityQue()))
		{userAccount.setPassword(password);
		userDao.save(userAccount);
<<<<<<< HEAD
		return true;
=======
		return true;}
		else throw new InvalidQuestionOrAnswer();
>>>>>>> refs/remotes/origin/master
	}
	@Override
	public String addProfilePic(String emailId,MultipartFile file) throws UserAccountNotFoundException  {
		UserAccount user=userDao.findById(emailId).orElseThrow(()->new UserAccountNotFoundException("User Account Not Found"));
		if(file.isEmpty()) {
			return "Please enter file again";
		}
		try {
			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			user.setProfilePic(UPLOADED_FOLDER + file.getOriginalFilename());
			userDao.save(user);
			Files.write(path, bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "redirect:/uploadStatus";
	}
<<<<<<< HEAD

	public UserAccount updateDetails(String emailId,String userName) throws UserAccountNotFoundException, IOException, SQLException {
		UserAccount user=userDao.findById(emailId).orElseThrow(()->new UserAccountNotFoundException("User Account Not Found"));
=======
	public UserAccount updateDetails(String emailId,String userName) throws UserAccountNotFoundException {
		UserAccount user=getUserDetails(emailId);
>>>>>>> refs/remotes/origin/master
		user.setUserName(userName);
		return user;
	}
	@Override
	public boolean changePassword(String emailId, String oldPassword, String newPassword) throws UserAccountNotFoundException, IncorrectOldPassword {
		UserAccount user=getUserDetails(emailId);
		if(oldPassword.equals(user.getPassword()))
		{user.setPassword(newPassword);
		return true;}
		else throw new IncorrectOldPassword();
	}	
}