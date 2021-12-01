package com.amazon.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.amazon.utils.PageObjects;

public class CartPage extends PageObjects {
	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	Integer itemQuantity=0;
	@FindBy(xpath="//span[@class=\"a-truncate-full a-offscreen\"]")
	WebElement itemHeading;
	@FindBy(id="quantity")
	WebElement Itemquantity;
	@FindBy(name="quantityBox")
	WebElement qtyTextBox;
	@FindBy(xpath="//*[@class=\"sc-list-item-content\"]/div[1]/div[2]/p/span")
	WebElement unitPrice;
	@FindBy(xpath="//*[@data-name=\"Subtotals\"]/span/span")
	WebElement totalPrice;
	@FindBy(xpath="//input[@data-action=\"delete\"]")
	List<WebElement> deleteItem;
	@FindBy(xpath="//*[@id=\"sc-active-cart\"]/div/div[1]/div/h1")
	WebElement emptyCart;
	@FindBy(xpath="//*[@id=\"nav-cart-count-container\"]")
	WebElement cart;
	
	public boolean verifyItemHeading(String item) {
		return itemHeading.getText().contains(item)?true:false;
	}
	public void changequantity(Integer qty) {
		itemQuantity=qty;
		Select qnty = new Select(Itemquantity);
		qnty.selectByVisibleText("10+");
		qtyTextBox.sendKeys(qty.toString());
		qtyTextBox.sendKeys(Keys.ENTER);
	}
	public boolean verifyPrice() {
		return (Integer.parseInt(totalPrice.getText())==Integer.parseInt(unitPrice.getText())*itemQuantity)? true:false;	
	}
	public void deleteItems() {
		if(!(deleteItem.isEmpty())){
		for(WebElement i:deleteItem)i.click();
		}
	}
	public boolean verifyEmptyCart() {
		return emptyCart.getText().contains("Your Amazon Cart is empty.")?true:false;
	}
	public CartPage gotoCart() {
		cart.click();
		return new CartPage(driver);
	}
}
