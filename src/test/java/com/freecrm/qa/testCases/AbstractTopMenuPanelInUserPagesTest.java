/**
 * 
 */
package com.freecrm.qa.testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.common.PageValues;
import com.freecrm.qa.panels.AbstractTopMenuPanelInUserPages;

/**
 * @author Harini
 * 
 *         This is an abstract test. The tests defined here will be invoked as
 *         part of child test classes. It will have tests but no setup and
 *         teardown methods.
 *
 */
public abstract class AbstractTopMenuPanelInUserPagesTest {
	private static Logger log = LogManager.getLogger(AbstractTopMenuPanelInUserPages.class.getName());

	AbstractTopMenuPanelInUserPages topMenuPanelInUserPages;

	@Test
	public void testContentInTopMenuPanelInUserPages() {
		log.info("tes tContent I nTop Menu Panel In User Pages");

		String actual;
		String expected;

		actual = topMenuPanelInUserPages.getContactsLnk().getText();
		expected = PageValues.getProperty("topMenuPanelInUserPages.contactsLnk.text");
		log.debug("actual,exected: " + actual + "," + expected);
		Assert.assertEquals(actual, expected);

		actual = topMenuPanelInUserPages.getContactsNewContactLnk().getText();
		expected = PageValues.getProperty("topMenuPanelInUserPages.contactsNewContactLnk.text");
		log.debug("actual,exected: " + actual + "," + expected);
		Assert.assertEquals(actual, expected);
	}

	@AfterMethod
	public void teardown() {
		topMenuPanelInUserPages.getDriver().quit();
	}
}
