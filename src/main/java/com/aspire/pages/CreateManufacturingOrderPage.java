package com.aspire.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aspire.utils.PageObjects;

public class CreateManufacturingOrderPage extends PageObjects {

	public CreateManufacturingOrderPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//div[@class='o_input_dropdown']/input[1]")
	WebElement productsSelect;
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement saveButton;

	public ManufacturingOrder manufacturingOrderCreate(String prodName) throws InterruptedException {
		productsSelect.click();
		productsSelect.sendKeys(prodName);
		Thread.sleep(2000);
		productsSelect.sendKeys(Keys.ENTER);
		saveButton.click();
		Thread.sleep(2000);
		return new ManufacturingOrder(driver);
	}
	
	

}
