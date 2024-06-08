package com.qa.luma.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.luma.utils.ElementUtils;

public class ProductsPage {
	private WebDriver driver;
	private ElementUtils elementUtils;
	
	
	//Default constructor-----------------------------------------
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}
	
	
	//Object repository for customer login page(Locators)---------
	private By productsContainer = By.xpath("//ol[@class='products list items product-items']//img");
	private By filterStyle = By.xpath("//div[text()='Style']");
	private By filterStyle_HeavyDuty = By.linkText("Heavy Duty ");
	
	
	
	//Page actions------------------------------------------------
	public String getPageTitle() {
		return elementUtils.getPageTitle();
	}
	
	public Map<String, String> getProductsList() {
		Map<String, String> productinfo = new HashMap();
		List<WebElement> products =  elementUtils.getElements(productsContainer);
		for(WebElement e : products) {
			String prodName = e.getAttribute("alt");
			String prodImage = e.getAttribute("src");
			productinfo.put(prodName, prodImage);
		}
		return productinfo;
	}
	
	public void applyStyle_HeavyDutyFilter() {
		elementUtils.doClick(filterStyle);
		elementUtils.doClick(filterStyle_HeavyDuty);
	}
	
	public ProductPage selectFirstProductFromList() {
		elementUtils.doClick(productsContainer);
		return new ProductPage(driver);
	}
	
	

}
