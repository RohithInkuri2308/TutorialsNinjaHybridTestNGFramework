package com.tutorialsNinja.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputFilter.Config;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Base {
	WebDriver driver;
	public	Properties prop;
	public  Properties testProp;
	public void loadProperties() throws IOException {
		prop=new Properties();
		File file =new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsNinja\\config\\config.properties");
		FileInputStream fis=new FileInputStream(file);
		prop.load(fis);
		
		testProp=new Properties();
		File testdataFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsNinja\\testdata\\testdata.properties");
		FileInputStream fis2=new FileInputStream(testdataFile);
		testProp.load(fis2);
	}

	public WebDriver intializebrowser(String browserName) {

		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("safari")) {
			driver=new SafariDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get(prop.getProperty("url"));
		return driver;
	}

}
