package com.tutorialsNinja.listeners;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.awt.Desktop;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsNinja.utils.ExtentReporter;

public class MyListeners implements ITestListener{
	ExtentReports extentReporter;
	ExtentTest extenTest;


	public void onStart(ITestContext context) {
		try {
			extentReporter = ExtentReporter.generateExtentReport();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestStart(ITestResult result) {
		String testName=result.getName();
		extenTest = extentReporter.createTest(testName);
		extenTest.log(Status.INFO, testName +" Started execution.");
		//System.out.println(testName +" Started execution.");
	}

	public void onTestSuccess(ITestResult result) {
		String testName=result.getName();
		extenTest.log(Status.PASS, testName +" got successfully executed.");
		//System.out.println(testName +" got successfully executed.");
	}

	public void onTestFailure(ITestResult result) {
		String testName=result.getName();
		System.out.println("Screenshot Taken");

		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
		{
			e.printStackTrace();
		} 
		File srcScreenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		String destinationScreenshotPathString=System.getProperty("user.dir"+"\\Screenshots\\"+testName+".png");
		try {
			FileHandler.copy(srcScreenshotFile,new File(destinationScreenshotPathString));
		} catch (IOException e) {
			e.printStackTrace();
		}
		extenTest.addScreenCaptureFromPath(destinationScreenshotPathString);
		extenTest.log(Status.INFO, result.getThrowable());
		extenTest.log(Status.FAIL, testName +" got failed.");
	}

	public void onTestSkipped(ITestResult result) {
		String testName=result.getName();
		extenTest.log(Status.INFO, result.getThrowable());
		extenTest.log(Status.SKIP, testName +" got skipped.");
		//		System.out.println(testName +" got skipped.");
		//		System.out.println(result.getThrowable());
	}

	public void onFinish(ITestContext context) {
		//	System.out.println("Finished executing project test.");
		extentReporter.flush();
		
	}

}
