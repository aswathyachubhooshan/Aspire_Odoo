package com.aspire.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjects {
	protected WebDriver driver;
	public WebDriverWait exwait;

	public PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void actionScroll(WebElement ele) {
		Actions action=new Actions(driver);
		while(ele.isDisplayed()) {
			action.keyDown(ele, Keys.ARROW_DOWN).build().perform();
		}
	}
	
	@SuppressWarnings("deprecation")
	public void explicitWait(String xpath) {
		exwait=new WebDriverWait(driver,20);
		exwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	@SuppressWarnings("deprecation")
	public void explicitWaitClickable(WebElement element) {
		exwait=new WebDriverWait(driver,20);
		exwait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
