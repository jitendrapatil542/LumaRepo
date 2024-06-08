package com.qa.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.luma.utils.ElementUtils;

public class CustomerLoginPage {
	
	private ElementUtils elementUtils;
	private WebDriver driver;
	
	//Default constructor-----------------------------------------
	public CustomerLoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}
	
	
	//Object repository for customer login page(Locators)---------
	private By Title = By.xpath("//h1/span");
	private By email = By.id("email");
	private By pass = By.id("pass");
	private By singInBtn = By.id("send2");
	private By forgotYourPassword = By.linkText("Forgot Your Password?");
	
	
	
	//Page actions------------------------------------------------
	public String getTitle() {
		return elementUtils.doGetText(Title);
	}
	
	public String getPageTitle() {
		return elementUtils.getPageTitle();
	}
	
	public boolean existanceOfForgotYourPasswordLink() {
		return elementUtils.isDisplay(forgotYourPassword);
	}
	
	public CustomerHomePage login(String emailID, String password) {
		elementUtils.doSendkeys(email, emailID);
		elementUtils.doSendkeys(pass, password);
		elementUtils.doClick(singInBtn);
		return new CustomerHomePage(driver);

	}
}
