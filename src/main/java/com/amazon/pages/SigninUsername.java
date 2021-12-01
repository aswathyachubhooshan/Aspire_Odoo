package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.amazon.utils.PageObjects;

public class SigninUsername extends PageObjects {

	public SigninUsername(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id ="ap_email")
	WebElement username;
	
	public SigninPassword enterUsername(String user){
		username.sendKeys(user);
		username.submit();
		return new SigninPassword(driver);
	}
  
}
