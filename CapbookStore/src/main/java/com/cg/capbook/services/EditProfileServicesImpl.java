package com.cg.capbook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.capbook.daoservice.UserDAO;
import com.cg.capbook.exceptions.UserAccountNotFoundException;
import com.cg.capbook.model.Address;
import com.cg.capbook.model.UserAccount;

@Component("editProfile")
public class EditProfileServicesImpl implements IEditProfileServices {
	@Autowired
	private UserDAO userDao;
	@Autowired
	private IUserService user;
	@Override
	public UserAccount editBio(String emailId,String bio) throws UserAccountNotFoundException {
		UserAccount userAccount = user.getUserDetails(emailId);
		userAccount.setBio(bio);
		userDao.save(userAccount);
		return userAccount;
	}
	@Override
	public UserAccount editWorkPlaceAndWorkExperience(String emailId, String workPlace, String workExperience) throws UserAccountNotFoundException {
		UserAccount userAccount = user.getUserDetails(emailId);
		userAccount.setWorkPlace(workPlace);
		userAccount.setWorkExperience(workExperience);
		userDao.save(userAccount);
		return userAccount;
	}
	@Override
	public UserAccount editAddress(String emailId, String city, String state, String country, String zipCode) throws UserAccountNotFoundException {
		UserAccount userAccount = user.getUserDetails(emailId);
		Address address = new Address(city, state, country, zipCode);
		userAccount.setAddress(address);
		userDao.save(userAccount);
		return userAccount;
	}

}
