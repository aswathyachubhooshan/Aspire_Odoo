package com.amazon.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.pages.CartInterPage;
import com.amazon.pages.CartPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.ItemDetailsPage;
import com.amazon.pages.SearchList;
import com.amazon.pages.SigninPassword;
import com.amazon.pages.SigninUsername;
import com.amazon.pages.UserHome;
import com.amazon.utils.Util;

public class CartTest extends Util {

	public UserHome userHome;
	public SearchList searchList;
	public ItemDetailsPage itemDetail;
	public CartInterPage cartInterPage;
	public CartPage cartPage;
	public CartPage cartP;

	@BeforeClass
	public void loginToSite() {
		HomePage hm = new HomePage(driver);
		SigninUsername suser = hm.signinClick();
		SigninPassword spass = suser.enterUsername(p.getProperty("username"));
		userHome = spass.loginToHome(p.getProperty("password"));
	}

	@Test(priority = 0)
	public void searchAndVerifyProduct() {
		searchList = userHome.search(p.getProperty("searchText"));
		assertTrue(searchList.validateItemList(p.getProperty("searchText")));
	}

	@Test(priority = 1)
	public void addItemToCart() {
		itemDetail = searchList.selectItem();
		cartInterPage = itemDetail.addToCart();
		cartPage = cartInterPage.goToCart();
		normalWait(5);
		assertTrue(cartPage.verifyItemHeading(p.getProperty("searchText")));
	}

	@Test(priority = 2)
	public void itemQuantityTest() {
		normalWait(5);
		cartPage.changequantity(Integer.parseInt(p.getProperty("changeQuantity")));
		assertTrue(cartPage.verifyPrice());
	}

	@Test(priority = 3)
	public void deleteItemTest() {
		normalWait(10);
		cartPage.deleteItems();
		cartPage.verifyEmptyCart();
	}

}
