package com.qa.luma.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.luma.base.BaseTest;
import com.qa.luma.utils.Constants;


public class CustomerHomePageTest extends BaseTest{
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeClass
	public void CustomerHomePageSetup() {
		customerLoginPage = mainpage.clickOnSigninLink();
		customerHomePage = customerLoginPage.login("jeet@gmail.com", "Jeet@123456");
	}
	
	@Test(priority = 1)
	public void CustomerHomePageTitleTest() {
		String title = customerHomePage.getPageTitle();
		Assert.assertTrue(title.equals(Constants.CUSTOMER_HOME_PAGE_TITLE));
	}
	
	@Test(priority = 2)
	public void promotionalProductListTest() {
		List<WebElement> products = customerHomePage.getPromotionalProductList();
		softAssert.assertEquals(products.size(), 6);
		System.out.println("--------------Promotional Product List--------------");
		for (WebElement e : products) {
			String link = e.getAttribute("href");
			System.out.println(link);
		}
		softAssert.assertAll();	
	}
	
	@Test(priority = 3)
	public void hotsellerProductListTest() {
		List<WebElement> products = customerHomePage.getPromotionalProductList();
		softAssert.assertEquals(products.size(), 6);
		System.out.println("--------------Hotseller Product List--------------");
		for (WebElement e : products) {
			String link = e.getAttribute("href");
			System.out.println(link);
		}
		softAssert.assertAll();	
	}
	
	
}
