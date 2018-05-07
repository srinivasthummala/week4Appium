package com.flipkart.pages;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class CartscreenTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "txt.productname.cartpage")
	private QAFWebElement txtProductnameCartpage;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getTxtProductnameCartpage() {
		return txtProductnameCartpage;
	}
	
	public QAFWebElement getProductNameCatPage(String name) {
		QAFExtendedWebElement cartPageProductName = new QAFExtendedWebElement(
				String.format(ConfigurationManager.getBundle().getString("txt.productname.cartpage"), name));
		return cartPageProductName;
	}

}
