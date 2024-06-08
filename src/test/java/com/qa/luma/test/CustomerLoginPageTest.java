package com.qa.luma.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.luma.base.BaseTest;
import com.qa.luma.pages.MainPage;
import com.qa.luma.utils.Constants;

public class CustomerLoginPageTest extends BaseTest{
	
	@BeforeClass
	public void CustomerLoginPageSetUp() {
		customerLoginPage = mainpage.clickOnSigninLink();
		
	}
	
	@Test (priority = 1)
	public void CustomerLoginPageTitleTest() {
		String title = customerLoginPage.getPageTitle();
		Assert.assertEquals(title, Constants.CUSTOMER_LOGIN_PAGE_TITLE);
	}
	
	@Test (priority = 2)
	public void CustomerLoginPageSubTitleTest() {
		String subtitle = customerLoginPage.getTitle();
		Assert.assertEquals(subtitle, Constants.CUSTOMER_LOGIN_PAGE_TITLE);
	}
	
	@Test (priority = 3)
	public void ExistanceOfForgotPasswordLink() {
		boolean result = customerLoginPage.existanceOfForgotYourPasswordLink();
		Assert.assertTrue(result);
	}
	
	@Test (priority = 4)
	public void CustomerLoginTest() throws InterruptedException {
		customerHomePage = customerLoginPage.login(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		String userName = customerHomePage.getLoginAccName();
		Assert.assertTrue(userName.contains(prop.getProperty("accName")));
	}
}
