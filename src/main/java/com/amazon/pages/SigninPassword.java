package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.amazon.utils.PageObjects;

public class SigninPassword extends PageObjects {

	public SigninPassword(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="ap_password")
	WebElement password;
	
	public UserHome loginToHome(String pass) {
		password.sendKeys(pass);
		password.submit();
		return new UserHome(driver);
	}

}
