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
	WebDriver driver;
	LoginPage loginPage;

	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) {
		log.debug("In setUp(). Initializing browser: " + browser);
		driver = Browser.initializeBrowser(browser);
		loginPage = new LoginPage(driver);
		log.debug("Login Page Loaded");
	}

	@Test(priority = 0)
	public void loginPageContentTest() {
		log.debug("loginPageContentTest:");
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

		// loginPageSupportLnk
		log.debug("loginPageSupportLnk test case");
		actual = loginPage.getSupportLnk().getText();
		expected = PageValues.getProperty("loginPage.supportLnk.text");
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 1, dataProvider = "login credentials")
	public void login(String username, String password) {
		// String username = Config.getProperty("default.username");
		// String password = Config.getProperty("default.password");
		loginPage.login(username, password);
	}

	@DataProvider(name="login credentials")
	public Object[][] getTestDataFromExcel() {
		log.debug("inside dataprovider method");
		Object data[][] = ExcelUtil.getTestData(Config.getProperty("testdata.excel.sheet.for.login"));
		return data;
	}

	@AfterMethod
	public void teardown() {
		Capabilities capabilities = ((EventFiringWebDriver) driver).getCapabilities();
		String browser = capabilities.getBrowserName();
		log.debug("In teardown(). Closing browser " + browser);
		driver.quit();
	}
}