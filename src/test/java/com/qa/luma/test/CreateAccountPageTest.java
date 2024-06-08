package com.qa.luma.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.luma.base.BaseTest;
import com.qa.luma.utils.Constants;

public class CreateAccountPageTest extends BaseTest {
	
	@BeforeClass
	public void CreateAccountPageSetUp() {
		createAccPage = mainpage.clickOnCreateAccountLink();
	}
	
	@Test (priority = 1)
	public void CreateAccountPageTitleTest() {
		String title = createAccPage.getPageTitle();
		Assert.assertEquals(title, Constants.CREAT_ACCOUNT_PAGE_TITLE);
	}
	
	@Test
	public void CreateAccountPageSubTitleTest() {
		String subTitle = createAccPage.getTitle();
		Assert.assertEquals(subTitle, Constants.CREAT_ACCOUNT_PAGE_TITLE);
	}
	
	@Test
	public void CreateAccountTest() {
		myAccountPage = createAccPage.createAccount("Jeet", "Patil", "jeet@gmail.com", "Jeet@123456");
		String username = myAccountPage.getLoginAccName();
		Assert.assertTrue(username.contains("Jeet Patil"));
	}
}
