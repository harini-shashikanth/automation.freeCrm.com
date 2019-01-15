package com.freecrm.qa.testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.freecrm.qa.common.Config;
import com.freecrm.qa.common.ExcelUtil;
import com.freecrm.qa.common.TestUtil;
import com.freecrm.qa.pages.MyHomePage;
import com.freecrm.qa.pages.contact.NewContactPage;

public class NewContactPageTest extends AbstractTopMenuPanelInUserPagesTest {
	private NewContactPage newContactPage;

	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) {
		MyHomePage myHomePage = TestUtil.getHomePage(browser);
		newContactPage = new NewContactPage();
		newContactPage.setDriver(myHomePage.getDriver());
		newContactPage.setName(myHomePage.getName());
		super.topMenuPanelInUserPages = newContactPage;
	}

	@Test(dataProvider = "getNewContactTestData")
	public void addContactTest(String title, String fName, String lName, String comp, String position, String mobile,
			String email, String skypeId) {
		newContactPage.addNewContact(title, fName, lName, comp, position, mobile, email, skypeId);
	}

	@DataProvider
	public Object[][] getNewContactTestData() {
		return ExcelUtil.getTestData(Config.getProperty("testdata.excel.sheet.for.new.contact"));
	}

}
