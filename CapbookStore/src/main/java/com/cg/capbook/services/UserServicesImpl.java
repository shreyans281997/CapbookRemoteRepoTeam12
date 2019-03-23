package com.cg.capbook.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.cg.capbook.daoservice.UserDAO;
import com.cg.capbook.exceptions.EmailAlreadyRegisteredException;
import com.cg.capbook.exceptions.FieldsEmptyException;
import com.cg.capbook.exceptions.IncorrectOldPassword;
import com.cg.capbook.exceptions.InvalidQuestionOrAnswer;
import com.cg.capbook.exceptions.InvalidUsernameOrPasswordException;
import com.cg.capbook.exceptions.UserAccountNotFoundException;
import com.cg.capbook.model.UserAccount;
@Component("userService")
public class UserServicesImpl implements IUserService{
	private static String UPLOADED_FOLDER = "D:/";
	@Autowired
	private UserDAO userDao;
	@Autowired
	private EncryptionAndDecryption encryptionAndDecryption;
	
	@Override
	public UserAccount acceptUserDetails(String emailId, String password, String firstName, String secondName, String dateOfBirth, String gender, String mobileNo,String securityQue,String answer)
			throws EmailAlreadyRegisteredException, FieldsEmptyException {
		if(emailId==null || password==null || firstName==null || secondName==null || dateOfBirth==null || gender==null || mobileNo==null || securityQue==null || answer==null)
			throw new FieldsEmptyException("Don't Keep the Required Fields Empty");
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
		if(securityQue.equals(userAccount.getSecurityQue())&& answer.equals(userAccount.getAnswer()))
		{userAccount.setPassword(EncryptionAndDecryption.encrypt(password));
		userDao.save(userAccount);
		return true;}
		else throw new InvalidQuestionOrAnswer("Question Or Answer is wrong.");
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
	public UserAccount updateDetails(String emailId,String userName) throws UserAccountNotFoundException {
		UserAccount user=getUserDetails(emailId);
		user.setUserName(userName);
		return userDao.save(user);
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