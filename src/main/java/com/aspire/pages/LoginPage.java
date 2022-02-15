package com.aspire.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aspire.utils.PageObjects;

public class LoginPage extends PageObjects {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@placeholder='Email']")
	WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	
	public void sendUsernamePassword(String user, String pass)
	{
		username.sendKeys(user);
		password.sendKeys(pass);
		
	}
	
	public  UserHome submitClick() {
		submit.click();
		return new UserHome(driver);
	}

}
