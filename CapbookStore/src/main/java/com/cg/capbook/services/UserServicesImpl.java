package com.cg.capbook.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.capbook.daoservice.UserDAO;
import com.cg.capbook.exceptions.EmailAlreadyRegisteredException;
import com.cg.capbook.model.UserAccount;

public class UserServicesImpl implements IUserService{
	@Autowired
	private UserDAO userDao;
	
	@Override
	public UserAccount acceptUserDetails(String emailId, String password, String firstName, String secondName, Date dateOfBirth, String gender, String mobileNo)
			throws EmailAlreadyRegisteredException {
		UserAccount userAccount=new UserAccount(emailId, password, gender, firstName, secondName, mobileNo, dateOfBirth);
		return userDao.save(userAccount);
	}

	@Override
	public UserAccount getUserDetails(String emailId) {
		//userDao.findById(emailId).orElseThrow(arg0)
		return null;
	}

	@Override
	public UserAccount loginUser(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
