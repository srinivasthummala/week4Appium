package com.flipkart.tests;


import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.flipkart.pages.CartscreenTestPage;
import com.flipkart.pages.HomescreenTestPage;
import com.flipkart.pages.ProductdetailsTestPage;
import com.flipkart.pages.SearchscreenTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Validator;

public class CartTest extends WebDriverTestCase {

	
	@Test
	public void setup() {
		HomescreenTestPage homePage = new HomescreenTestPage();
		homePage.launchApp();
		homePage.allowAccessContacts();
		homePage.clickCancelLogin();
		homePage.clickFlipkartSearch();
		homePage.searchForProduct("ipad");
		
		SearchscreenTestPage productListPage = new SearchscreenTestPage();
		productListPage.allowDeviceLocation();
		HashMap<String, String> map = productListPage.selectLowestPriceItem();
		
		ProductdetailsTestPage productDetailPage = new ProductdetailsTestPage();
		Validator.verifyThat(
				productDetailPage.getTxtProductNameProductDetailsPage().getAttribute("text"), Matchers.containsString(map.get("productName")));
		productDetailPage.addProductToCart();
		
		CartscreenTestPage cartPage = new CartscreenTestPage();
		//Validator.verifyThat(cartPage.getProductNameCatPage(map.get("productName")).isPresent());
		
		cartPage.getProductNameCatPage(map.get("productName")).isPresent();
		
	}
}
