package com.flipkart.bean;

import com.qmetry.qaf.automation.data.BaseDataBean;

public class ProductBean extends BaseDataBean{
	String productName;
	String price;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
	

}
