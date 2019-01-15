package com.freecrm.qa.panels;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.freecrm.qa.pages.contact.ContactListPage;
import com.freecrm.qa.pages.contact.NewContactPage;

/**
 * 
 * All user pages have the same top menu. This class has the web elements and
 * their actions in the panel hosting the top menu.
 * 
 * This class does not have any abstract methods but has been declared for a
 * reason - so that accidentally instances of this class are NOT created. The
 * actual page classes like MyHomePage, Contact Page, New Contact Entry Page,
 * New Contact Save Page shall extend this class. Only such page classes shall
 * be instantiated. *
 *
 * @author harini
 */
public abstract class AbstractTopMenuPanelInUserPages {
	private static Logger log = LogManager.getLogger(AbstractTopMenuPanelInUserPages.class.getName());

	private WebDriver driver;
	private String name;

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

	private WebElement contactsLnk;

	private WebElement contactsNewContactLnk;

	private WebElement contactsCombinedFormLnk;

	private WebElement contactsFullSearchFormLnk;

	private WebElement dealsLnk;

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

	public WebElement getUserNameLabel() {
		if (userNameLabel == null) {
		}
		return userNameLabel;
	}

	public ContactListPage clickOnContactsLnk() {
		log.debug("click Contacts");
		getContactsLnk().click();
		ContactListPage contactList = new ContactListPage();
		return contactList;
	}

	public NewContactPage clickOnContactsNewContactLnk() {
		log.debug("clickOnContactsNewContactLnk(). Return New Contact object");
		getContactsNewContactLnk().click();
		NewContactPage newContactPage = new NewContactPage();
		return newContactPage;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WebElement getHomeLnk() {
		return homeLnk;
	}

	public WebElement getCalendarLnk() {
		return calendarLnk;
	}

	public WebElement getCalendarNewEventLnk() {
		return calendarNewEventLnk;
	}

	public WebElement getCalendarViewTodayLnk() {
		return calendarViewTodayLnk;
	}

	public WebElement getCalendarWeekViewLnk() {
		return calendarWeekViewLnk;
	}

	public WebElement getCalendarMonthViewLnk() {
		return calendarMonthViewLnk;
	}

	public WebElement getCompaniesLnk() {
		return companiesLnk;
	}

	public WebElement getCompaniesNewCompanyLnk() {
		return companiesNewCompanyLnk;
	}

	public WebElement getCompaniesCombinedFormLnk() {
		return companiesCombinedFormLnk;
	}

	public WebElement getCompaniesFullSearchFormLnk() {
		return companiesFullSearchFormLnk;
	}

	public WebElement getContactsLnk() {
		// Browser.switchToFrame(driver, "mainpanel");
		contactsLnk = driver.findElement(By.xpath("//a[@title='Contacts']"));
		return contactsLnk;
	}

	public WebElement getContactsNewContactLnk() {
		// Browser.switchToFrame(driver, "mainpanel");
		contactsNewContactLnk = driver.findElement(By.xpath("//a[@title='New Contact']"));
		Actions action = new Actions(driver);
		action.moveToElement(getContactsLnk()).build().perform();
		return contactsNewContactLnk;
	}

	public WebElement getContactsCombinedFormLnk() {
		return contactsCombinedFormLnk;
	}

	public WebElement getContactsFullSearchFormLnk() {
		return contactsFullSearchFormLnk;
	}

	public WebElement getDealsLnk() {
		return dealsLnk;
	}

	public WebElement getDealsNewDealLnk() {
		return dealsNewDealLnk;
	}

	public WebElement getDealsProductsLnk() {
		return dealsProductsLnk;
	}

	public WebElement getDealsFullSearchFormLnk() {
		return dealsFullSearchFormLnk;
	}

	public WebElement getTasksLnk() {
		return tasksLnk;
	}

	public WebElement getTasksNewTaskLnk() {
		return tasksNewTaskLnk;
	}

	public WebElement getTasksFullSearchFormLnk() {
		return tasksFullSearchFormLnk;
	}

	public WebElement getCasesLnk() {
		return casesLnk;
	}

	public WebElement getCasesNewCaseLnk() {
		return casesNewCaseLnk;
	}

	public WebElement getCasesFullSearchFormLnk() {
		return casesFullSearchFormLnk;
	}

	public WebElement getCallLnk() {
		return callLnk;
	}

	public WebElement getCallNewCallLnk() {
		return callNewCallLnk;
	}

	public WebElement getCallCallScriptsLnk() {
		return callCallScriptsLnk;
	}

	public WebElement getCallCallListLnk() {
		return callCallListLnk;
	}

	public WebElement getEmailLnk() {
		return emailLnk;
	}

	public WebElement getEmailNewEmailCampaignLnk() {
		return emailNewEmailCampaignLnk;
	}

	public WebElement getEmailEmailTemplatesLnk() {
		return emailEmailTemplatesLnk;
	}

	public WebElement getEmailMailAccountsLnk() {
		return emailMailAccountsLnk;
	}

	public WebElement getEmailCustomizeEmailContentLnk() {
		return emailCustomizeEmailContentLnk;
	}

	public WebElement getEmailEmailSignatureLnk() {
		return emailEmailSignatureLnk;
	}

	public WebElement getTextSmsLnk() {
		return textSmsLnk;
	}

	public WebElement getTextSmsNewTextSmsCampaignLnk() {
		return textSmsNewTextSmsCampaignLnk;
	}

	public WebElement getTextSmsTextSmsTemplatesLnk() {
		return textSmsTextSmsTemplatesLnk;
	}

	public WebElement getTextSmsTextSmsCreditsLnk() {
		return textSmsTextSmsCreditsLnk;
	}

	public WebElement getPrintLnk() {
		return printLnk;
	}

	public WebElement getPrintNewPrintCampaignLnk() {
		return printNewPrintCampaignLnk;
	}

	public WebElement getPrintNewWordMergeTemplateLnk() {
		return printNewWordMergeTemplateLnk;
	}

	public WebElement getCampaignsLnk() {
		return campaignsLnk;
	}

	public WebElement getCampaignsEmailCampaignsLnk() {
		return campaignsEmailCampaignsLnk;
	}

	public WebElement getCampaignsNewEmailCampaignLnk() {
		return campaignsNewEmailCampaignLnk;
	}

	public WebElement getCampaignsEmailTemplatesLnk() {
		return campaignsEmailTemplatesLnk;
	}

	public WebElement getCampaignsMailAccountsLnk() {
		return campaignsMailAccountsLnk;
	}

	public WebElement getCampaignsTestSmsCampaignsLnk() {
		return campaignsTestSmsCampaignsLnk;
	}

	public WebElement getCampaignsNewTextSmsCampaignLnk() {
		return campaignsNewTextSmsCampaignLnk;
	}

	public WebElement getCampaignsTextSmsTemplatesLnk() {
		return campaignsTextSmsTemplatesLnk;
	}

	public WebElement getCampaignsTextSmsCreditsLnk() {
		return campaignsTextSmsCreditsLnk;
	}

	public WebElement getCampaignsPrintCampaignsLnk() {
		return campaignsPrintCampaignsLnk;
	}

	public WebElement getCampaignsNewPrintCampaignLnk() {
		return campaignsNewPrintCampaignLnk;
	}

	public WebElement getCampaignsNewWordMergeTemplateLnk() {
		return campaignsNewWordMergeTemplateLnk;
	}

	public WebElement getCampaignsVoiceCampaignsLnk() {
		return campaignsVoiceCampaignsLnk;
	}

	public WebElement getDocsLnk() {
		return docsLnk;
	}

	public WebElement getDocsNewDocumentLnk() {
		return docsNewDocumentLnk;
	}

	public WebElement getDocsNewDirectoryLnk() {
		return docsNewDirectoryLnk;
	}

	public WebElement getDocsNewWordMergeTemplateLnk() {
		return docsNewWordMergeTemplateLnk;
	}

	public WebElement getDocsMultiDocUploadLnk() {
		return docsMultiDocUploadLnk;
	}

	public WebElement getFormsLnk() {
		return formsLnk;
	}

	public WebElement getFormsNewFormLnk() {
		return formsNewFormLnk;
	}

	public WebElement getReportsLnk() {
		return reportsLnk;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

}
