package com.cg.capbook.pagebeans;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignUpPage {
	@FindBy(how=How.NAME,name="firstName")
	private WebElement firstName;
	
	@FindBy(how=How.NAME,name="secondName")
	private WebElement secondName;
	
	@FindBy(how=How.NAME,name="gender")
	private WebElement gender;
	
	@FindBy(how=How.NAME,name="dateOfBirth")
	private WebElement dateOfBirth;
	
	@FindBy(how=How.NAME,name="emailId")
	private WebElement emailId;
	
	@FindBy(how=How.NAME,name="mobileNo")
	private WebElement mobileNo;
	
	@FindBy(how=How.NAME,name="password")
	private WebElement password;
	
	@FindBy(how=How.NAME,name="securityQue")
	private WebElement securityQue;
	
	@FindBy(how=How.NAME,name="answer")
	private WebElement answer;
	
	@FindBy(className="btn")
	private WebElement button;
	
	@FindBy(how=How.XPATH,xpath="/html/body/article/div")
	private WebElement actualErrorMesssage;
	
	@FindBy(how=How.XPATH, xpath="/html/body/div[3]/div/div[2]/div/div[2]")
	private WebElement actualSuccessMessage;

	@FindBy(how=How.XPATH,xpath="/html/body/div[3]/div/div[2]/div/div[1]")
	private WebElement errorMesssage;
	
	public SignUpPage() {}
	
	public String getFirstName() {
		return firstName.getAttribute("value");
	}

	public void setFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
	}

	public String getSecondName() {
		return secondName.getAttribute("value");
	}

	public void setSecondName(String secondName) {
		this.secondName.sendKeys(secondName);
	}

	public String getGender() {
		return gender.getAttribute("value");
	}

	public void setGender(String gender) {
		this.gender.sendKeys(gender);
	}

	public String getDateOfBirth() {
		return dateOfBirth.getAttribute("value");
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth.sendKeys(dateOfBirth);
	}

	public String getEmailId() {
		return emailId.getAttribute("value");
	}

	public void setEmailId(String emailId) {
		this.emailId.sendKeys(emailId);
	}

	public WebElement getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo.sendKeys(mobileNo);
	}

	public String getPassword() {
		return password.getAttribute("value");
	}

	public void setPassword(String password) {
		this.password.sendKeys(password);
	}

	public String getSecurityQue() {
		return securityQue.getAttribute("value");
	}

	public void setSecurityQue(String securityQue) {
		this.securityQue.sendKeys(securityQue);
	}

	public void setActualSuccessMessage(String actualSuccessMessage) {
		this.actualSuccessMessage.sendKeys(actualSuccessMessage);
	}

	public String getAnswer() {
		return answer.getAttribute("value");
	}

	public void setAnswer(String answer) {
		this.answer.sendKeys(answer);
	}

	public String getButton() {
		return button.getAttribute("value");
	}

	public String getActualErrorMesssage() {
		return actualErrorMesssage.getText();
	}

	public String getActualSuccessMessage() {
		return actualSuccessMessage.getText();
	}

	public String getErrorMesssage() {
		return errorMesssage.getText();
	}

	public void clickSignUp() {
		button.submit();
	}
}
