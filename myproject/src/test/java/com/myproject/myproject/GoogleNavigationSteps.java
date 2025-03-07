package com.myproject.myproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleNavigationSteps {
	

	    @Given("the user is on the login page")
	    public void the_user_is_on_the_login_page() {
	    	System.out.println("user in on login page");
	        
	    }

	    @When("the user enters valid credentials")
	    public void the_user_enters_valid_credentials() {
	    	System.out.println("user enters valid credentials");
	      
	    }

	    @Then("the user should be redirected to the homepage")
	    public void the_user_should_be_redirected_to_the_homepage() {
	    	WebDriver driver=new ChromeDriver();
	    	driver.get("google.com");
	 
	    }
	}


