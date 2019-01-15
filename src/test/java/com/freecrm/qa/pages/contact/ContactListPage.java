package com.freecrm.qa.pages.contact;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.freecrm.qa.panels.AbstractTopMenuPanelInUserPages;

public class ContactListPage extends AbstractTopMenuPanelInUserPages {

	private static Logger log = LogManager.getLogger(ContactListPage.class.getName());

	private WebElement selectContact;

	public void selectContactByName(String name) {
		// String xpath = "//a[text()='" + name + "' and @context='contact']";
		String xpath = "//a[@-name='Harini Kumar']";
		log.debug("selectContactByName for name: " + name + "using xpath:" + xpath);
		getDriver().findElement(By.xpath(xpath)).click();
	}

	public WebElement getSelectContact() {
		return selectContact;
	}

}