package com.flipkart.pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class HomescreenTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "flipkart.allow.contacts.id")
	private QAFWebElement flipkartAllowContactsId;
	@FindBy(locator = "flipkart.search.link")
	private QAFWebElement flipkartSearchLink;
	@FindBy(locator = "flipkart.close.login.button")
	private QAFWebElement flipkartCancelLogin;
	@FindBy(locator = "flipkart.side.menu.button")
	private QAFWebElement flipkartSidePanelButton;
	@FindBy(locator = "flipkart.select.menu.sidepanel")
	private QAFWebElement selectItemFromSidePanel;
	@FindBy(locator = "flipkart.search.products.input")
	private QAFWebElement flipkartSearch;
	@FindBy(locator = "flipkart.search.send.input")
	private QAFWebElement flipkartSearchSendInput;
	@FindBy(locator = "flipkart.search.item.select.link")
	private QAFWebElement flipkartSearchedProductSelect;
	@FindBy(locator = "btn.cart.homepage")
	private QAFWebElement btnCart;
	
	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
		
	}

	public QAFWebElement getFlipkartAllowContactsId() {
		return flipkartAllowContactsId;
	}
	
	public QAFWebElement getFlipkartSearchLink() {
		return flipkartSearchLink;
	}
	
	public QAFWebElement getsearchForProduct() {
		return flipkartSearch;
	}
	public void launchApp() {
		driver.get("/");
	}
	
	public void allowAccessContacts() {
		Reporter.log("waiting for element :"+flipkartAllowContactsId.getText());
		flipkartAllowContactsId.waitForVisible();
		Reporter.log("clicking on element: "+flipkartAllowContactsId.getText());
		flipkartAllowContactsId.click();
	}
	public void clickCancelLogin() {
		Reporter.log("user skipping login screen");
		flipkartCancelLogin.waitForVisible();
		flipkartCancelLogin.click();
		Reporter.log("user skipped login");

	}
	
	public void clickFlipkartSearch() {
		Reporter.log("waiting for element :"+flipkartSearchLink.getText());
		flipkartSearchLink.waitForVisible();
		Reporter.log("clicking on element: "+flipkartSearchLink.getText());
		flipkartSearchLink.click();
	}
			
	public void searchForProduct(String productName) {
		Reporter.log("waiting for element search field");
		flipkartSearch.waitForVisible();
		Reporter.log("clicking on element search field");
		flipkartSearch.click();
		flipkartSearchSendInput.waitForVisible();
		Reporter.log("sending text to search field");
		flipkartSearchSendInput.sendKeys(productName);
		flipkartSearchedProductSelect.waitForPresent();
		Reporter.log("clicking on  search item");
		flipkartSearchedProductSelect.click();
		
	}
	
	public void navigateToCart() {
		btnCart.waitForPresent();
		Reporter.log("clicking on cart button");
		btnCart.click();
	}
	


}
