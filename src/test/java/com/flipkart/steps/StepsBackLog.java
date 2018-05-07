/**
 * 
 */
package com.flipkart.steps;

import java.util.HashMap;

import org.hamcrest.Matchers;

import com.flipkart.pages.CartscreenTestPage;
import com.flipkart.pages.HomescreenTestPage;
import com.flipkart.pages.ProductdetailsTestPage;
import com.flipkart.pages.SearchscreenTestPage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;

/**
 * @author Srinivas.Thummala
 */
public class StepsBackLog {

	HomescreenTestPage homePage = new HomescreenTestPage();
	SearchscreenTestPage searchPage = new SearchscreenTestPage();
	HashMap<String, String> map;
	ProductdetailsTestPage productDetails = new ProductdetailsTestPage();
	CartscreenTestPage cartPage = new CartscreenTestPage();

	@QAFTestStep(description = "user open Flipkart appliaction")
	public void userOpenFlipkartAppliaction() {
		Reporter.log("launching application");
		homePage.launchApp();
	}

	@QAFTestStep(description = "user allow any authentication/advertisement if it comes")
	public void userAllowAccessToContacts() {
		homePage.allowAccessContacts();

	}

	@QAFTestStep(description = "user skips login screen by clicking cancel button")
	public void userSkipsLoginScreenByClickingCancelButton() {
		homePage.clickCancelLogin();
	}

	@QAFTestStep(description = "user search for {productName} and select IPad from search results")
	public void userSearchFor(String productName) {
		homePage.searchForProduct(productName);
	}

	@QAFTestStep(description = "user logs product name and price")
	public void userLogsProductNameAndPrice() {
		searchPage.allowDeviceLocation();
		searchPage.getProductNameAndPrice();
	}

	@QAFTestStep(description = "User select Lowest Price Item From List")
	public String userSelectLowestPriceItemFromList() {
		searchPage.allowDeviceLocation();
		map = searchPage.selectLowestPriceItem();
		return map.get("productName");
	}

	@QAFTestStep(description = "user verify product detail page with {productDetails}")
	public void userVerifyProductDetailPage(String name) {
		//Reporter.log(productDetails.getTxtProductNameProductDetailsPage().getAttribute("text"));
		Validator.verifyThat(
				productDetails.getTxtProductNameProductDetailsPage().getAttribute("text"), Matchers.containsString(name));
	}

	
	@QAFTestStep(description = "user adds item to cart and navigate to cart page")
	public void userAddsItemToCartAndNavigateToCartPage() {
		productDetails.addProductToCart();
		homePage.navigateToCart();
		Reporter.log("navigated to cart page");

	}

	
	@QAFTestStep(description = "user verify product has been added in cart with {productName}")
	public void userVerifyProductHasBeenAddedInCart(String name) {
		Reporter.log("verifying cart page item with product name: \" "+name+" \"" );
		cartPage.getProductNameCatPage(name).isPresent();
		cartPage.getProductNameCatPage(name).verifyVisible();
		Reporter.log("cart page verified with added product name");
	}

}
