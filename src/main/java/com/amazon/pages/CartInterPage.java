package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.amazon.utils.PageObjects;

public class CartInterPage extends PageObjects {

	public CartInterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(id="hlb-view-cart-announce")
	WebElement cartButton;
	
	public CartPage goToCart() {
		cartButton.click();
		return new CartPage(driver);
	}
}
