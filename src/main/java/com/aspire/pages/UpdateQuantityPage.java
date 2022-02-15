package com.aspire.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aspire.utils.PageObjects;

public class UpdateQuantityPage extends PageObjects{

	public UpdateQuantityPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//button[contains(text(),'Create')]")
	WebElement createButton;
	
	@FindBy(xpath = "//input[@name='inventory_quantity']")
	WebElement inventoryQuantityTextBox;
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement saveButton;
	@FindBy(xpath = "//span[@name='inventory_quantity']")
	WebElement invQtyLabel;
	
	public void updateQuantity(String prodQuantity )
	{
		explicitWait("//button[contains(text(),'Create')]");
		createButton.click();
		explicitWait("//input[@name='inventory_quantity']");
		inventoryQuantityTextBox.click();
		inventoryQuantityTextBox.clear();
		inventoryQuantityTextBox.sendKeys(prodQuantity);
		saveButton.click();
	}
	public boolean isInventoryUpdated() {
		return Float.parseFloat(invQtyLabel.getText())>10.00?true:false;
	}
	
	
	
	
}

