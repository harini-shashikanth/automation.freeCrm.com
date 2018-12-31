package com.freecrm.qa.common;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.freecrm.qa.eventListener.WebEventListener;

public class Util {
	public static WebDriver initializeBrowser(String browser) {
		WebDriver driver = null;
		String userHomeDir = FileUtils.getUserDirectory().getAbsolutePath();
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					userHomeDir + "/ChromeDriver/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", userHomeDir + "/GeckoDriver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
		eventFiringWebDriver.register(new WebEventListener());
		driver = eventFiringWebDriver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(Config.getProperty("pageLoadTimeoutSec")),
				TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(Config.getProperty("implicitWait")), TimeUnit.SECONDS);
		driver.get(Config.getProperty("baseUrl"));
		return driver;
	}

	public static WebDriver initializeBrowser() {
		String defaultBrowser = Config.getProperty("default.browser");
		WebDriver driver = null;
		if (defaultBrowser != null) {
			driver = initializeBrowser(defaultBrowser);
		} else {
			System.out.println(
					"Default Browser not configured. Please set value for default.browser in config.properties");
		}
		return driver;
	}

	public static void takeScreenshotAtEndOfTest(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String userHomeDir = FileUtils.getUserDirectory().getAbsolutePath();
		FileUtils.copyFile(scrFile,
				new File(userHomeDir + "/com/freecrm/qa/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}
