package com.myproject.myproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class AppTest {
	
String proPath=System.getProperty("user.dir");
  @Test
  public void shouldAnswerWithTrue() {
	 WebDriver driver=new ChromeDriver();
	 driver.get("https://www.google.com/");
    System.out.println("test");
    driver.close();
  }
}
