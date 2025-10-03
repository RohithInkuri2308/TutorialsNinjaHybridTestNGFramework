package com.tutorialsNinja.testcases;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsNinja.Base.Base;
import com.tutorialsNinja.utils.Utilities;

public class Register extends Base{
	public WebDriver driver;
	@BeforeMethod
	public void setUp() throws IOException {
		loadProperties();
		driver=intializebrowser(prop.getProperty("browserName"));
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void Registeration() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys(testProp.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(testProp.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(Utilities.Emailgenerator());
		Thread.sleep(1000);
		driver.findElement(By.id("input-telephone")).sendKeys(testProp.getProperty("telephone"));
		driver.findElement(By.id("input-password")).sendKeys("1234567");
		driver.findElement(By.id("input-confirm")).sendKeys("1234567");
		driver.findElement(By.xpath("//input[contains(@name,'agree')][@value='1']")).click();
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

	}

}
