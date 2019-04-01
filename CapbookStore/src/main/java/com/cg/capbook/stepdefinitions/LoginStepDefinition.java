package com.cg.capbook.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.capbook.pagebeans.LoginPage;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition {
	private WebDriver driver;
	private LoginPage loginPage;
	@Before
	public void setUpStepEnv() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new ChromeDriver();	
	}
	@Given("^User is on Capbook Login Page$")
	public void user_is_on_Capbook_Login_Page() throws Throwable {
		driver.get("http://localhost:4000");
		loginPage=PageFactory.initElements(driver,LoginPage.class);
	}
	@When("^User enter invalid username and password$")
	public void user_enter_invalid_username_and_password() throws Throwable {
		loginPage.setEmailId("abhiwanrey");
		loginPage.setPassword("17856");
		loginPage.clickSignIn();
	}
	@Then("^'Invalid Username or Password!' Message should display$")
	public void invalid_Username_or_Password_Message_should_display() throws Throwable {
		String expectedErrorMessage="Please Register To Continue";
		Assert.assertEquals(expectedErrorMessage, loginPage.getActualErrorMesssage());
	}
	@When("^User has not entered username or password$")
	public void user_has_not_entered_username_or_password() throws Throwable {
		loginPage.setEmailId("");
		loginPage.setPassword("");
		loginPage.clickSignIn();
	}

	@Then("^'Don't Keep the Required Fields Empty' Message should display$")
	public void don_t_Keep_the_Required_Fields_Empty_Message_should_display() throws Throwable {
		String expectedErrorMessage="Don't Keep the Required Fields Empty";
		Assert.assertEquals(expectedErrorMessage, loginPage.getActualErrorMesssage());
	}
	
	@When("^User enter valid username and password$")
	public void user_enter_valid_username_and_password() throws Throwable {
		loginPage.setEmailId("abhiwanrey@gmail.com");
		loginPage.setPassword("12345");
		loginPage.clickSignIn();
	}
	@Then("^User should successfully login to his Capbook account$")
	public void user_should_successfully_login_to_his_Capbook_account() throws Throwable {
		String actualTitle = driver.getTitle();
		String expectedTitle="Edit Profile Page";
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	@After
	public void tearDownStepEnv() {
		driver.close();
	}
}
