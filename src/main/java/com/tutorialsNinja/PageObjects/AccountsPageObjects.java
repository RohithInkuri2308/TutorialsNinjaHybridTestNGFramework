package com.tutorialsNinja.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPageObjects {
	WebDriver driver;
	@FindBy(linkText = "Edit your account information")
	private WebElement EdityouraccountinformationOption;
    
	
	public AccountsPageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public boolean getdisplayStatusAccountInformationOption() {
		boolean displaystatus=EdityouraccountinformationOption.isDisplayed();
		return displaystatus;
	}
}
