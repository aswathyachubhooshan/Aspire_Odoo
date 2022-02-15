package com.aspire.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aspire.utils.PageObjects;

public class UserHome extends PageObjects {

	public UserHome(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//a[@id='result_app_1']")
	WebElement inventory;
	
	@FindBy(xpath = "//a[@id='result_app_2']")
	WebElement manufacturing;
	
	public InventoryPage inventoryClick()
	{
		explicitWait("//a[@id='result_app_1']");
		inventory.click();
		return new InventoryPage(driver);
	}
	public ManufacturingPage manufacturingClick()
	{
		manufacturing.click();
		return new ManufacturingPage(driver);
	}
	
}
