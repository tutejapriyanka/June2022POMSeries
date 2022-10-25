package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public ProductInfoPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
	}

	public String getProductHeaderText() {
		String cssSelector="div#content h1";
		String prodHeader=eleUtil.doGetText(By.cssSelector(cssSelector));
		return prodHeader;
	}
}
