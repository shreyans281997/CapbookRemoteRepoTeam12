package com.cg.capbook.services;

import java.util.List;

import com.cg.capbook.exceptions.NoMailsArePresentToDeleteException;
import com.cg.capbook.exceptions.UserAccountNotFoundException;
import com.cg.capbook.exceptions.UserNotAFriendException;
import com.cg.capbook.model.Email;
import com.cg.capbook.model.UserAccount;

public interface IEmailService {
	Email saveEmail(String fromAddress,String toAddress,String subject,String messageBody)throws UserAccountNotFoundException,UserNotAFriendException;
	List<Email> getAllEmailsOfUser(String emailId) throws UserAccountNotFoundException;
	Email getEmail(String emailId,int emailChatId);
	void delEmail(String emailId,int emailChatId);
	void deleteAllMails(String emailId) throws NoMailsArePresentToDeleteException;
	//sent e-mails services.
	List<Email> getAllSentEmailsOfUser(String emailId) throws UserAccountNotFoundException;
	Email getSentEmail(String emailId,int emailChatId) throws UserAccountNotFoundException;
	void delSentEmail(String emailId,int emailChatId);
	void deleteAllSentMails(String emailId) throws NoMailsArePresentToDeleteException;
}
