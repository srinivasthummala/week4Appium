package com.flipkart.pages;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class ProductdetailsTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "txt.product.name.product.details.page")
	private QAFWebElement txtProductNameProductDetailsPage;
	@FindBy(locator = "txt.product.price.product.details.page")
	private QAFWebElement txtProductPriceProductDetailsPage;
	@FindBy(locator = "btn.add.to.cart.product.details.page")
	private QAFWebElement btnAddToCart;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getTxtProductNameProductDetailsPage() {
		return txtProductNameProductDetailsPage;
	}
	public QAFWebElement getBtnAddToCartProductDetailsPage() {
		return btnAddToCart;
	}

	public QAFWebElement getTxtProductPriceProductDetailsPage() {
		QAFExtendedWebElement productPrice = new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("txt.product.price.product.details.page"), "25,900"));
		return productPrice;
	}
	
	public void addProductToCart() {
		Reporter.log("item is adding to cart");
		btnAddToCart.click();
	}

}
