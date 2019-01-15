package com.freecrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.common.Browser;

public class LoginPage {
	private WebDriver driver;

	// @FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	private WebElement crmLogo;

	// @FindBy(xpath = "//a[contains(text(),'Features')]")
	private WebElement featuresLnk;

	// @FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	private WebElement signUpLnk;

	// @FindBy(xpath = "//a[contains(text(),'Pricing')]")
	private WebElement pricingLnk;

	// @FindBy(xpath = "//a[contains(text(),'Customers')]")
	private WebElement customersLnk;

	// @FindBy(xpath = "//a[contains(text(),'Contact')]")
	private WebElement contactLnk;

	// @FindBy(name = "username")
	private WebElement username;

	// @FindBy(name = "password")
	private WebElement password;

	// @FindBy(xpath = "//input[@type='submit']")
	private WebElement loginBtn;

	// @FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	private WebElement signUpBtn;

	public void initializeElements() {
		PageFactory.initElements(driver, this);
	}

	public MyHomePage login(String uname, String pwd, String name) {
		// loginBtn.click();
		// Actions actions = new Actions(driver);
		// actions.moveToElement(loginBtn).click().build().perform();
		// actions.moveToElement(loginBtn).click();

		getUsername().sendKeys(uname);
		getPassword().sendKeys(pwd);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", getLoginBtn());
		Browser.takeScreenshot(driver, "afterLogin", 5, false);
		MyHomePage myHomePage = new MyHomePage();
		myHomePage.setDriver(driver);
		myHomePage.setName(name);
		return myHomePage;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCrmLogo() {
		crmLogo = driver.findElement(By.xpath("//img[contains(@class,'img-responsive')]"));
		return crmLogo;
	}

	public WebElement getFeaturesLnk() {
		featuresLnk = driver.findElement(By.xpath("//a[contains(text(),'Features')]"));
		return featuresLnk;
	}

	public WebElement getSignUpLnk() {
		signUpLnk = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
		return signUpLnk;
	}

	public WebElement getPricingLnk() {
		pricingLnk = driver.findElement(By.xpath("//a[contains(text(),'Pricing')]"));
		return pricingLnk;
	}

	public WebElement getCustomersLnk() {
		customersLnk = driver.findElement(By.xpath("//a[contains(text(),'Customers')]"));
		return customersLnk;
	}

	public WebElement getContactLnk() {
		contactLnk = driver.findElement(By.xpath("//a[contains(text(),'Contact')]"));
		return contactLnk;
	}

	public WebElement getUsername() {
		username = driver.findElement(By.name("username"));
		return username;
	}

	public WebElement getPassword() {
		password = driver.findElement(By.name("password"));
		return password;
	}

	public WebElement getLoginBtn() {
		loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		return loginBtn;
	}

	public WebElement getSignUpBtn() {
		signUpBtn = driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));
		return signUpBtn;
	}

}
