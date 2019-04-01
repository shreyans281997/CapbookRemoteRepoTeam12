@execute
Feature: SignUp functionality check

Scenario: User is trying to signup in Capbook without entering all details

Given User is on Capbook Registration Page

When User is trying to submit without entering First name
Then 'Don't Keep the Required Fields Empty' Message should display

When User is trying to submit without entering Last name
Then 'Don't Keep the Required Fields Empty' Message should display

When User is trying to submit without entering Gender
Then 'Don't Keep the Required Fields Empty' Message should display

When User is trying to submit without entering Date of Birth
Then 'Don't Keep the Required Fields Empty' Message should display

When User is trying to submit without entering Email Id
Then 'Don't Keep the Required Fields Empty' Message should display

When User is trying to submit without entering Mobile Number
Then 'Don't Keep the Required Fields Empty' Message should display

When User is trying to submit without entering Create Password
Then 'Don't Keep the Required Fields Empty' Message should display

When User is trying to submit without selecting Security Ques
Then 'Don't Keep the Required Fields Empty' Message should display

When User is trying to submit without entering Answer
Then 'Don't Keep the Required Fields Empty' Message should display

Scenario: User is trying to signup in Capbook entering all valid set of details

Given User is on Capbook Registration Page

When User is trying to submit data
Then User is redirected to Login Page
#And 'You have registered successfully' Message should display

Scenario: User is trying to signup in Capbook entering an already registered emailId

Given User is on Capbook Registration Page

When User is trying to register using existing emailId
Then 'Email is already in use.' Message should display