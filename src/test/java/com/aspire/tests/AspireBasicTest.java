package com.aspire.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aspire.pages.CreateManufacturingOrderPage;
import com.aspire.pages.CreateProductPage;
import com.aspire.pages.InventoryPage;
import com.aspire.pages.LoginPage;
import com.aspire.pages.ManufacturingOrder;
import com.aspire.pages.ManufacturingPage;
import com.aspire.pages.ProductDisplayPage;
import com.aspire.pages.ProductPage;
import com.aspire.pages.UpdateQuantityPage;
import com.aspire.pages.UserHome;
import com.aspire.utils.Util;

public class AspireBasicTest extends Util {

	public UserHome userHome;
	public InventoryPage inventoryPage;
	public ProductPage productPage;
	public CreateProductPage createProductPage;
	public UpdateQuantityPage updateQuantityPage;
	public ManufacturingPage manufacturingPage;
	public CreateManufacturingOrderPage createManufacturingOrderPage;
	public ProductDisplayPage productDisplayPage;
	public ManufacturingOrder manufacturingOrder;

	@BeforeClass
	public void loginToSite() {
		LoginPage hm = new LoginPage(driver);
		hm.sendUsernamePassword(p.getProperty("username"), p.getProperty("password"));
		userHome = hm.submitClick();
		normalWait(5);
	}

	@Test(priority = 0)
	public void createProduct() throws InterruptedException {
		inventoryPage = userHome.inventoryClick();
		productPage = inventoryPage.productClick();
		createProductPage = productPage.createButtonClick();
		productDisplayPage = createProductPage.createProduct(p.getProperty("productname"));
		Thread.sleep(2000);
		assertTrue(productDisplayPage.isProductCreated(p.getProperty("productname")));
	}

	@Test(priority = 1)
	public void updateProductQuantity() throws InterruptedException {
		normalWait(5);
		updateQuantityPage = productDisplayPage.updateQuantity();
		Thread.sleep(1000);
		updateQuantityPage.updateQuantity(p.getProperty("changeQuantity"));
		Thread.sleep(1000);
		assertTrue(updateQuantityPage.isInventoryUpdated());
	}

	@Test(priority = 2)
	public void validateManufacturingOrder() throws InterruptedException {
		userHome = inventoryPage.returnHome();
		manufacturingPage = userHome.manufacturingClick();
		createManufacturingOrderPage = manufacturingPage.manufacturingCreateButtonClick();
		manufacturingOrder = createManufacturingOrderPage.manufacturingOrderCreate(p.getProperty("productname"));
		manufacturingOrder.confirmOrder();
		Thread.sleep(200);
		assertTrue(manufacturingOrder.assertOrder());
		
	}

}
