package com.qa.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.luma.utils.ElementUtils;

public class CartPage {
	private WebDriver driver;
	private ElementUtils elementUtils;
	
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}
	
	private By proceedToCheckoutBtn = By.xpath("//span[text()='Proceed to Checkout']");
	
	public String getPageTitle() {
		return elementUtils.getPageTitle();
	}
	
	public CheckOutPage nevigateToCheckOutPage() {
		elementUtils.doClick(proceedToCheckoutBtn);
		return new CheckOutPage(driver);
	}
}
