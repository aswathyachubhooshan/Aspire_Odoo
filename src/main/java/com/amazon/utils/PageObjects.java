package com.amazon.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjects {
	protected WebDriver driver;

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
}
