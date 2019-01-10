package com.freecrm.qa.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.freecrm.qa.testCases.LoginPageTest;

public class WebEventListener implements WebDriverEventListener {
	
	private static Logger log = LogManager.getLogger(LoginPageTest.class.getName());
	
	public void beforeNavigateTo(String url, WebDriver driver) {
		log.trace("Before navigating to: '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		log.trace("Navigated to:'" + url + "'");
		Browser.takeScreenshot(driver, "afterNavigateTo", 0, false);
		;
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		log.trace("Value of the:" + element.toString() + " before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		log.trace("Element value changed to: " + element.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		log.trace("Trying to click on: " + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		log.trace("Clicked on: " + element.toString());
		Browser.takeScreenshot(driver, "afterClickOn", 2, false);
	}

	public void beforeNavigateBack(WebDriver driver) {
		log.trace("Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {
		log.trace("Navigated back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		log.trace("Navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver) {
		log.trace("Navigated forward to next page");
	}

	public void onException(Throwable error, WebDriver driver) {
		log.trace("Exception occured: " + error);
		Browser.takeScreenshot(driver, "Exception", 2, true);

	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		log.trace("Trying to find Element By : " + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		log.trace("Found Element By : " + by.toString());
	}

	/*
	 * non overridden methods of WebListener class
	 */
	public void beforeScript(String script, WebDriver driver) {
	}

	public void afterScript(String script, WebDriver driver) {
	}

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
	}

	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub
	}

	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		// TODO Auto-generated method stub
	}

	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
	}

	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
	}

	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
	}
}