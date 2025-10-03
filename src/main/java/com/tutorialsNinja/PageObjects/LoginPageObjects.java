package com.tutorialsNinja.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	WebDriver driver;
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-password")
	private WebElement passwordField; 

	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	public LoginPageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void EnteremailField(String emailText) {
		emailField.sendKeys(emailText);
	}
	public void Enterpasswordfield(String PasswordText) {
		passwordField.sendKeys(PasswordText);
	}
	public void clickOnLoginButton() {
		loginButton.click();
	}
//	public void login(String emailText,String PasswordText) {
//		emailField.sendKeys(emailText);
//		passwordField.sendKeys(PasswordText);
//		loginButton.click();
//	}    // Reducing the above lines.
}
