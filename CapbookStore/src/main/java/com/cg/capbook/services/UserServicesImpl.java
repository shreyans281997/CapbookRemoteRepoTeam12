package com.cg.capbook.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.cg.capbook.daoservice.UserDAO;
import com.cg.capbook.exceptions.EmailAlreadyRegisteredException;
import com.cg.capbook.exceptions.InvalidUsernameOrPasswordException;
import com.cg.capbook.exceptions.UserAccountNotFoundException;
import com.cg.capbook.exceptions.invalidOTPException;
import com.cg.capbook.model.UserAccount;
@Component("userService")
public class UserServicesImpl implements IUserService{
	@Autowired
	private UserDAO userDao;
	@Autowired
	private EncryptionAndDecryption encryptionAndDecryption;
	@Override
	public UserAccount acceptUserDetails(String emailId, String password, String firstName, String secondName, String dateOfBirth, String gender, String mobileNo)
			throws EmailAlreadyRegisteredException {
		UserAccount userAccount=userDao.findById(emailId).orElse(null);
		if(userAccount!=null)
		throw new EmailAlreadyRegisteredException("Email is already in use.");
		userAccount=new UserAccount(emailId, password, gender, firstName, secondName, mobileNo, dateOfBirth);
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
		//String depcryptPassword=EncryptionAndDecryption.decrypt(userAccount.getPassword());
		//System.out.println(depcryptPassword);
		if(password.equals(userAccount.getPassword()))
			return userAccount;
		else
			throw new InvalidUsernameOrPasswordException();
	}
   public boolean changePassword(String emaildId, String password) throws UserAccountNotFoundException{
UserAccount userAccount=userDao.findById(emaildId).orElseThrow(()->new UserAccountNotFoundException("Invalid email Id"));
userAccount.setPassword(password);
userDao.save(userAccount);
return true;
	   
   }
	public UserAccount updateDetails(String emailId,String userName) throws UserAccountNotFoundException {
		UserAccount user=userDao.findById(emailId).orElseThrow(()->new UserAccountNotFoundException("User Account Not Found"));
	    user.setUserName(userName);
	    return userDao.save(user);

		
	}

	@Override
	public String verifyOtp(int otp) throws invalidOTPException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addProfilePic(MultipartFile photo) {
		// TODO Auto-generated method stub
		return null;
	}
}