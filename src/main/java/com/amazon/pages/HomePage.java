package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.network.model.SignedExchangeHeader;
import org.openqa.selenium.support.FindBy;

import com.amazon.utils.PageObjects;

public class HomePage extends PageObjects {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"nav-link-accountList\"]/div")
	WebElement signin;
	@FindBy(xpath="//*[@id=\"nav-cart-count-container\"]")
	WebElement cart;
	
	
	public SigninUsername signinClick ()
	{
		signin.click();
		return new SigninUsername(driver);
	}
	public CartPage gotoCart() {
		cart.click();
		return new CartPage(driver);
	}

}
