package com.freecrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.freecrm.qa.common.Browser;
import com.freecrm.qa.common.Config;

public class MyHomePage extends Page {

	private String title;

	// @FindBy(xpath = "//td[contains(text(),'User: Harini Kumar')]")
	// If we use annotation above, then we have to hardcode the name, it cannot be
	// parameterized.
	// See the getter method for parameterized implementation
	private WebElement userNameLabel;

	private WebElement homeLnk;

	private WebElement calendarLnk;

	private WebElement calendarNewEventLnk;

	private WebElement calendarViewTodayLnk;

	private WebElement calendarWeekViewLnk;

	private WebElement calendarMonthViewLnk;

	private WebElement companiesLnk;

	private WebElement companiesNewCompanyLnk;

	private WebElement companiesCombinedFormLnk;

	private WebElement companiesFullSearchFormLnk;

	@FindBy(xpath = "//a[@title='Contacts']")
	private WebElement contactsLnk;

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	private WebElement contactsNewContactLnk;

	private WebElement contactsCombinedFormLnk;

	private WebElement contactsFullSearchFormLnk;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	private WebElement dealsLnk;

	@FindBy(xpath = "//a[contains(text(),'New Deal')]")
	private WebElement dealsNewDealLnk;

	private WebElement dealsProductsLnk;

	private WebElement dealsFullSearchFormLnk;

	private WebElement tasksLnk;

	private WebElement tasksNewTaskLnk;

	private WebElement tasksFullSearchFormLnk;

	private WebElement casesLnk;

	private WebElement casesNewCaseLnk;

	private WebElement casesFullSearchFormLnk;

	private WebElement callLnk;

	private WebElement callNewCallLnk;

	private WebElement callCallScriptsLnk;

	private WebElement callCallListLnk;

	private WebElement emailLnk;

	private WebElement emailNewEmailCampaignLnk;

	private WebElement emailEmailTemplatesLnk;

	private WebElement emailMailAccountsLnk;

	private WebElement emailCustomizeEmailContentLnk;

	private WebElement emailEmailSignatureLnk;

	private WebElement textSmsLnk;

	private WebElement textSmsNewTextSmsCampaignLnk;

	private WebElement textSmsTextSmsTemplatesLnk;

	private WebElement textSmsTextSmsCreditsLnk;

	private WebElement printLnk;

	private WebElement printNewPrintCampaignLnk;

	private WebElement printNewWordMergeTemplateLnk;

	private WebElement campaignsLnk;

	private WebElement campaignsEmailCampaignsLnk;

	private WebElement campaignsNewEmailCampaignLnk;

	private WebElement campaignsEmailTemplatesLnk;

	private WebElement campaignsMailAccountsLnk;

	private WebElement campaignsTestSmsCampaignsLnk;

	private WebElement campaignsNewTextSmsCampaignLnk;

	private WebElement campaignsTextSmsTemplatesLnk;

	private WebElement campaignsTextSmsCreditsLnk;

	private WebElement campaignsPrintCampaignsLnk;

	private WebElement campaignsNewPrintCampaignLnk;

	private WebElement campaignsNewWordMergeTemplateLnk;

	private WebElement campaignsVoiceCampaignsLnk;

	private WebElement docsLnk;

	private WebElement docsNewDocumentLnk;

	private WebElement docsNewDirectoryLnk;

	private WebElement docsNewWordMergeTemplateLnk;

	private WebElement docsMultiDocUploadLnk;

	private WebElement formsLnk;

	private WebElement formsNewFormLnk;

	private WebElement reportsLnk;

	private WebElement searchBtn;

	public MyHomePage(WebDriver webDriver) {
		this.driver = webDriver;
		Browser.switchToFrame(webDriver, "mainpanel");
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameLabel() {
		if (userNameLabel == null) {
			String firstName = Config.getProperty("default.user.firstName");
			String lastName = Config.getProperty("default.user.lastName");
			String name = firstName + " " + lastName;
			// @FindBy(xpath = "//td[contains(text(),'User: Harini Kumar')]")
			String xpath = "//td[contains(text(),'User: " + name + "')]";
			WebElement element = driver.findElement(By.xpath(xpath));
			setUserNameLabel(element);
		}
		return userNameLabel;
	}

	public void setUserNameLabel(WebElement userNameLabel) {
		this.userNameLabel = userNameLabel;
	}

	//
	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public void setContactsLnk(WebElement contactsLnk) {
		this.contactsLnk = contactsLnk;
	}

	public void clickOnContactsLnk() {
		contactsLnk.click();
	}

	public void selectContactByName(String name) {
		clickOnContactsLnk();
		driver.findElement(By.xpath("//a[text()='" + name + "' AND  @context='contact'")).click();
	}

	//
	public WebElement getContactsNewContactLnk() {
		return contactsNewContactLnk;
	}

	//
	public void setContactsNewContactLnk(WebElement contactsNewContactLnk) {
		this.contactsNewContactLnk = contactsNewContactLnk;
	}

	public void clickOnContactsNewContactLnk() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLnk).build().perform();
		contactsNewContactLnk.click();
	}

	public void addNewContact(String title, String fName, String lName, String comp, String position, String mobile,
			String email, String skypeId) {
		clickOnContactsNewContactLnk();
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);

		driver.findElement(By.id("first_name")).sendKeys(fName);
		driver.findElement(By.id("surname")).sendKeys(lName);
		driver.findElement(By.name("client_lookup")).sendKeys(comp);
		driver.findElement(By.id("company_position")).sendKeys(position);
		driver.findElement(By.id("mobile")).sendKeys(mobile);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("skype_id")).sendKeys(skypeId);
		driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();

	}

	//
}
