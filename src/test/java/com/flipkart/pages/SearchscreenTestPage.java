package com.flipkart.pages;

import java.util.HashMap;
import java.util.List;

import org.hamcrest.Matchers;

import com.flipkart.bean.ProductDeatilsBean;
import com.flipkart.component.ProductComponent;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;

public class SearchscreenTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

   
	ProductDeatilsBean bean = new ProductDeatilsBean();
	@FindBy(locator = "searchpage.access.device.location.allow.button")
	private QAFWebElement searchpageAccessDeviceLocationAllowButton;
	@FindBy(locator = "searchpage.displayed.product.list")
	private List<ProductComponent> searchpageDisplayedProductList;
	@FindBy(locator = "searchpage.sort.link")
	private QAFWebElement searchpageSortLink;
	@FindBy(locator = "searchpage.sort.low.high.option")
	private QAFWebElement searchpageSortOption;
	

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getSearchpageAccessDeviceLocationAllowButton() {
		return searchpageAccessDeviceLocationAllowButton;
	}

	public List<ProductComponent> getSearchpageDisplayedProductList() {
		return searchpageDisplayedProductList;
	}
	
	public void allowDeviceLocation() {
		Reporter.log("waiting for element Access device location ");
		getSearchpageAccessDeviceLocationAllowButton().waitForPresent();
		Reporter.log("allowing access for device location");
		getSearchpageAccessDeviceLocationAllowButton().click();
	}
	
	public void getProductNameAndPrice() {
		Validator.verifyThat(getSearchpageDisplayedProductList().size(), Matchers.greaterThan(0));
		Reporter.log("No. of products displayed : "+getSearchpageDisplayedProductList().size());
		for(ProductComponent result :searchpageDisplayedProductList ) {
			Reporter.log("product name : "+ result.getSearchpageProductListProductName().getAttribute("text"));
			Reporter.log("price : "+result.getSearchpageProductListProductPrice().getAttribute("text"));
		}
	}

	public void sortResultPage() {
		Reporter.log("waiting for element \"sort by\" ");
		searchpageSortLink.waitForPresent();
		Reporter.log("clicking on element \"sort by\"");
		searchpageSortLink.click();
		Reporter.log("waiting for sort option : "+searchpageSortOption.getText());
		searchpageSortOption.waitForPresent();
		Reporter.log("clicking on sort option : "+searchpageSortOption.getText());
		searchpageSortOption.click();
		
	}
	
	public  HashMap<String, String> selectLowestPriceItem() {
		sortResultPage();
		//getProductNameAndPrice();
		ProductComponent productComponent = searchpageDisplayedProductList.get(0);
		String productName = productComponent.getSearchpageProductListProductName().getAttribute("text");
		String productPrice = productComponent.getSearchpageProductListProductPrice().getAttribute("text");
		bean.setPrice(productPrice);
		bean.setProductName(productName);	
		ConfigurationManager.getBundle().setProperty("product.details", bean);
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("productName", productName);
		hashMap.put("productPrice", productPrice);
		Reporter.log("user selecting lowest price item : \""+productName+"\" and price : \""+productPrice+"\"");
		productComponent.getSearchpageProductListProductName().click();
		return hashMap;
	}

}
