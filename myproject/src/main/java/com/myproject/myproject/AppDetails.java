package com.myproject.myproject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppDetails {

	  @FindBy(xpath = "//textarea[@class='gLFyf']")
      private WebElement searchBox;
	
	  public WebElement getSearchBox() {
		return searchBox;
	}

	public void setSearchBox(WebElement searchBox) {
		this.searchBox = searchBox;
	}

	public void setSearchNameField(String username) {
		  searchBox.sendKeys(username);
	  }
}


