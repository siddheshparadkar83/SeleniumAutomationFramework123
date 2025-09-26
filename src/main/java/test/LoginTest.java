package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest{
	
	@Test
	public void testValidLogin() {
		
		Log.info("staring test");
		test = ExtentReportManager.createTest("Login test");
		
		test.info("navigating to URL");
		LoginPage loginPage = new LoginPage(driver);
		
		test.info("Adding Creds..");
		Log.info("entering creds..");
		loginPage.enterUsername("admin@yourstore.com");
		loginPage.enterPassword("admin");
		
		test.info("Clicking Login Button");
		loginPage.clickLogin();
		System.out.println("The title of the page is:" + driver.getTitle());
		
		Log.info("Verifying title");
		test.info("Verifying page title");
		Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
		
		test.pass("Login Successful");
	}
	
	@Test
	public void testInvalidLogin() {
		
		Log.info("staring test");
		test = ExtentReportManager.createTest("Login test");
		
		test.info("navigating to URL");
		LoginPage loginPage = new LoginPage(driver);
		
		test.info("Adding Creds..");
		Log.info("entering creds..");
		loginPage.enterUsername("admin123@yourstore.com");
		loginPage.enterPassword("admin123");
		
		test.info("Clicking Login Button");
		loginPage.clickLogin();
		System.out.println("The title of the page is:" + driver.getTitle());
		
		Log.info("Verifying title");
		test.info("Verifying page title");
		Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration123");
		
		test.pass("Login Successful");
	}

}
