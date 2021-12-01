package com.amazon.pages;

import java.util.List;
import java.util.Set;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.amazon.utils.PageObjects;

public class SearchList extends PageObjects {

	public SearchList(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//h2/a[@class=\"a-link-normal a-text-normal\"]")
	List<WebElement> searchItems;
	
	public boolean validateItemList(String searchItem) {
		return searchItem.contains(searchItem)? true:false;
	}

	public ItemDetailsPage selectItem() {
		searchItems.get(0).click();
		Set<String> newWindow= driver.getWindowHandles();
		String current=driver.getWindowHandle();
		for(String s:newWindow)if(s!=current)driver.switchTo().window(s);
		return new ItemDetailsPage(driver);
	}
	
}
