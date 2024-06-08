package com.qa.luma.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.luma.base.BaseTest;
import com.qa.luma.utils.Constants;

public class MainPageTest extends BaseTest{
	
	@Test (priority = 1)
	public void homePageTitleTest() {
		String title = mainpage.getPageTitle();
		Assert.assertEquals(title, Constants.MAIN_PAGE_TITLE);
	}
	
	@Test (priority = 2)
	public void homePageLogoTest() {
		boolean logo = mainpage.isExistLogo();
		Assert.assertTrue(logo);
	}
	
	@Test (priority = 3)
	public void homePageSignInLinkPresentTest() {
		boolean signInLink = mainpage.isExistSignInLink();
		Assert.assertTrue(signInLink);
	}
	
	@Test (priority = 4)
	public void homePageCreateAccountLinkPresentTest() {
		boolean createAccountLink = mainpage.isExistCreateAccounLink();
		Assert.assertTrue(createAccountLink);
		
	}
	

}
