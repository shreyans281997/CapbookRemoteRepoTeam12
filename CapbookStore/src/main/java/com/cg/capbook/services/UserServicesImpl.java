package com.cg.capbook.services;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import com.cg.capbook.daoservice.UserDAO;
import com.cg.capbook.exceptions.EmailAlreadyRegisteredException;
import com.cg.capbook.exceptions.IncorrectOldPassword;
import com.cg.capbook.exceptions.InvalidUsernameOrPasswordException;
import com.cg.capbook.exceptions.UserAccountNotFoundException;
import com.cg.capbook.model.UserAccount;

public class UserServicesImpl implements IUserService{
	@Autowired
	private UserDAO userDao;
	@Autowired
	private EncryptionAndDecryption encryptionAndDecryption;
	private static UserAccount userAccount;
	@Override
	public UserAccount acceptUserDetails(String emailId, String password, String firstName, String secondName, Date dateOfBirth, String gender, String mobileNo)
			throws EmailAlreadyRegisteredException {
		UserAccount userAccount=userDao.findById(emailId).orElse(null);
		if(userAccount!=null)
		throw new EmailAlreadyRegisteredException("Email is already in use.");
		userAccount=new UserAccount(emailId, password, gender, firstName, secondName, mobileNo, dateOfBirth);
		String encryptPassword=encryptionAndDecryption.encrypt(password);
		userAccount.setPassword(encryptPassword);
		return userDao.save(userAccount);
	}

	@Override
	public UserAccount getUserDetails(String emailId) throws UserAccountNotFoundException {
		return userDao.findById(emailId).orElseThrow(()->new UserAccountNotFoundException("Sorry this user is not part of our family"));
		}

	@Override
	public UserAccount loginUser(String email, String password) throws UserAccountNotFoundException, InvalidUsernameOrPasswordException {
		 if(password!=encryptionAndDecryption.decrypt(getUserDetails(email).getPassword()))
		throw new InvalidUsernameOrPasswordException("Username or password is incorrect");
		userAccount=getUserDetails(email);
		return userAccount;
	}
	
	@Override
	public String changePassword(String oldPassword, String newPassword) throws IncorrectOldPassword {
		userAccount.
		return null;
	}
}
