package com.aspire.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aspire.utils.PageObjects;

public class CreateProductPage extends PageObjects {

	public CreateProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@name='name']")
	WebElement productsName;
	@FindBy(xpath = "//button[@title='Save record']")
	WebElement SaveRecord;
	

	public ProductDisplayPage createProduct(String prodName) {
		explicitWait("//input[@name='name']");
		productsName.sendKeys(prodName);
		SaveRecord.click();
		return new ProductDisplayPage(driver);
	}

}