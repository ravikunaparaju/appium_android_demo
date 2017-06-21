/*
 @author Ravi Kunaparaju  
 dt 20-06-2017
 */

package uk.co.ravi.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import uk.co.ravi.stepdefs.*;

public class Support {
	AndroidDriver driver;
	
	public Support(){		
		this.driver=SharedWebDriver.driver;
	 }
	
	public void wait_for_element_exists(String object){
		try{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(object)));
		}catch(NoSuchElementException noelement){
			System.out.println("element not present on the screen");
		}catch(TimeoutException timeout){
			System.out.println("timedout finding element");
		} 
	}

	public void click(String element){
		try{
			this.wait_for_element_exists(element);
		}catch(TimeoutException to){
			System.out.println("timedout finding element");
			to.getMessage();
		}
		driver.findElement(By.xpath(element)).click();	
	}
	
	
	public void enter_text(String element, String text){
		this.wait_for_element_exists(element);
		driver.findElementsById(element).clear();
		driver.findElementById(element).sendKeys(text);
	}
	
	public boolean element_exists(String element){
		try{
			this.wait_for_element_exists(element);
			driver.findElementsByXPath(element);
			return true;
		}
			catch(NoSuchElementException e){
				return false;
			}
	}
	
	public boolean element_does_not_exist(String element){
		try{
			driver.findElementsByXPath(element);
			return false;
		}
		catch(NoSuchElementException e){
			return true;
		}
		catch(TimeoutException to){
			return true;
		}
	}
}
