package com.freecrm.qa.testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.freecrm.qa.common.Config;
import com.freecrm.qa.common.TestUtil;
import com.freecrm.qa.pages.MyHomePage;
import com.freecrm.qa.pages.contact.ContactListPage;

public class ContactListPageTest extends AbstractTopMenuPanelInUserPagesTest {
	private static Logger log = LogManager.getLogger(ContactListPageTest.class.getName());

	public ContactListPage contactListPage;

	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) {
		MyHomePage myHomePage = TestUtil.getHomePage(browser);
		contactListPage = myHomePage.clickOnContactsLnk();
		contactListPage.setDriver(myHomePage.getDriver());
		contactListPage.setName(myHomePage.getName());
		super.topMenuPanelInUserPages = contactListPage;
	}

	//@Test
	public void selectContactByNameTest() {
		String name = Config.getProperty("default.user.firstName") + " " + Config.getProperty("default.user.lastName");
		log.info("selectContactByNameTest using: " + name);
		contactListPage.selectContactByName(name);		
	}

}