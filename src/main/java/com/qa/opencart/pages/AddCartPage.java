package com.qa.opencart.pages;

import org.openqa.selenium.By;

public class AddCartPage {

	
	String name ="iMac";
	String price ="200$";
	
	By loc =By.id("loc");
	
	public void click() {
		System.out.println("Click --"+ loc);
	}
}
