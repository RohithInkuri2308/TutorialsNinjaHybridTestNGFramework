package com.tutorialsNinja.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsNinja.Base.Base;
import com.tutorialsNinja.utils.Utilities;

public class Login extends Base{
	public WebDriver driver;
	@BeforeMethod
	public void validateLogin() throws IOException {
		loadProperties();
		driver=intializebrowser(prop.getProperty("browserName"));
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test(priority = 1)
	public void verifyloginwithInvalidcredentails() {
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.id("input-password")).sendKeys(testProp.getProperty("invalidPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualwarningmsg=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String expectedwarningmsg=testProp.getProperty("emailpasswordnotmatching");
		Assert.assertTrue(actualwarningmsg.contains(expectedwarningmsg), "Expected message is not displayed.");
	}
	@Test(priority = 2)
	public void search() {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//input[@class='form-control input-lg']")).sendKeys("HP");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
		
	}
}
