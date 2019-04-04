package com.cg.capbook.services;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.cg.capbook.daoservice.UserDAO;
import com.cg.capbook.exceptions.EmailAlreadyRegisteredException;
import com.cg.capbook.exceptions.FieldsEmptyException;
import com.cg.capbook.exceptions.IncorrectOldPassword;
import com.cg.capbook.exceptions.InvalidEmailException;
import com.cg.capbook.exceptions.InvalidQuestionOrAnswer;
import com.cg.capbook.exceptions.InvalidUsernameOrPasswordException;
import com.cg.capbook.exceptions.LoginFieldsEmptyException;
import com.cg.capbook.exceptions.UserAccountNotFoundException;
import com.cg.capbook.model.UserAccount;
@Component("userService")
public class UserServicesImpl implements IUserService{
	private static String UPLOADED_FOLDER = "C:\\Users\\ADM-IG-HWDLAB1D\\git\\CapbookLocalRepoTeam12\\CapbookStore\\src\\main\\resources\\static\\images\\";
	@Autowired
	private UserDAO userDao;
	@Autowired
	private IFriendRequestServices friendRequest;

	@Override
	public UserAccount acceptUserDetails(String emailId, String password, String firstName, String secondName, String dateOfBirth, String gender, String mobileNo,String securityQue,String answer)
			throws EmailAlreadyRegisteredException, FieldsEmptyException, InvalidEmailException {
		if(!(emailId.contains("@capgemini.com"))) throw new InvalidEmailException("You must be a  Capgemini employee");
		if(emailId.equals("") || password.equals("") || firstName.equals("") || secondName.equals("") || dateOfBirth.equals("") || gender.equals("") || mobileNo.equals("") || securityQue.equals("") || answer.equals(""))
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
	public UserAccount loginUser(String emailId, String password) throws InvalidUsernameOrPasswordException, UserAccountNotFoundException, LoginFieldsEmptyException {
		if(emailId.equals("")||password.equals(""))
			throw new LoginFieldsEmptyException("Don't Keep the Required Fields Empty");
		UserAccount userAccount=getUserDetails(emailId);
		String depcryptPassword=EncryptionAndDecryption.decrypt(userAccount.getPassword());
		System.out.println(depcryptPassword);
		if(password.equals(depcryptPassword))
			return userAccount;
		else
			throw new InvalidUsernameOrPasswordException("Invalid Username or Password!");
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
	public UserAccount addProfilePic(String emailId,MultipartFile file) throws UserAccountNotFoundException  {
		UserAccount user=userDao.findById(emailId).orElseThrow(()->new UserAccountNotFoundException("User Account Not Found"));
		try {
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			file.transferTo(path);
			user.setProfilePic("/images/" + file.getOriginalFilename());
			user=userDao.save(user);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;
	}
	public UserAccount updateDetails(String emailId,String userName) throws UserAccountNotFoundException {
		UserAccount user=getUserDetails(emailId);
		user.setUserName(userName);
		return userDao.save(user);
	}
	@Override
	public boolean changePassword(String emailId, String oldPassword, String newPassword) throws UserAccountNotFoundException, IncorrectOldPassword {
		UserAccount user=getUserDetails(emailId);
		if(oldPassword.equals(EncryptionAndDecryption.decrypt(user.getPassword())))
		{user.setPassword(EncryptionAndDecryption.encrypt(newPassword));
		userDao.save(user);
		return true;}
		else throw new IncorrectOldPassword();
	}
	@Override
	public UserAccount searchUser(String emailId) throws UserAccountNotFoundException {
		UserAccount user=getUserDetails(emailId);
		return user;
	}
	@Override
	public List<UserAccount> findBirthday(String emailId) throws UserAccountNotFoundException {
		List<String> friends=friendRequest.showAllFriends(emailId);
		ArrayList<UserAccount> userBirthday=new ArrayList<UserAccount>();
		for ( String friend : friends ) 
		{ if(getUserDetails(friend).getDateOfBirth().substring(5,10).equals( LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString().substring(5,10))) {
				userBirthday.add(getUserDetails(friend));}}
		return userBirthday;
	}
	@Override
	public List<UserAccount> users() {
		List<UserAccount> users= userDao.findAll();
		return users;
	}
	
}