package com.flipkart.pages;

import java.util.HashMap;

import com.flipkart.bean.ProductBean;
import com.qmetry.qaf.automation.core.ConfigurationManager;

public class MyPage {
	
	public HashMap<String, String> hashMapData(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("productName", "apple");
		map.put("productPrice", "25000");
		ConfigurationManager.getBundle().setProperty("product.map", map);
		return map;
		
	}
	
	public void beanData() {
		ProductBean bean = new ProductBean();
		bean.setProductName("ipad");
		bean.setPrice("5000");
		ConfigurationManager.getBundle().setProperty("product.bean", bean);
		//return bean;
	}

}
