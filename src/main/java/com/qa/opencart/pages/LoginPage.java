package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. By locator

	private By emailid = By.id("input-email");
	private By password = By.id("input-password");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By logo = By.cssSelector("img[title='naveenopencart']");

	// 2. page Constructor

	public LoginPage(WebDriver driver) {// whenever any component wants to call login page method they have to create
		// an object of the login page class and the constructor will be called and we
		// are restricting the
		// constructor to give me the Webdriver driver otherwise the object can not be
		// created.

		System.out.println("login page constructor");
		this.driver = driver;// initialize the driver(private WebDriver driver)
		eleUtil = new ElementUtil(driver);
	}

	// 3. Page actions

	public String getLoginPageTitle() {
		String title = eleUtil.waitForTitleIs(AppConstants.DEFAULT_TIME_OUT, AppConstants.LOGIN_PAGE_TITLE);
		System.out.println("login page title:" + title);
		return title;
	}

	public boolean getLoginPageurl() {
		String url=eleUtil.waitForUrlContains(AppConstants.DEFAULT_TIME_OUT, AppConstants.LOGIN_PAGE_URL_PARAM);
		System.out.println("Login page url: " + url);
		if (url.contains(AppConstants.LOGIN_PAGE_URL_PARAM)) {
			return true;
		}
		return false;
	}

	public boolean isForgotPwdLinkExist() {
		return eleUtil.doEleIsDisplayed(forgotPwdLink);
		
	}

	public AccountsPage doLogin(String username, String pwd) {
		System.out.println("user credentials are : " + username + " " + pwd);
		eleUtil.doSendKeysWithWait(emailid,AppConstants.DEFAULT_LARGE_TIME_OUT, username);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		return new AccountsPage(driver);

	}
}
