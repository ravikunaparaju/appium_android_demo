/*
 @author Ravi Kunaparaju  
 dt 20-06-2017
 */

package uk.co.ravi.pagemodel;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import uk.co.ravi.stepdefs.SharedWebDriver;
import uk.co.ravi.utils.Support;

public class LoginRegistrationScreen {
	AndroidDriver driver;
	Support support;
	
// Screen Elements
	
	public static String register = "//android.widget.Button[@text='Register']";
	public static String login = "//android.widget.Button[@text='Log in']";
	
	public LoginRegistrationScreen(){		
		this.driver=SharedWebDriver.driver;
		support = PageFactory.initElements(driver, Support.class);
	 }

// Screen test logic
	
	public void navigateToRegistrationScreen(){
		support.click(register);	
	}
	
	public void navigateToLoginScreen(){
		support.click(login);
	}
}
