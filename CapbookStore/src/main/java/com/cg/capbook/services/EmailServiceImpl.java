package com.cg.capbook.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.capbook.daoservice.EmailDAO;
import com.cg.capbook.daoservice.FriendDAO;
import com.cg.capbook.daoservice.UserDAO;
import com.cg.capbook.exceptions.UserAccountNotFoundException;
import com.cg.capbook.exceptions.UserNotAFriendException;
import com.cg.capbook.model.Email;
import com.cg.capbook.model.UserAccount;
@Component("emailService")
public class EmailServiceImpl implements IEmailService {

	@Autowired
	private EmailDAO emailDao;
	@Autowired 
	private FriendDAO friendDao;
	@Autowired
	private UserDAO userDao;
	@Autowired
	private IUserService user;
	
	@Override
	public Email saveEmail(String fromAddress, String toAddress, String subject, String messageBody) throws UserAccountNotFoundException,UserNotAFriendException{
		userDao.findById(toAddress).orElseThrow(()->new UserAccountNotFoundException("User is not Registered!"));
		//friendDao.findById(toAddress).orElseThrow(()->new UserNotAFriendException("Can't Send Mail! User is Not a Friend!")); 
	        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
	        String dateOfMail = LocalDateTime.now().format(format);  
		Email email=new Email(fromAddress, toAddress, subject, messageBody, dateOfMail);
		return emailDao.save(email);
	}

	@Override
	public List<Email> getAllEmailsOfUser(String emailId) throws UserAccountNotFoundException {
		UserAccount userAccount=user.getUserDetails(emailId);
		if(userAccount==null)throw new UserAccountNotFoundException("Sorry No user found");
		return emailDao.getAllEmailsOfUser(emailId);
	}

	@Override
	public Email getEmail(String emailId, int emailChatId) {
        Email email=emailDao.getEmail(emailId, emailChatId);	
		return email;
	}

}
