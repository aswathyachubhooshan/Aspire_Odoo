package com.amazon.pages;

import java.util.List;

import javax.swing.JScrollBar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.utils.PageObjects;

public class CartPage extends PageObjects {
	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	Integer itemQuantity = 0;
	@FindBy(xpath = "//span[@class=\"a-truncate-cut\"]")
	WebElement itemHeading;
	@FindBy(id = "quantity")
	WebElement Itemquantity;
	@FindBy(name = "quantityBox")
	WebElement qtyTextBox;
	@FindBy(xpath = "//*[@class=\"sc-list-item-content\"]/div[1]/div[2]/p/span")
	WebElement unitPrice;
	@FindBy(xpath = "//div[1][@data-name=\"Subtotals\"]/span[2]/span")
	WebElement totalPrice;
	@FindBy(xpath = "//input[@data-action=\"delete\"]")
	WebElement deleteItem;
	@FindBy(xpath = "//*[@id=\"sc-active-cart\"]/div/div[1]/div/h1")
	WebElement emptyCart;
	@FindBy(xpath = "//*[@id=\"nav-cart-count-container\"]")
	WebElement cart;

	public boolean verifyItemHeading(String item) {
		return itemHeading.getText().toLowerCase().contains(item.toLowerCase()) ? true : false;
	}

	public void changequantity(Integer qty) {
		itemQuantity = qty;
		Select qnty = new Select(Itemquantity);
		qnty.selectByVisibleText("10+");
		qtyTextBox.sendKeys(qty.toString());
		qtyTextBox.sendKeys(Keys.ENTER);
	}

	public boolean verifyPrice() {
		cart.click();
		WebElement totalPrice1 = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(totalPrice));
		return (Float.parseFloat(totalPrice1.getText().replaceAll("[^0-9]", "")) == Float
				.parseFloat(unitPrice.getText().replaceAll("[^0-9]", "")) * itemQuantity) ? true : false;
	}

	public void deleteItems() {
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(deleteItem));
		if (deleteItem.isDisplayed())
			deleteItem.click();
	}

	public boolean verifyEmptyCart() {
		return emptyCart.getText().contains("Your Amazon Cart is empty.") ? true : false;
	}

	public CartPage gotoCart() {
		cart.click();
		return new CartPage(driver);
	}
}
