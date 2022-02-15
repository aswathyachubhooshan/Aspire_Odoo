package com.aspire.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aspire.utils.PageObjects;

public class ProductPage extends PageObjects {

	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//button[@title='Create record']")
	WebElement createButton;
	@FindBy(xpath = "//input[@title='Search for records']")
	WebElement prodSearchBox;
	@FindBy(xpath = "//div[@class='oe_kanban_details']")
	WebElement prodBox;
	
	public CreateProductPage createButtonClick()
	{
		explicitWait("//button[@title='Create record']");
		createButton.click();
		return new CreateProductPage(driver);
	}
	public void searchProduct(String prodName) {
		prodSearchBox.click();
		prodSearchBox.sendKeys(prodName);
		prodSearchBox.sendKeys(Keys.ENTER);
	}
	
	
}
