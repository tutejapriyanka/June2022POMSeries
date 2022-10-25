package com.qa.opencart.tests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;


public class AccountsPageTest extends BaseTest {
	
	
	@BeforeClass
	public void accSetup() {
		accPage=LoginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void accountPageTitleTest() {
		String actualtitle=accPage.getAccPageTitle();
		Assert.assertEquals(actualtitle, AppConstants.ACCOUNT_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void accPageUrlTest() {
		Assert.assertTrue(accPage.getAccountPageurl());
	}
	
	@Test(priority=3)
	public void searchExistTest() {
		Assert.assertTrue(accPage.isSearchExist());
	}

	@Test(priority=4)
	public void logoutLinkExistTest() {
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	
	@Test(priority=5)
	public void accPageHeadersTest () {
		ArrayList<String> actHeadersList=accPage.getAccountPageHeaders();
		System.out.println("Actual Header List: "+ actHeadersList);
		Assert.assertEquals(actHeadersList,AppConstants.EXP_ACCOUNT_PAGE_SEC_HEADERS );
	}
	
	
	@DataProvider
	public Object[][] searchData() {
		return new Object[][] {
							{"Macbook"},
							{"iMac"},
							{"Samsung"}
							};
		
	}
	
	@Test(priority=6,dataProvider="searchData")
	public void searchCheckTest(String searchKey) {
		 searchResultsPage=accPage.performSearch(searchKey);
		Assert.assertTrue(searchResultsPage.isSearchSuccessful());
	}
	
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
							{"Macbook","MacBook Pro"},
							{"Macbook","MacBook Air"},
							{"iMac","iMac"},
							{"Samsung","Samsung Galaxy Tab 10.1"},
							{"Samsung","Samsung SyncMaster 941BW"}
							};
		
		
	}
	
	
	@Test(priority=7,dataProvider="getProductData")
	public void searchTest(String searchKey, String mainProductName) {
		 searchResultsPage=accPage.performSearch(searchKey);
		if (searchResultsPage.isSearchSuccessful()) {
			productInfoPage=searchResultsPage.selectProduct(mainProductName);
			String actualProdHeader=productInfoPage.getProductHeaderText();
			System.out.println("Product Header is: "+ actualProdHeader);
			Assert.assertEquals(actualProdHeader,mainProductName);
		}
	}
}



