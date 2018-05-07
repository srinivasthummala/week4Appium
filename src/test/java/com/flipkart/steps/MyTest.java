package com.flipkart.steps;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.flipkart.bean.ProductBean;
import com.flipkart.pages.MyPage;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.util.Reporter;

public class MyTest {
	
	MyPage page = new MyPage();
	HashMap<String, String> map;
	
	
	@Test
	public void testBean() {
		//bean=page.beanData();
		ProductBean bean = (ProductBean) ConfigurationManager.getBundle().getProperty("product.bean");
		Reporter.log(bean.getProductName());
		System.out.println(bean.getProductName());
			
	}
	
	@Test
	public void testMap() {
		map=page.hashMapData();
		Reporter.log(map.get("productName"));
		System.out.println(map.get("productName"));
		
	}
	@Test
	public void test() {
		 ProductBean bean = (ProductBean) ConfigurationManager.getBundle().getProperty("product.bean");

		System.out.println(bean.getProductName());
		System.out.println(map.get("productName"));
		
	}
	
	

}
