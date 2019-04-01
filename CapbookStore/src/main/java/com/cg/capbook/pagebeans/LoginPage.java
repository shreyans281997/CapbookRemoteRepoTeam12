package com.cg.capbook.pagebeans;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	@FindBy(how=How.XPATH,xpath="//input[@name='emailId']")
	private WebElement emailId;
	
	@FindBy(how=How.NAME,name="password")
	private WebElement password;
	
	@FindBy(className="btn")
	private WebElement button;
	
	@FindBy(how=How.XPATH,xpath="/html/body/div[3]/div/div[2]/div/div[1]")
	private WebElement actualErrorMesssage;
	
	public LoginPage() {}

	public String getEmailId() {
		return emailId.getAttribute("value");
	}

	public void setEmailId(String emailId) {
		this.emailId.sendKeys(emailId);
	}

	public String getPassword() {
		return password.getAttribute("value");
	}

	public void setPassword(String password) {
		this.password.sendKeys(password);
	}

	public WebElement getButton() {
		return button;
	}

	public String getActualErrorMesssage() {
		return actualErrorMesssage.getText();
	}

	public void clickSignIn() {
		button.submit();
	}
}
