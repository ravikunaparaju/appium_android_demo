/*
 @author Ravi Kunaparaju  
 dt 20-06-2017
 */

package uk.co.ravi.pagemodel;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import uk.co.ravi.stepdefs.SharedWebDriver;
import uk.co.ravi.utils.Support;

public class Login {
	AndroidDriver driver;
	Support support;
	
// Screen Elements
	
	public static String userEmail = "com.edf.mobile:id/titanium_ui_edittext";
	public static String password = "com.edf.mobile:id/titanium_ui_edittext";
	public static String loginFail = "//android.widget.TextView[@index='1']";
	
	public Login(){
		this.driver=SharedWebDriver.driver;
		support = PageFactory.initElements(driver, Support.class);
	 }

// Screen test logic
	
	public void login(String email,String pwd){
		support.enter_text(userEmail, email);
		driver.sendKeyEvent(66);
		support.enter_text(password, pwd);
		driver.sendKeyEvent(66);
	}
	
	public boolean loginSucess(){
		String text = driver.findElementByXPath(loginFail).getText();
		support.wait_for_element_exists(loginFail);
		if(text.equalsIgnoreCase("Something went wrong")){
			System.out.print("Login failed");
			return false;
		}else{
			return true;
		}
	}
	
	public boolean loginFailure(){
		try{
			driver.findElementByXPath(loginFail);
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
