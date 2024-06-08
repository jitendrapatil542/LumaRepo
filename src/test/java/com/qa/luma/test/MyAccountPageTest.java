package com.qa.luma.test;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.luma.base.BaseTest;
import com.qa.luma.utils.Constants;

public class MyAccountPageTest extends BaseTest{
	
	@BeforeClass
	public void MyAccountPageSetUp() {
		customerLoginPage = mainpage.clickOnSigninLink();
		customerHomePage = customerLoginPage.login("jeet@gmail.com", "Jeet@123456");
		myAccountPage = customerHomePage.homePageToMyAccountPage();
	}
	
	
	@Test(priority = 1)
	public void MyAccountPageTitleTest() {
		String title = myAccountPage.getPageTitle();
		Assert.assertEquals(title, Constants.MY_ACCOUNT_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void MyAccountPagesUBTitleTest() {
		String subTitle = myAccountPage.getTitle();
		Assert.assertEquals(subTitle, Constants.MY_ACCOUNT_PAGE_TITLE);
	}
	
	@Test(priority = 3)
	public void LoginAccNameTest() throws InterruptedException {
		Thread.sleep(6000);
		String userGreeting = myAccountPage.getLoginAccName();
		System.out.println("account name = "+userGreeting);
		Assert.assertTrue(userGreeting.contains("Jeet"));
	}
	
	@Test(priority = 4)
	public void NavigationPannelLinksCountTest() {
		List<WebElement> NavigationPannelList = myAccountPage.getNavigationPanelLinks();
		Assert.assertEquals(NavigationPannelList.size(), 7);
	}
	
	@Test(priority = 5)
	public void MyAccount_ContactInfoTest() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Map<String, String> contactinfo = myAccountPage.getContactinformation();
		softAssert.assertTrue(contactinfo.get("Name").equals("Jeet Patil"));
		softAssert.assertTrue(contactinfo.get("Email").equals("jeet@gmail.com"));
		softAssert.assertAll();
	}
	
	@Test(priority = 6)
	public void MyAccount_BillingAddressTest() throws InterruptedException {
		Thread.sleep(6000);
		String billingAddress = myAccountPage.getBillingAddress();
		Assert.assertEquals(billingAddress, "Jeet Patil,Self,001 My Flat,My Road,My Area,My City, Gujarat, 369852,India,T: <a href=\"tel:1234567890\">1234567890</a>,");
	}
	
	@Test(priority = 7)
	public void MyAccount_ShippingAddressTest() {
		String shippingAddress = myAccountPage.getBillingAddress();
		Assert.assertTrue(shippingAddress.equals("Jeet Patil,Self,001 My Flat,My Road,My Area,My City, Gujarat, 369852,India,T: <a href=\"tel:1234567890\">1234567890</a>,"));
	}
	
	
	
	
	}
