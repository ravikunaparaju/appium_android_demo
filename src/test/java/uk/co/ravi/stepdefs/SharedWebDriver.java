/*
 @author Ravi Kunaparaju  
 dt 20-06-2017
 */

package uk.co.ravi.stepdefs;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import java.io.File;
import java.net.URL;

public class SharedWebDriver extends EventFiringWebDriver {
	public static AndroidDriver driver;
	
	static {
		try {
			File app  = new File("demo.apk");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "5203b8ef47e314df");
			capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);	
			driver.launchApp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				try {
					driver.quit();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
	}
	  
	public SharedWebDriver() {
		super(driver);
	}
}
