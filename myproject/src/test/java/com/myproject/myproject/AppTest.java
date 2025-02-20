package com.myproject.myproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class AppTest {
	
String proPath=System.getProperty("user.dir");
Properties properties = new Properties();
static ExtentReports extent;
static ExtentTest test;

  @Test
  public void demoTest() throws IOException, InterruptedException {
	  ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("ExtentReportExample.html");
	  extent = new ExtentReports();
      extent.attachReporter(htmlReporter);

      // Create a new test and start logging
      test = extent.createTest("SeleniumTest", "This is a test to demonstrate Extent Reports with Selenium");

      
	 WebDriver driver=new ChromeDriver();
	 FileInputStream input = new FileInputStream("../myproject/config.properties");
     properties.load(input);
     String BaseUrl = properties.getProperty("web.BaseURL");
     
    //navigate to URL
	 driver.get(BaseUrl);
	 test.info("Opened the website: https://www.google.com");

	 Thread.sleep(1000);
	 //download pdf file
	 
	 
	//search for amazon india
	 driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("Amazon");
	 Thread.sleep(1000);
     System.out.println("test");
     driver.close();
     extent.flush();
  }
}
