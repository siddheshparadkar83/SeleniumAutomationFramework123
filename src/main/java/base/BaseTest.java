package base;

import java.lang.System.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.Log;

public class BaseTest {

	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		Log.info("starting web driver....");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		Log.info("navigating to URL....");
		driver.get("https://admin-demo.nopcommerce.com/login");
		
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver != null) {
			Log.info("Closing browser");
			driver.quit();
		}
	}
}
