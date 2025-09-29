package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {

	@DataProvider(name = "LoginData")
	public Object[][] getLoginData() throws IOException {

		String filePath = System.getProperty("user.dir") + "/testdata/TestData.xlsx";
		ExcelUtils.loadExcel(filePath, "Sheet1");
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount - 1][2];

		for (int i = 1; i < rowCount; i++) {

			data[i - 1][0] = ExcelUtils.getCellData(i, 0); // username
			data[i - 1][1] = ExcelUtils.getCellData(i, 1); // password
		}

		ExcelUtils.closeExcel();
		return data;
	}

	@DataProvider(name = "LoginData2")
	public Object[][] getData() {
		return new Object[][] { { "user1", "pass1" }, { "user2", "pass2" }, { "user3", "pass3" }

		};
	}

	
	@Test(dataProvider = "LoginData2")
	
	//@Parameters({"username","password"})
	public void testValidLogin(String username, String password) {

		Log.info("staring test");
		test = ExtentReportManager.createTest("Login test -" + username);

		test.info("navigating to URL");
		LoginPage loginPage = new LoginPage(driver);

		test.info("Adding Creds..");
		Log.info("entering creds..");

		loginPage.enterUsername(username);
		loginPage.enterPassword(password);

		/*
		 * loginPage.enterUsername("admin@yourstore.com");
		 * loginPage.enterPassword("admin");
		 */
		test.info("Clicking Login Button");
		loginPage.clickLogin();
		System.out.println("The title of the page is:" + driver.getTitle());

		Log.info("Verifying title");
		test.info("Verifying page title");
		Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");

		test.pass("Login Successful");
	}

	/*
	 * @Test public void testInvalidLogin() {
	 * 
	 * Log.info("staring test"); test =
	 * ExtentReportManager.createTest("Login test");
	 * 
	 * test.info("navigating to URL"); LoginPage loginPage = new LoginPage(driver);
	 * 
	 * test.info("Adding Creds.."); Log.info("entering creds..");
	 * loginPage.enterUsername("admin123@yourstore.com");
	 * loginPage.enterPassword("admin123");
	 * 
	 * test.info("Clicking Login Button"); loginPage.clickLogin();
	 * System.out.println("The title of the page is:" + driver.getTitle());
	 * 
	 * Log.info("Verifying title"); test.info("Verifying page title");
	 * Assert.assertEquals(driver.getTitle(),
	 * "Dashboard / nopCommerce administration123");
	 * 
	 * test.pass("Login Successful"); }
	 */
}
