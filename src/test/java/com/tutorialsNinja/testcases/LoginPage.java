package com.tutorialsNinja.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsNinja.Base.Base;
import com.tutorialsNinja.PageObjects.AccountsPageObjects;
import com.tutorialsNinja.PageObjects.HomePageObjects;
import com.tutorialsNinja.PageObjects.LoginPageObjects;

public class LoginPage extends Base{
	public WebDriver driver;

	@BeforeMethod
	public void setUp() throws IOException {
		loadProperties();
		driver=intializebrowser(prop.getProperty("browserName"));
		HomePageObjects	 homePage=new HomePageObjects(driver);
		homePage.ClickonMyaccount();
		homePage.ClickonLogin();
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	@Test
	public void Loginwithvalidcred() {
		LoginPageObjects loginpage=new LoginPageObjects(driver);
		loginpage.EnteremailField(prop.getProperty("email"));
		loginpage.Enterpasswordfield(prop.getProperty("password"));
		loginpage.clickOnLoginButton();
		
		//loginpage.login(prop.getProperty("email"),prop.getProperty("password")); //Reducing the above lines.
		AccountsPageObjects accountsPageObjects =new AccountsPageObjects(driver);
		Assert.assertTrue(accountsPageObjects.getdisplayStatusAccountInformationOption(), "Edit your account information option is not displayed");
	}

}
