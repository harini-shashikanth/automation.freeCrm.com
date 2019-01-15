package com.freecrm.qa.pages.contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.freecrm.qa.panels.AbstractTopMenuPanelInUserPages;

public class NewContactPage extends AbstractTopMenuPanelInUserPages {

	WebElement firstName;
	WebElement lastName;
	WebElement company;
	WebElement position;
	WebElement mobile;
	WebElement email;
	WebElement skypeId;
	WebElement save;

	public ViewContact addNewContact(String title, String firstName, String lastName, String comp, String position,
			String mobile, String email, String skypeId) {
		clickOnContactsNewContactLnk();
		Select select = new Select(getDriver().findElement(By.name("title")));
		select.selectByVisibleText(title);
		getFirstName().sendKeys(firstName);
		getLastName().sendKeys(lastName);
		getCompany().sendKeys(comp);
		getPosition().sendKeys(position);
		getMobile().sendKeys(mobile);
		getEmail().sendKeys(email);
		getSkypeId().sendKeys(skypeId);
		getSave().click();
		ViewContact viewContact = new ViewContact();
		return viewContact;
	}

	public WebElement getFirstName() {
		firstName = getDriver().findElement(By.id("first_name"));
		return firstName;
	}

	public WebElement getLastName() {
		lastName = getDriver().findElement(By.id("surname"));
		return lastName;
	}

	public WebElement getCompany() {
		company = getDriver().findElement(By.name("client_lookup"));
		return company;
	}

	public WebElement getPosition() {
		position = getDriver().findElement(By.id("company_position"));
		return position;
	}

	public WebElement getMobile() {
		mobile = getDriver().findElement(By.id("mobile"));
		return mobile;
	}

	public WebElement getEmail() {
		email = getDriver().findElement(By.id("email"));
		return email;
	}

	public WebElement getSkypeId() {
		skypeId = getDriver().findElement(By.id("skype_id"));
		return skypeId;
	}

	public WebElement getSave() {
		save = getDriver().findElement(By.xpath("//input[@type='submit' and @value='Save']"));
		return save;
	}

}
