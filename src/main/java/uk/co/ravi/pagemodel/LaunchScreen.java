/*
 @author Ravi Kunaparaju  
 dt 20-06-2017
 */
package uk.co.ravi.pagemodel;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import uk.co.ravi.stepdefs.SharedWebDriver;
import uk.co.ravi.utils.Support;

public class LaunchScreen {
	AndroidDriver driver;
	Support support;
	
// Screen Elements
	
	public static String skipButton = "//android.widget.Button[@text='Skip']";
	public static String scanYourBill = "//android.widget.Button[@index='1']";
	
	public LaunchScreen(){		
		this.driver=SharedWebDriver.driver;
		support = PageFactory.initElements(driver, Support.class);
	 }

// Screen test logic
	
	public void skipLaunchScreen(){
		support.click(skipButton);	
	}
	
	public void scanYourBill(){
		support.click(scanYourBill);
	}
}
