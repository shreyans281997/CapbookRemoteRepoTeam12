
Feature: Login functionality check

Scenario: User is trying to signin in Capbook using invalid username and password

Given User is on Capbook Login Page
When User enter invalid username and password 
Then 'Invalid Username or Password!' Message should display

Scenario: User is trying to signin in Capbook without entering username and password

Given User is on Capbook Login Page
When User has not entered username or password
Then 'Don't Keep the Required Fields Empty' Message should display

Scenario:  User is trying to signin in Capbook using valid username and password

Given  User is on Capbook Login Page
When User enter valid username and password
Then User should successfully login to his Capbook account