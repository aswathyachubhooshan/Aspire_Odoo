package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.amazon.utils.PageObjects;

public class UserHome extends PageObjects {

	public UserHome(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBox;
	@FindBy(id="nav-search-submit-button")
	WebElement searchButton;
	
	public SearchList search(String text) {
		searchBox.sendKeys(text);
		searchButton.click();
		return new SearchList(driver);
	}
}
