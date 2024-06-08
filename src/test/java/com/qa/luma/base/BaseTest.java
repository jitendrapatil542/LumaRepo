package com.qa.luma.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.luma.factory.DriverFactory;
import com.qa.luma.pages.CreateAccountPage;
import com.qa.luma.pages.CustomerHomePage;
import com.qa.luma.pages.CustomerLoginPage;
import com.qa.luma.pages.MainPage;
import com.qa.luma.pages.MyAccountPage;

public class BaseTest {
	private WebDriver driver;
			DriverFactory dr;
	public static Properties prop;
	public static MainPage mainpage;
	public 	CreateAccountPage createAccPage;
	public 	MyAccountPage myAccountPage;
	public 	CustomerLoginPage customerLoginPage;
	public 	CustomerHomePage customerHomePage;
			
	@BeforeTest		
	public void setUp() {
		dr = new DriverFactory();
		prop = dr.init_prop();
		driver = dr.init_Browser(prop.getProperty("browser").trim(),prop);
		mainpage = new MainPage(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
