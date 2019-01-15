package com.freecrm.qa.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.pages.MyHomePage;

public class TestUtil {

	private static Logger log = LogManager.getLogger(TestUtil.class.getName());

	public static MyHomePage getHomePage(String browser) {
		log.info("SetUp: Initializing browser: " + browser);
		WebDriver driver = Browser.initializeBrowser(browser);
		LoginPage loginPage = new LoginPage();
		loginPage.setDriver(driver);
		// loginPage.initializeElements();
		String username = Config.getProperty("default.username");
		String password = Config.getProperty("default.password");
		String name = Config.getProperty("default.user.firstName") + " " + Config.getProperty("default.user.lastName");
		MyHomePage myHomePage = loginPage.login(username, password, name);
		myHomePage.setDriver(driver);
		Browser.switchToFrame(myHomePage.getDriver(), "mainpanel");
		return myHomePage;
	}

}
