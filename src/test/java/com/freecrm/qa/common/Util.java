package com.freecrm.qa.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.freecrm.qa.eventListener.WebEventListener;

public class Util {
	public static void initialization(String browser) {
		// String browserName = prop.getProperty("browser");
		WebDriver driver = null;
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:/opt/apps/ChromeDriver/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:/opt/apps/GeckoDriver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		EventFiringWebDriver eventFiringWebDriver= new EventFiringWebDriver(driver);
		
		eventFiringWebDriver.register(new WebEventListener());
		driver = eventFiringWebDriver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
	}
}
