package com.aspire.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aspire.utils.PageObjects;

public class ManufacturingPage extends PageObjects {

	public ManufacturingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	WebElement createButton;
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement saveButton;
	
	
	public CreateManufacturingOrderPage manufacturingCreateButtonClick()
	{
		createButton.click();
		return new CreateManufacturingOrderPage(driver);
	}

}
