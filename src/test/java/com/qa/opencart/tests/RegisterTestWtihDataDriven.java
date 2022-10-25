package com.qa.opencart.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterTestWtihDataDriven {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
	}

	@DataProvider
	public Object[][] registerTestData() {
		return new Object[][] {
			{"priyanka","tuteja","priyanka@123.com","1234556","1234"},
			{"mudit","chahal","mudit@123.com","1234556","1234"},
			{"ram","kashyap","ram@123.com","1234556","1234"},
			{"seeta","methali","seeta@123.com","1234556","1234"},
			{"best","coder","coder@123.com","1234556","1234"},
		};
	}
	@Test(dataProvider="registerTestData")
	public void RegisterTest(String fname, String lname, String email, String phn,String pwd) {
		Assert.assertEquals(doregister(fname,lname,email,phn,pwd),true);
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(39));
//		wait.until(ExpectedConditions.urlToBe("https://naveenautomationlabs.com/opencart/index.php?route=account/register"));
		//Assert.assertEquals((wait.until(ExpectedConditions.urlToBe("https://naveenautomationlabs.com/opencart/index.php?route=account/register"))),true);
		//driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
	}
	
	public boolean doregister(String fname, String lname, String email, String phn,String pwd) {
		driver.findElement(By.id("input-firstname")).clear();
		driver.findElement(By.id("input-firstname")).sendKeys(fname);
		driver.findElement(By.id("input-lastname")).clear();
		driver.findElement(By.id("input-lastname")).sendKeys(lname);
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-telephone")).clear();
		driver.findElement(By.id("input-telephone")).sendKeys(phn);
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(pwd);
		driver.findElement(By.id("input-confirm")).clear();
		driver.findElement(By.id("input-confirm")).sendKeys(pwd);
//		boolean check=driver.findElement(By.xpath("//input[@name=\"agree\"]")).isDisplayed();
//		System.out.println(check);
		driver.findElement(By.xpath("//input[@name=\"agree\"]")).click();
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		return driver.findElement(By.tagName("h1")).isDisplayed();		
	}
	
	
	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}

	
}
