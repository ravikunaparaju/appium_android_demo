package uk.co.ravi.stepdefs;

import org.openqa.selenium.support.PageFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import uk.co.ravi.utils.Support;
import uk.co.ravi.pagemodel.LaunchScreen;
import uk.co.ravi.pagemodel.Login;
import uk.co.ravi.pagemodel.LoginRegistrationScreen;
import static org.junit.Assert.*;

public class Login_steps {	
	AndroidDriver driver;
	Support support;
	LaunchScreen launchscreen;
	LoginRegistrationScreen loginRegistration;
	Login login;
		
	
	public Login_steps(){
		this.driver=SharedWebDriver.driver;
		support = PageFactory.initElements(driver, Support.class);
		launchscreen = PageFactory.initElements(driver, LaunchScreen.class);
		loginRegistration = PageFactory.initElements(driver, LoginRegistrationScreen.class);
		login = PageFactory.initElements(driver, Login.class);
	}
	
	@Given("^user launched the application$")
	public void user_launched_the_application() throws Throwable {
		launchscreen.skipLaunchScreen();
	}

	@When("^user enters username and password$")
	public void user_enters_username_and_password() throws Throwable {
		loginRegistration.navigateToLoginScreen();
		login.login("someone@example.com", "123456");
	}

	@Then("^user should be logged in$")
	public void user_should_be_logged_in() throws Throwable {
		assertTrue("login failed", login.loginSucess());
	}
	
}