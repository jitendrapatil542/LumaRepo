package com.qa.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.luma.utils.ElementUtils;

public class MainPage {	
	private WebDriver driver;
	private CustomerLoginPage customerLoginPage;
	private CreateAccountPage createAccountPage;
	public ElementUtils elementUtils;
	
	
	
	//Default constructor-----------------------------------------
		public MainPage(WebDriver driver) {
			this.driver = driver;
			elementUtils = new ElementUtils(driver);
		}
		
		
		
	//Object repository for customer login page(Locators)---------
	private	By signIn = By.linkText("Sign In");
	private	By createAccount = By.linkText("Create an Account");
	private	By search = By.id("search");
	private By logo = By.cssSelector(".logo img");
	
	
	
	//Page actions------------------------------------------------
	public boolean isExistSignInLink() {
		return elementUtils.isDisplay(signIn);
	}
	
	public boolean isExistCreateAccounLink() {
		return elementUtils.isDisplay(createAccount);
		
	}
	
	public String getPageTitle() {
		return elementUtils.getPageTitle();
	}
	
	public boolean isExistLogo() {
		return elementUtils.isDisplay(logo);
	}
	
	public CustomerLoginPage clickOnSigninLink() {
	 elementUtils.doClick(signIn);
	 customerLoginPage = new CustomerLoginPage(driver);
	 return customerLoginPage;
	}
	
	public CreateAccountPage clickOnCreateAccountLink() {
		elementUtils.doClick(createAccount);
		createAccountPage = new CreateAccountPage(driver);
		return createAccountPage;
	}
	
	public void searchProduct(String product) {
		elementUtils.doSendkeys(search, product);
	}
}
