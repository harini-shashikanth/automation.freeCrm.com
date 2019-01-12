package com.freecrm.qa.testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.freecrm.qa.common.Browser;
import com.freecrm.qa.common.Config;
import com.freecrm.qa.common.ExcelUtil;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.pages.MyHomePage;

public class MyHomePageTest {
	private static Logger log = LogManager.getLogger(MyHomePageTest.class.getName());
	WebDriver driver;
	MyHomePage myHomePage;

	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) {
		log.debug("In setUp(). Initializing browser: " + browser);
		driver = Browser.initializeBrowser(browser);
		LoginPage loginPage = new LoginPage(driver);
		log.debug("Login Page Loaded");
		String username = Config.getProperty("default.username");
		String password = Config.getProperty("default.password");
		myHomePage = loginPage.login(username, password);

	}

	@Test(dataProvider = "getNewContactTestData")
	public void addContactTest(String title, String fName, String lName, String comp, String position, String mobile,
			String email, String skypeId) {
		myHomePage.addNewContact(title, fName, lName, comp, position, mobile, email, skypeId);

	}

	@DataProvider
	public Object[][] getNewContactTestData() {

		return ExcelUtil.getTestData(Config.getProperty("testdata.excel.sheet.for.new.contact"));
	}

	@AfterMethod
	public void teardown() {
		Capabilities capabilities = ((EventFiringWebDriver) driver).getCapabilities();
		String browser = capabilities.getBrowserName();
		log.debug("In teardown(). Closing browser " + browser);
		driver.quit();
	}

}
