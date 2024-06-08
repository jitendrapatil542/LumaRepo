package com.qa.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.luma.utils.ElementUtils;

public class MyOrderPage {
	public ElementUtils elementUtils;
	
	
	//Default constructor-----------------------------------------
	public MyOrderPage(WebDriver driver) {
		elementUtils = new ElementUtils(driver);
	}
	
	
	//Object repository for customer login page(Locators)---------
	private By Title = By.xpath("//h1/span");
	
	
	
	//Page actions------------------------------------------------
	public String getTitle() {
		return elementUtils.doGetText(Title);
	}
		
	public String getPageTitle() {
		return elementUtils.getPageTitle();
	}
}
