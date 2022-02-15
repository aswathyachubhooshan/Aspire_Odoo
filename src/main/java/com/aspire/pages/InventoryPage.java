package com.aspire.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aspire.utils.PageObjects;

public class InventoryPage extends PageObjects {

	public InventoryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//button/span[contains(text(),'Products')]")
	WebElement productsMain;
	@FindBy(xpath = "//a[contains(text(),'Products')]")
	WebElement products;
	@FindBy(xpath = "//a[@title='Home menu']")
	WebElement ApplicationIcon;

	public ProductPage productClick() {
		productsMain.click();
		explicitWait("//a[contains(text(),'Products')]");
		products.click();
		return new ProductPage(driver);
	}

	public UserHome returnHome() {
		ApplicationIcon.click();
		return new UserHome(driver);

	}
}