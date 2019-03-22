package com.cg.capbook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.cg.capbook.daoservice.UserDAO;
import com.cg.capbook.exceptions.EmailAlreadyRegisteredException;
import com.cg.capbook.exceptions.InvalidQuestionOrAnswer;
import com.cg.capbook.exceptions.InvalidUsernameOrPasswordException;
import com.cg.capbook.exceptions.UserAccountNotFoundException;
import com.cg.capbook.model.UserAccount;
@Component("userService")
public class UserServicesImpl implements IUserService{
	@Autowired
	private UserDAO userDao;
	@Autowired
	private EncryptionAndDecryption encryptionAndDecryption;
	@Override
	public UserAccount acceptUserDetails(String emailId, String password, String firstName, String secondName, String dateOfBirth, String gender, String mobileNo,String securityQue)
			throws EmailAlreadyRegisteredException {
		UserAccount userAccount=userDao.findById(emailId).orElse(null);
		if(userAccount!=null)
			throw new EmailAlreadyRegisteredException("Email is already in use.");
		userAccount=new UserAccount(emailId, password, gender, firstName, secondName, mobileNo, dateOfBirth,securityQue);
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
		UserAccount userAccount=userDao.findById(emailId).orElseThrow(()->new UserAccountNotFoundException("User account not found"));
		String depcryptPassword=EncryptionAndDecryption.decrypt(userAccount.getPassword());
		System.out.println(depcryptPassword);
		if(password.equals(depcryptPassword))
			return userAccount;
		else
			throw new InvalidUsernameOrPasswordException();
	}
	public boolean forgotPassword(String emaildId, String password, String securityQue) throws UserAccountNotFoundException, InvalidQuestionOrAnswer{
		UserAccount userAccount=userDao.findById(emaildId).orElseThrow(()->new UserAccountNotFoundException("Invalid email Id"));
		if(securityQue.equals(userAccount.getSecurityQue()))
		{userAccount.setPassword(password);
		userDao.save(userAccount);
		return true;}
		else throw new InvalidQuestionOrAnswer();
	}
	@Override
	public String addProfilePic(MultipartFile photo)  {

		return null;
	}
	public UserAccount updateDetails(String emailId,String userName) throws UserAccountNotFoundException {
		UserAccount user=userDao.findById(emailId).orElseThrow(()->new UserAccountNotFoundException("User Account Not Found"));
		user.setUserName(userName);
		return userDao.save(user);
	}
	@Override
	public boolean changePassword(String emailId, String oldPassword, String newPassword) throws UserAccountNotFoundException {
		UserAccount user=userDao.findById(emailId).orElseThrow(()->new UserAccountNotFoundException("User Account Not Found"));
		
		return false;
	}
}