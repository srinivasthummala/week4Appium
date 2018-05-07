/**
 * 
 */
package com.flipkart.steps;

import java.util.HashMap;

import com.flipkart.bean.ProductBean;
import com.flipkart.pages.MyPage;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStep;

/**
 * @author Srinivas.Thummala
 */
public class Steps {

	MyPage page = new MyPage();
	
	
	
	@QAFTestStep(description = "user printing {0}")
	public void userPrinting(String str0) {
		System.out.println(str0);
	}

	
	@QAFTestStep(description = "user gathering map data")
	public void userGatheringMapData() {
		page.hashMapData();
		@SuppressWarnings("unchecked")
		HashMap<String, String> map = (HashMap<String, String>) ConfigurationManager.getBundle().getProperty("product.map");
		System.out.println(map.get("productName"));

	}

	
	@QAFTestStep(description = "user gathering bean data")
	public void userGatheringBeanData() {
		page.beanData();
		ProductBean dataBean = (ProductBean)ConfigurationManager.getBundle().getProperty("product.bean");
		System.out.println(dataBean.getProductName());

	}

	
	@QAFTestStep(description = "user display map data")
	public void userDisplayMapData() {
		@SuppressWarnings("unchecked")
		HashMap<String, String> map = (HashMap<String, String>) ConfigurationManager.getBundle().getProperty("product.map");

		System.out.println(map.get("productName"));
	}

	
	@QAFTestStep(description = "user display bean data")
	public void userDisplayBeanData() {
		ProductBean bean = (ProductBean)ConfigurationManager.getBundle().getProperty("product.bean");
		System.out.println(bean.getProductName());
	}

}
