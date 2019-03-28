package com.cg.capbook.daoservice;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.cg.capbook.model.Email;
import org.springframework.data.repository.query.Param;

public interface EmailDAO extends JpaRepository<Email, Integer>{
	@Query("from Email e where e.toAddress =:emailId")
	public List<Email> getAllEmailsOfUser(@Param("emailId") String  emailId);
	@Query("from Email e where e.toAddress =:emailId and e.emailChatId=:emailChatId")
	public Email getEmail(@Param("emailId") String emailId,@Param("emailChatId") int emailChatId);
	 @Transactional
	  @Modifying
	@Query("delete from Email e where e.toAddress =:emailId and e.emailChatId=:emailChatId")
    public void deleteEmail(@Param("emailId") String emailId,@Param("emailChatId") int emailChatId);
	 @Transactional
	  @Modifying
	@Query("delete from Email e where e.toAddress =:emailId")
	 public void deleteAllEmails(@Param("emailId") String emailId);
	 
	 @Query("from Email e where e.fromAddress =:emailId")
		public List<Email> getAllSentEmailsOfUser(@Param("emailId") String  emailId);
		@Query("from Email e where e.fromAddress =:emailId and e.emailChatId=:emailChatId")
		public Email getSentEmail(@Param("emailId") String emailId,@Param("emailChatId") int emailChatId);
		 @Transactional
		  @Modifying
		@Query("delete from Email e where e.fromAddress =:emailId and e.emailChatId=:emailChatId")
	    public void deleteSentEmail(@Param("emailId") String emailId,@Param("emailChatId") int emailChatId);
		 @Transactional
		  @Modifying
		@Query("delete from Email e where e.fromAddress =:emailId")
		 public void deleteAllSentEmails(@Param("emailId") String emailId);
}
