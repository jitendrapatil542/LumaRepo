package com.qa.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.luma.utils.ElementUtils;

public class CreateAccountPage {
	private WebDriver driver;
	private ElementUtils elementUtils;

	//Default constructor-----------------------------------------
	public  CreateAccountPage(WebDriver driver) {
		elementUtils = new ElementUtils(driver);
	}
	
	
	//Object repository for create account page(Locators)---------
	private By Title = By.xpath("//h1/span");
	private By F_Name = By.id("firstname");
	private By L_Name = By.id("lastname");
	private By email_address = By.id("email_address");
	private By pwd = By.id("password");
	private By cnfmPwd = By.id("password-confirmation");
	private By createAccountBtn = By.xpath("//button[@title='Create an Account']");
	
	
	
	//Page actions------------------------------------------------
	public String getTitle() {
		return elementUtils.doGetText(Title);
	}
	
	public String getPageTitle() {
		return elementUtils.getPageTitle();
	}
	
	public MyAccountPage createAccount(String firstName, String lastName, String emailID, String password) {
		elementUtils.doSendkeys(F_Name, firstName);
		elementUtils.doSendkeys(L_Name, lastName);
		elementUtils.doSendkeys(email_address, emailID);
		elementUtils.doSendkeys(pwd, password);
		elementUtils.doSendkeys(cnfmPwd, password);
		elementUtils.doClick(createAccountBtn);
		return new MyAccountPage(driver); 
	}
	
	
	
	
	
}
