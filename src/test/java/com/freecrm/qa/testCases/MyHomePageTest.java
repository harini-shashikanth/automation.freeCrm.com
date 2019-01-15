package com.freecrm.qa.testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.freecrm.qa.common.TestUtil;
import com.freecrm.qa.pages.MyHomePage;

public class MyHomePageTest extends AbstractTopMenuPanelInUserPagesTest {
	@SuppressWarnings("unused")
	private static Logger log = LogManager.getLogger(MyHomePageTest.class.getName());

	MyHomePage myHomePage;

	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) {
		myHomePage = TestUtil.getHomePage(browser);
		super.topMenuPanelInUserPages = myHomePage;
	}

}