package com.cg.capbook.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.capbook.pagebeans.LoginPage;
import com.cg.capbook.pagebeans.SignUpPage;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignUpStepDefinition {
	private WebDriver driver;
	private SignUpPage signupPage;
	@Before
	public void setUpStepEnv() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new ChromeDriver();	
	}
	@Given("^User is on Capbook Registration Page$")
	public void user_is_on_Capbook_Registration_Page() throws Throwable {
		driver.get("http://localhost:4000/getSignUp");
		signupPage=PageFactory.initElements(driver,SignUpPage.class);
	}

	@When("^User is trying to submit without entering First name$")
	public void user_is_trying_to_submit_without_entering_First_name() throws Throwable {
		signupPage.setFirstName("");
		signupPage.clickSignUp();
	}

	@Then("^'Don't Keep the Required Fields Empty' Message should display$")
	public void don_t_Keep_the_Required_Fields_Empty_Message_should_display() throws Throwable {
		String expectedErrorMessage="Don't Keep the Required Fields Empty";
		Assert.assertEquals(expectedErrorMessage, signupPage.getActualErrorMesssage());
	}

	@When("^User is trying to submit without entering Last name$")
	public void user_is_trying_to_submit_without_entering_Last_name() throws Throwable {
		signupPage.setSecondName("");
		signupPage.clickSignUp();
	}

	@When("^User is trying to submit without entering Gender$")
	public void user_is_trying_to_submit_without_entering_Gender() throws Throwable {
		signupPage.setGender("");;
		signupPage.clickSignUp();
	}

	@When("^User is trying to submit without entering Date of Birth$")
	public void user_is_trying_to_submit_without_entering_Date_of_Birth() throws Throwable {
		signupPage.setDateOfBirth("");;
		signupPage.clickSignUp();
	}

	@When("^User is trying to submit without entering Email Id$")
	public void user_is_trying_to_submit_without_entering_Email_Id() throws Throwable {
		signupPage.setEmailId("");
		signupPage.clickSignUp();
	}

	@When("^User is trying to submit without entering Mobile Number$")
	public void user_is_trying_to_submit_without_entering_Mobile_Number() throws Throwable {
		signupPage.setMobileNo("");
		signupPage.clickSignUp();
	}

	@When("^User is trying to submit without entering Create Password$")
	public void user_is_trying_to_submit_without_entering_Create_Password() throws Throwable {
		signupPage.setPassword("");
		signupPage.clickSignUp();
	}

	@When("^User is trying to submit without selecting Security Ques$")
	public void user_is_trying_to_submit_without_selecting_Security_Ques() throws Throwable {
		signupPage.setSecurityQue("value");
		signupPage.clickSignUp();
	}

	@When("^User is trying to submit without entering Answer$")
	public void user_is_trying_to_submit_without_entering_Answer() throws Throwable {
		signupPage.setAnswer("");
		signupPage.clickSignUp();
	}

	@When("^User is trying to submit data$")
	public void user_is_trying_to_submit_data() throws Throwable {
		signupPage.setFirstName("Kirito");
		signupPage.setSecondName("VVV");
		signupPage.setGender("male");
		signupPage.setDateOfBirth("2019-03-20");
		signupPage.setEmailId("kirito@gmail.com");
		signupPage.setMobileNo("9005445642");
		signupPage.setPassword("12345");
		signupPage.setSecurityQue("petName");		
		signupPage.setAnswer("Leo");
		signupPage.clickSignUp();
		
	}
	@Then("^User is redirected to Login Page$")
	public void user_is_redirected_to_Login_Page() throws Throwable {
		String actualTitle=driver.getTitle();
		String expectedTitle="Login Page";
		Assert.assertEquals(expectedTitle, actualTitle); 
	}

//	@Then("^'You have registered successfully' Message should display$")
//	public void you_have_registered_successfully_Message_should_display() throws Throwable {
//		System.out.println(driver.getTitle());
//		System.out.println(signupPage.getActualSuccessMessage());
//		String expectedSuccessMessage="You have registered successfully";
//		Assert.assertEquals(expectedSuccessMessage, signupPage.getActualSuccessMessage());
//	}
	@When("^User is trying to register using existing emailId$")
	public void user_is_trying_to_register_using_existing_emailId() throws Throwable {
	    
	    signupPage.setFirstName("Kirito");
		signupPage.setSecondName("VVV");
		signupPage.setGender("male");
		signupPage.setDateOfBirth("2019-03-20");
		signupPage.setEmailId("abhiwanrey@gmail.com");
		signupPage.setMobileNo("9005445642");
		signupPage.setPassword("12345");
		signupPage.setSecurityQue("petName");		
		signupPage.setAnswer("Leo");
		signupPage.clickSignUp();
	}

	@Then("^'Email is already in use\\.' Message should display$")
	public void email_is_already_in_use_Message_should_display() throws Throwable {
		String expectedErrorMessage="Email is already in use.";
		Assert.assertEquals(expectedErrorMessage, signupPage.getErrorMesssage());
	}
	@After
	public void tearDownStepEnv() {
		driver.close();
	}
}
