package com.freecrm.qa.testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.freecrm.qa.common.Browser;
import com.freecrm.qa.common.Config;
import com.freecrm.qa.common.ExcelUtil;
import com.freecrm.qa.common.PageValues;
import com.freecrm.qa.pages.LoginPage;

public class LoginPageTest {
	private static Logger log = LogManager.getLogger(LoginPageTest.class.getName());

	public LoginPage loginPage;

	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) {
		log.info("Set Up: Initializing browser: " + browser);
		WebDriver driver = Browser.initializeBrowser(browser);
		loginPage = new LoginPage();
		loginPage.setDriver(driver);
		log.info("Login Page Loaded");
	}

	@Test
	public void loginPageContentTest() {
		log.info("loginPageContentTest:");
		String actual = null;
		String expected = null;

		// login page title
		log.debug("login page title test case");
		actual = loginPage.getDriver().getTitle();
		expected = PageValues.getProperty("loginPage.title");
		Assert.assertEquals(actual, expected);

		// loginPageIsLogoDisplayed
		log.debug("loginPageIsLogoDisplayed test case");
		Assert.assertEquals(loginPage.getCrmLogo().isDisplayed(), true);

		// loginPageFeaturesLnk
		log.debug("loginPageFeaturesLnk test case");
		actual = loginPage.getFeaturesLnk().getText();
		expected = PageValues.getProperty("loginPage.featuresLnk.text");
		Assert.assertEquals(actual, expected);

		// loginPageSignUpLnk
		log.debug("loginPageSignUpLnk test case");
		actual = loginPage.getSignUpLnk().getText();
		expected = PageValues.getProperty("loginPage.signUpLnk.text");
		Assert.assertEquals(actual, expected);

		// loginPagePricingLnk
		log.debug("loginPagePricingLnk test case");
		actual = loginPage.getPricingLnk().getText();
		expected = PageValues.getProperty("loginPage.pricingLnk.text");
		Assert.assertEquals(actual, expected);

		// loginPageCustomersLnk
		log.debug("loginPageCustomersLnk test case");
		actual = loginPage.getCustomersLnk().getText();
		expected = PageValues.getProperty("loginPage.customersLnk.text");
		Assert.assertEquals(actual, expected);

		// loginPageContactLnk
		log.debug("loginPageContactLnk test case");
		actual = loginPage.getContactLnk().getText();
		expected = PageValues.getProperty("loginPage.contactLnk.text");
		Assert.assertEquals(actual, expected);

	}

	@Test(dataProvider = "getLoginCredentialsFromExcel")
	public void loginTest(String username, String password, String name) {
		log.info("Login Test:  " + "Username:" + username + " Password:" + password + " Name:" + name);
		loginPage.login(username, password, name);
	}

	@DataProvider
	public Object[][] getLoginCredentialsFromExcel() {
		String sheet = Config.getProperty("testdata.excel.sheet.for.login");
		log.debug("Retrieving Test Data from the sheet" + sheet + "of configured Excel file");
		Object data[][] = ExcelUtil.getTestData(sheet);
		return data;
	}

	@AfterMethod
	public void teardown() {
		Capabilities capabilities = ((EventFiringWebDriver) loginPage.getDriver()).getCapabilities();
		String browser = capabilities.getBrowserName();
		log.info("In teardown(). Closing browser " + browser);
		loginPage.getDriver().quit();
	}
}