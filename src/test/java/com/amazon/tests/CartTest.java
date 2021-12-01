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
import com.amazon.pages.LoginPage;
import com.amazon.pages.SearchList;
import com.amazon.pages.SigninPassword;
import com.amazon.pages.SigninUsername;
import com.amazon.pages.UserHome;
import com.amazon.utils.Util;

public class CartTest extends Util {
	
	UserHome userHome;
	SearchList searchList;
	ItemDetailsPage itemDetail;
	CartInterPage cartInterPage;
	CartPage cartPage;
	@BeforeClass
	public void loginToSite() {
		HomePage hm=new HomePage(driver);
		SigninUsername suser = hm.signinClick();
		SigninPassword spass = suser.enterUsername(p.getProperty("username"));
		userHome= spass.loginToHome(p.getProperty("password"));
	}
	
	@Test
	public void searchAndVerifyProduct() {
		searchList = userHome.search(p.getProperty("searchText"));
		assertTrue(searchList.validateItemList(p.getProperty("searchText")));
	}
	
	@Test
	public void addItemToCart() {
		itemDetail = searchList.selectItem();
		cartInterPage = itemDetail.addToCart();
		cartPage = cartInterPage.goToCart();
		assertTrue(cartPage.verifyItemHeading(p.getProperty("searchText")));
	}
	@Test
	public void itemQuantityTest() {
		cartPage.changequantity(Integer.parseInt(p.getProperty("changeQuantity")));
		assertTrue(cartPage.verifyPrice());
	}
	@Test
	public void deleteItemTest() {
		cartPage.deleteItems();
		cartPage.verifyEmptyCart();
	}
	
}
