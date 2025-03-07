package com.myproject.myproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class AppTest {

	String proPath = System.getProperty("user.dir");
	Properties properties = new Properties();
	static ExtentReports extent;
	static ExtentTest test;

	@Test
	public void demoTest() throws IOException, InterruptedException {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("ExtentReportExample.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// Create a new test and start logging
		
		test = extent.createTest("Demo Project","This is a demo test to demonstrate Extent Reports with Selenium");

		WebDriver driver = new ChromeDriver();
		FileInputStream input = new FileInputStream("../myproject/config.properties");
		properties.load(input);
		String BaseUrl = properties.getProperty("web.BaseURL");

		// navigate to URL
		driver.get(BaseUrl);
		test.info("Opened the website: https://www.google.com");

		Thread.sleep(1000);
		// search for amazon india
		AppDetails ap = PageFactory.initElements(driver, AppDetails.class);
		ap.setSearchNameField("Amazon");
		test.info("searched for Amazon text");
		Thread.sleep(1000);
		
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL)
		       .sendKeys("a")
		       .keyUp(Keys.CONTROL)
		       .sendKeys(Keys.CONTROL)
		       .sendKeys("c")
		       .keyUp(Keys.CONTROL)
		       .perform();
		
		driver.close();
		extent.flush();
	}
}
