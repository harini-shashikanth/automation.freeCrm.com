package com.freecrm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyHomePage extends Page {

	public MyHomePage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}

}
