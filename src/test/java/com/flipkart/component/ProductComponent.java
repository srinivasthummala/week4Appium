package com.flipkart.component;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class ProductComponent extends QAFWebComponent {

	public ProductComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

	@FindBy(locator = "searchpage.product.list.product.name")
	private QAFWebElement searchpageProductListProductName;
	@FindBy(locator = "searchpage.product.list.product.price")
	private QAFWebElement searchpageProductListProductPrice;
	
	public QAFWebElement getSearchpageProductListProductName() {
		return searchpageProductListProductName;
	}

	public QAFWebElement getSearchpageProductListProductPrice() {
		return searchpageProductListProductPrice;
	}
}
