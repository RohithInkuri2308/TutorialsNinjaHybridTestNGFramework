package com.tutorialsNinja.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.NonWritableChannelException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;

public class ExtentReporter {
	
	public static ExtentReports generateExtentReport() throws IOException {
		ExtentReports extentReport =new ExtentReports();
		
		File extentReportFile=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("TutorialsNinja Test Automation Results");
		sparkReporter.config().setDocumentTitle("TN Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter);
		
		Properties confiProperties=new Properties();
		File configPropFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsNinja\\config\\config.properties");
		FileInputStream fileInputStream =new FileInputStream(configPropFile);
		confiProperties.load(fileInputStream);
		extentReport.setSystemInfo("Application URL", confiProperties.getProperty("url"));
		extentReport.setSystemInfo("Browser Name", confiProperties.getProperty("browserName"));
		extentReport.setSystemInfo("Email", confiProperties.getProperty("email"));
		extentReport.setSystemInfo("ValidPassword", confiProperties.getProperty("password"));
		extentReport.setSystemInfo("Operating System", System.getProperty("os.version"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
		extentReport.setSystemInfo("User Name", System.getProperty("user.name"));
		
		return extentReport;
	}

}
