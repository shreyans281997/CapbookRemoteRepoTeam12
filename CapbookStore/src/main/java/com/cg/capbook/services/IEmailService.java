package com.cg.capbook.services;

import java.util.List;

import com.cg.capbook.exceptions.UserAccountNotFoundException;
import com.cg.capbook.exceptions.UserNotAFriendException;
import com.cg.capbook.model.Email;

public interface IEmailService {
	Email saveEmail(String fromAddress,String toAddress,String subject,String messageBody)throws UserAccountNotFoundException,UserNotAFriendException;
	List<Email> getAllEmailsOfUser(String emailId);
}
