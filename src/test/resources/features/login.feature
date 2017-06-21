@regression
Feature: login test	

	Scenario: Verify user able to login to the app	
	
		Given user launched the application
		When user enters username and password
		Then user should be logged in