package com.freecrm.qa.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.freecrm.qa.common.Config;
import com.freecrm.qa.common.PageValues;
import com.freecrm.qa.common.Util;
import com.freecrm.qa.pages.LoginPage;

public class LoginPageTest {
	WebDriver driver;
	LoginPage loginPage;

	@BeforeClass
	@Parameters("browser")
	public void setUp(String browser) {
		driver = Util.initializeBrowser(browser);
		loginPage = new LoginPage(driver);
	}

	@Test
	public void loginPageTitleTest() {
		String titleA = loginPage.getDriver().getTitle();
		String titleE = PageValues.getProperty("loginPage.title");
		Assert.assertEquals(titleA, titleE);
	}

	@Test
	public void loginPageIsLogoDisplayedTest() {
		Assert.assertEquals(loginPage.getCrmLogo().isDisplayed(), true);
	}

	@Test
	public void loginPageFeaturesLnkTest() {
		String actual = loginPage.getFeaturesLnk().getText();
		String expected = PageValues.getProperty("loginPage.featuresLnk.text");
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void loginPageSignUpLnkTest() {
		String actual = loginPage.getSignUpLnk().getText();
		String expected = PageValues.getProperty("loginPage.signUpLnk.text");
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void loginPagePricingLnkTest() {
		String actual = loginPage.getPricingLnk().getText();
		String expected = PageValues.getProperty("loginPage.pricingLnk.text");
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void loginPageCustomersLnkTest() {
		String actual = loginPage.getCustomersLnk().getText();
		String expected = PageValues.getProperty("loginPage.customersLnk.text");
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void loginPageContactLnkTest() {
		String actual = loginPage.getContactLnk().getText();
		String expected = PageValues.getProperty("loginPage.contactLnk.text");
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void loginPageSupportLnkTest() {
		String actual = loginPage.getSupportLnk().getText();
		String expected = PageValues.getProperty("loginPage.supportLnk.text");
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 1)
	public void login() {
		String username = Config.getProperty("default.username");
		String password = Config.getProperty("default.password");
		loginPage.login(username, password);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}