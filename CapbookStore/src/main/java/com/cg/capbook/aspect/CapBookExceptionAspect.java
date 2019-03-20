package com.cg.capbook.aspect;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.cg.capbook.exceptions.EmailAlreadyRegisteredException;

@ControllerAdvice(basePackages= {"com.cg.capbook.controllers"})
public class CapBookExceptionAspect {
	@ExceptionHandler(EmailAlreadyRegisteredException.class)
	public ModelAndView handleEmailAlreadyRegisteredException(Exception e) {
		return new ModelAndView("errorPage", "errorMessage", e.getMessage());
	}
	
}
