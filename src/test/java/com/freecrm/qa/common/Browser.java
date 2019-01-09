package com.freecrm.qa.common;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Browser {

	public static final String CHROME = "CHROME";
	public static final String FIREFOX = "FIREFOX";
	public static final String IE = "IE";
	public static final String EDGE = "EDGE";

	public static String userHomeDir;

	public static String chromeRelativePath;
	public static String firefoxRelativePath;
	public static String ieRelativePath;
	public static String edgeRelativePath;

	public static String defaultBrowser;
	public static boolean defaultIsEventFiringDriver;

	public static long defaultPageTimeOutSec;
	public static long defaultImplicitWaitSec;
	public static String defaultUrl;

	public static boolean takeScreenshotWithoutExceptionAlso;
	public static String screenshotRelativeDirectory;

	static {
		userHomeDir = FileUtils.getUserDirectory().getAbsolutePath();

		firefoxRelativePath = Config.getProperty("firefoxRelativePath");
		chromeRelativePath = Config.getProperty("chromeRelativePath");
		ieRelativePath = Config.getProperty("ieRelativePath");
		edgeRelativePath = Config.getProperty("edgeRelativePath");

		System.setProperty("webdriver.gecko.driver", userHomeDir + firefoxRelativePath);
		System.setProperty("webdriver.chrome.driver", userHomeDir + chromeRelativePath);
		System.setProperty("webdriver.ie.driver", userHomeDir + ieRelativePath);
		System.setProperty("webdriver.edge.driver", userHomeDir + edgeRelativePath);

		switch (Config.getProperty("defaultBrowser").toUpperCase()) {
		case (Browser.FIREFOX):
			defaultBrowser = Browser.FIREFOX;
			break;
		case (Browser.CHROME):
			defaultBrowser = Browser.CHROME;
			break;
		case (Browser.IE):
			defaultBrowser = Browser.IE;
			break;
		case (Browser.EDGE):
			defaultBrowser = Browser.EDGE;
			break;
		}

		if (Config.getProperty("defaultIsEventFiringDriver").toUpperCase().equals("TRUE")) {
			defaultIsEventFiringDriver = true;
		} else {
			defaultIsEventFiringDriver = false;
		}

		defaultPageTimeOutSec = Long.parseLong(Config.getProperty("defaultPageTimeOutSec"));
		defaultImplicitWaitSec = Long.parseLong(Config.getProperty("defaultImplicitWaitSec"));
		defaultUrl = Config.getProperty("defaultUrl");

		if (Config.getProperty("takeScreenshotWithoutExceptionAlso").toUpperCase().equals("TRUE")) {
			takeScreenshotWithoutExceptionAlso = true;
		} else {
			takeScreenshotWithoutExceptionAlso = false;
		}
		screenshotRelativeDirectory = Config.getProperty("screenshotRelativeDirectory");

	}

	public static WebDriver initializeBrowser(String browser, boolean isEventFiringDriver, long pageTimeOutSec,
			long implicitWaitSec, String url) {
		WebDriver driver = null;

		switch (browser.toUpperCase()) {
		case Browser.FIREFOX:
			driver = new FirefoxDriver();
			break;
		case Browser.CHROME:
			driver = new ChromeDriver();
			break;
		case Browser.IE:
			/*
			 * IE needs additional settings to work properly:
			 * 
			 * 1. add the capability to ignore zoom settings - through code
			 * 
			 * 2. add the capability to ensure clean session i.e., delete cookies etc..
			 * 
			 * 3. MANUAL: set the add the domain freecrm.com to the list of trusted sites in
			 * IE. Open IE and manually to the list of trusted sites under IE -> Internet
			 * Options -> Security -> Trusted Sites --> Sites
			 * 
			 * 4. Also use the 32 bit version of IE even if running on 64bit OS/machine. The
			 * sendkeys() method is super slow with the 64 bit driver. It are normal in 32
			 * bit version of IE
			 */
			InternetExplorerOptions ieOptions = new InternetExplorerOptions();
			ieOptions.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			ieOptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			driver = new InternetExplorerDriver(ieOptions);
			break;
		case Browser.EDGE:
			driver = new EdgeDriver();
			break;
		default:
			throw new RuntimeException(browser + " browser not supported currently.");
		}

		EventFiringWebDriver eventFiringWebDriver = null;
		if (isEventFiringDriver) {
			eventFiringWebDriver = new EventFiringWebDriver(driver);
			eventFiringWebDriver.register(new WebEventListener());
			driver = eventFiringWebDriver;
		}

		driver.manage().timeouts().pageLoadTimeout(pageTimeOutSec, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implicitWaitSec, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;

	}

	public static WebDriver initializeBrowser() {
		return initializeBrowser(defaultBrowser, defaultIsEventFiringDriver, defaultPageTimeOutSec,
				defaultImplicitWaitSec, defaultUrl);
	}

	public static WebDriver initializeBrowser(String browser) {
		return initializeBrowser(browser, defaultIsEventFiringDriver, defaultPageTimeOutSec, defaultImplicitWaitSec,
				defaultUrl);
	}

	public static WebDriver initializeBrowser(String browser, String url) {
		return initializeBrowser(browser, defaultIsEventFiringDriver, defaultPageTimeOutSec, defaultImplicitWaitSec,
				url);
	}

	public static void takeScreenshot(WebDriver driver, String tag, long delaySec, boolean isException) {
		String screenShotFileName = userHomeDir + screenshotRelativeDirectory + System.currentTimeMillis() + "_" + tag
				+ ".png";
		if (delaySec > 0) {
			try {
				Thread.sleep(delaySec * 1000);
			} catch (InterruptedException e1) {
			}
			if (!isException) {
				if (!takeScreenshotWithoutExceptionAlso) {
					return;
				} else {
					takeScreenShot(driver, new File(screenShotFileName));
				}
			} else {
				takeScreenShot(driver, new File(screenShotFileName));
			}
		}
	}

	public static void takeScreenshot(WebDriver driver, String tag) {
		String screenShotFileName = userHomeDir + screenshotRelativeDirectory + System.currentTimeMillis() + "_" + tag
				+ ".png";
		takeScreenShot(driver, new File(screenShotFileName));
	}

	public static void takeScreenshot(WebDriver driver) {
		String screenShotFileName = userHomeDir + screenshotRelativeDirectory + System.currentTimeMillis() + ".png";
		takeScreenShot(driver, new File(screenShotFileName));
	}

	private static void takeScreenShot(WebDriver webDriver, File screenShotFile) {
		File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, screenShotFile);
		} catch (IOException e) {
			System.out.println("Unable to take screenshot");
			e.printStackTrace();
		}
	}
}