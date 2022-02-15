package com.aspire.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aspire.utils.PageObjects;

public class ManufacturingOrder extends PageObjects {

	public ManufacturingOrder(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//button/span[contains(text(),'Confirm')]")
	WebElement confirmButton;
	@FindBy(xpath = "//button[@class='btn btn-primary']/span[contains(text(),'Mark as Done')]")
	WebElement markAsDoneButton;
	@FindBy(xpath = "//button/span[contains(text(),'Ok')]")
	WebElement okButton;
	@FindBy(css = " footer > button.btn.btn-primary")
	WebElement applyButton;
	@FindBy(xpath = "//div[@name='state']/button[1]")
	WebElement doneButton;

	public void confirmOrder() throws InterruptedException {
		explicitWaitClickable(confirmButton);
		confirmButton.click();
		explicitWaitClickable(markAsDoneButton);
		markAsDoneButton.click();
		explicitWaitClickable(okButton);
		if(okButton.isDisplayed()) okButton.click();
		Thread.sleep(5000);
		explicitWaitClickable(applyButton);
		if(applyButton.isDisplayed()) applyButton.click();
		Thread.sleep(2000);
	}
	public boolean assertOrder() {
		System.out.println(doneButton.getAttribute("title"));
		return doneButton.getAttribute("title").equalsIgnoreCase("Current state")?true:false;
	}
}
