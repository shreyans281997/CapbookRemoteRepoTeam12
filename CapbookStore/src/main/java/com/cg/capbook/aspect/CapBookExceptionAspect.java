package com.cg.capbook.aspect;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.cg.capbook.exceptions.EmailAlreadyRegisteredException;
import com.cg.capbook.exceptions.FieldsEmptyException;
import com.cg.capbook.exceptions.FriendRequestAlreadySentException;
import com.cg.capbook.exceptions.IncorrectOldPassword;
import com.cg.capbook.exceptions.InvalidQuestionOrAnswer;
import com.cg.capbook.exceptions.InvalidUsernameOrPasswordException;
import com.cg.capbook.exceptions.NoMailsArePresentToDeleteException;
import com.cg.capbook.exceptions.UserAccountNotFoundException;
import com.cg.capbook.exceptions.UserNameAlreadyExist;
import com.cg.capbook.exceptions.UserNotAFriendException;
@ControllerAdvice(basePackages= {"com.cg.capbook.controllers"})
public class CapBookExceptionAspect {
	@ExceptionHandler(EmailAlreadyRegisteredException.class)
	public ModelAndView handleEmailAlreadyRegisteredException(Exception e) {
		return new ModelAndView("loginPage", "errorMessage", e.getMessage());
	}
	@ExceptionHandler(IncorrectOldPassword.class)
	public ModelAndView handleIncorrectOldPassword(Exception e) {
		return new ModelAndView("editProfilePage", "errorMessage", e.getMessage());
	}
	@ExceptionHandler(InvalidUsernameOrPasswordException.class)
	public ModelAndView handleInvalidUsernameOrPasswordException(Exception e) {
		return new ModelAndView("loginPage", "errorMessage", e.getMessage());
	}
	@ExceptionHandler(UserAccountNotFoundException.class)
	public ModelAndView handleUserAccountNotFoundException(Exception e) {
		return new ModelAndView("loginPage", "errorMessage", e.getMessage());
	}
	@ExceptionHandler(UserNameAlreadyExist.class)
	public ModelAndView handleUserNameAlreadyExist(Exception e) {
		return new ModelAndView("getSignUp", "errorMessage", e.getMessage());
	}
	@ExceptionHandler(FieldsEmptyException.class)
	public ModelAndView handleFieldsEmptyException(Exception e) {
		return new ModelAndView("getSignUp", "errorMessage", e.getMessage());
	}
    @ExceptionHandler(InvalidQuestionOrAnswer.class)
     public ModelAndView handleInvalidQuestionOrAnswer(Exception e) {
    	return new ModelAndView("forgotPassword", "errorMessage", e.getMessage());
    }
    @ExceptionHandler(UserNotAFriendException.class)
    public ModelAndView handleUserNotAFriendException(Exception e) {
    	return new ModelAndView("sendEmail", "errorMessage", e.getMessage());
    }
    @ExceptionHandler(NoMailsArePresentToDeleteException.class)
    public ModelAndView handleNoMailsPresentToDeleteException(Exception e) {
    	return new ModelAndView("ShowAllEmails", "errorMessage", e.getMessage());
    }
    @ExceptionHandler(FriendRequestAlreadySentException.class)
    public ModelAndView handleFriendRequestAlreadySentException(Exception e) {
    	return new ModelAndView("resultPage", "errorMessage", e.getMessage());
    }
}
