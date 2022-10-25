package com.qa.opencart.constants;

import java.util.Arrays;
import java.util.List;

public class AppConstants {
	
	public static final int DEFAULT_TIME_OUT=5;
	
	public static final int DEFAULT_LARGE_TIME_OUT=10;
	
	public static final String LOGIN_PAGE_TITLE="Account Login";
	
	public static final String ACCOUNT_PAGE_TITLE="My Account";
	
	public static final String LOGIN_PAGE_URL_PARAM="route=account/login";
	
	public static final String ACCOUNT_PAGE_URL_PARAM="route=account/account";
	
	public static final List<String>EXP_ACCOUNT_PAGE_SEC_HEADERS=
									Arrays.asList("My Account", "My Orders", 
													"My Affiliate Account", "Newsletter");

}
