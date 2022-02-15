package com.aspire.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aspire.utils.PageObjects;

public class ProductDisplayPage extends PageObjects {

	public ProductDisplayPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//button/span[contains(text(),'Update Quantity')]")
	WebElement updateQuantity;
	@FindBy(xpath = "//div[@class='d-flex']/span")
	WebElement productName;
	
	
	public UpdateQuantityPage updateQuantity() {
		explicitWait("//button/span[contains(text(),'Update Quantity')]");
		updateQuantity.click();
		return new UpdateQuantityPage(driver);
	}
	public boolean isProductCreated(String prodName) {
		return productName.getText().equalsIgnoreCase(prodName)?true:false;
	}
}
