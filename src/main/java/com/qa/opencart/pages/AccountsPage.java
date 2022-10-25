package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By logoutLink=By.linkText("Logout");
	private By search= By.name("search");
	private By searchBtn=By.cssSelector("div#search button");
	private By accntSectionHeaders=By.cssSelector("div#content h2");
	
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
	}
	
	public String getAccPageTitle() {
		String AccPageTitle = eleUtil.waitForTitleIs(AppConstants.DEFAULT_TIME_OUT, AppConstants.ACCOUNT_PAGE_TITLE);
		System.out.println("Account Page Title: "+ AccPageTitle);
		return AccPageTitle;
	}
	public boolean getAccountPageurl() {
		String url=eleUtil.waitForUrlContains(AppConstants.DEFAULT_TIME_OUT, AppConstants.ACCOUNT_PAGE_URL_PARAM);
		System.out.println("Account page url: "+ url);
		if (url.contains(AppConstants.ACCOUNT_PAGE_URL_PARAM)) {
			return true;
		}
		return false;
	}
	
	public boolean isLogoutLinkExist() {
		return eleUtil.doEleIsDisplayed(logoutLink);
	}
	
	public boolean isSearchExist() {
		return eleUtil.doEleIsDisplayed(search);
	}
	
	public SearchResultsPage performSearch(String searchKey) {
		System.out.println("Product name is: "+ searchKey);
		if (isSearchExist()) {
			eleUtil.doSendKeys(search, searchKey);
			eleUtil.doClick(searchBtn);
			return new SearchResultsPage(driver);
		}
		else
			System.out.println("search element not found on the page...");
		return null;
	}
	
	public ArrayList<String> getAccountPageHeaders() {

		List<WebElement> accHeaders= eleUtil.waitForElementsToBeVisible(accntSectionHeaders, 
														AppConstants.DEFAULT_LARGE_TIME_OUT);
		System.out.println("Total Section Headers: "+accHeaders.size());
		ArrayList<String> headerText=new ArrayList<String>();//blank arraylist
		for (WebElement e: accHeaders) {
			String text=e.getText();
			headerText.add(text);
		}
		return headerText;
		
	}
}
