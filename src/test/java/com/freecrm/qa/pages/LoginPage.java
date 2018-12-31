package com.freecrm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Page {
	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	private WebElement crmLogo;

	@FindBy(xpath = "//*[@id=\"navbar-collapse\"]/ul/li[1]/a")
	private WebElement featuresLnk;

	@FindBy(xpath = "//*[@id=\"navbar-collapse\"]/ul/li[2]/a/font")
	private WebElement signUpLnk;

	@FindBy(xpath = "//*[@id=\"navbar-collapse\"]/ul/li[3]/a")
	private WebElement pricingLnk;

	@FindBy(xpath = "//*[@id=\"navbar-collapse\"]/ul/li[4]/a")
	private WebElement customersLnk;

	@FindBy(xpath = "//*[@id=\"navbar-collapse\"]/ul/li[5]/a")
	private WebElement contactLnk;

	@FindBy(xpath = "//*[@id=\"navbar-collapse\"]/ul/li[6]/a")
	private WebElement supportLnk;

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//*[@id=\"loginForm\"]/div/div/input")
	WebElement loginBtn;

	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	private WebElement signUpBtn;

	public LoginPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		// loginBtn.click();
		// Actions actions = new Actions(driver);
		// actions.moveToElement(loginBtn).click().build().perform();
		// actions.moveToElement(loginBtn).click();
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].click();", loginBtn);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();
		return new HomePage(driver);
	}

	public WebElement getCrmLogo() {
		return crmLogo;
	}

	public void setCrmLogo(WebElement crmLogo) {
		this.crmLogo = crmLogo;
	}

	public WebElement getFeaturesLnk() {
		return featuresLnk;
	}

	public void setFeaturesLnk(WebElement featuresLnk) {
		this.featuresLnk = featuresLnk;
	}

	public WebElement getSignUpLnk() {
		return signUpLnk;
	}

	public void setSignUpLnk(WebElement signUpLnk) {
		this.signUpLnk = signUpLnk;
	}

	public WebElement getPricingLnk() {
		return pricingLnk;
	}

	public void setPricingLnk(WebElement pricingLnk) {
		this.pricingLnk = pricingLnk;
	}

	public WebElement getCustomersLnk() {
		return customersLnk;
	}

	public void setCustomersLnk(WebElement customersLnk) {
		this.customersLnk = customersLnk;
	}

	public WebElement getContactLnk() {
		return contactLnk;
	}

	public void setContactLnk(WebElement contactLnk) {
		this.contactLnk = contactLnk;
	}

	public WebElement getSupportLnk() {
		return supportLnk;
	}

	public void setSupportLnk(WebElement supportLnk) {
		this.supportLnk = supportLnk;
	}

	public WebElement getUsername() {
		return username;
	}

	public void setUsername(WebElement username) {
		this.username = username;
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn(WebElement loginBtn) {
		this.loginBtn = loginBtn;
	}

	public WebElement getSignUpBtn() {
		return signUpBtn;
	}

	public void setSignUpBtn(WebElement signUpBtn) {
		this.signUpBtn = signUpBtn;
	}

}
