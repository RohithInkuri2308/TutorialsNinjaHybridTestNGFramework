package com.tutorialsNinja.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {
	WebDriver driver;
	//Objects
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountdropdownElement;

	@FindBy(linkText="Login")
	private WebElement loginbuttonElement;
	
	public HomePageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	//Actions
	public void ClickonMyaccount() {
		myAccountdropdownElement.click();
	}
	public void ClickonLogin() {
		loginbuttonElement.click();
	}
}
