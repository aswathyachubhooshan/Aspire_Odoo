package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.amazon.utils.PageObjects;

public class ItemDetailsPage extends PageObjects {

	public ItemDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(id="add-to-cart-button")
	WebElement addToCartButton;
	
	public CartInterPage addToCart() {
		addToCartButton.click();
		return new CartInterPage(driver);
	}
}
