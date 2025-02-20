package com.myproject.myproject;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class AppDetails {

    // Declare ExtentReports and ExtentTest objects
    static ExtentReports extent;
    static ExtentTest test;

    public static void main(String[] args) {
        // Set up the ExtentHtmlReporter and specify the output report file path
    	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("ExtentReportExample.html");
        
        // Initialize ExtentReports with the HTML Reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // Create a new test and start logging
        test = extent.createTest("SeleniumTest", "This is a test to demonstrate Extent Reports with Selenium");

        // Set up WebDriver (Chrome in this case)
        WebDriver driver = new ChromeDriver();

        try {
            // Log a step in the report
            test.info("Launching the Chrome browser");

            // Open the URL
            driver.get("https://www.example.com");
            test.info("Opened the website: https://www.example.com");

            // Find an element on the webpage (example: clicking on a link)
            WebElement exampleLink = driver.findElement(By.linkText("More information..."));

            // Click on the link
            exampleLink.click();
            test.info("Clicked on the link 'More information...'");
            // Verify that the page has the expected title
            String title = driver.getTitle();
            if (title.equals("Example Domain")) {
                test.pass("Page title is correct: " + title);
            } else {
                test.fail("Page title is incorrect. Expected 'Example Domain' but got: " + title);
            }
        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
        } finally {
            // Close the browser and the report
            driver.quit();
            extent.flush();  // Flush the report to save it
        }
    }
}
