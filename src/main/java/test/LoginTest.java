package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.Log;

public class LoginTest extends BaseTest{
	
	@Test
	public void testValidLogin() {
		
		Log.info("staring test");
		LoginPage loginPage = new LoginPage(driver);
		
		Log.info("entering creds..");
		loginPage.enterUsername("admin@yourstore.com");
		loginPage.enterPassword("admin");
		loginPage.clickLogin();
		System.out.println("The title of the page is:" + driver.getTitle());
		
		Log.info("Verifying title");
		Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
	}

}
